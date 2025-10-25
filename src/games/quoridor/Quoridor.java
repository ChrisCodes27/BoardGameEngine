/**
 * Filename: DotsAndBoxes.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Oct-02
 * Description: A central class for the Dots and Boxes game. Extends the Games class.
 */

package games.quoridor;

import java.util.*;
import board.QuoridorBoard;
import board.*;
import player.QuoridorPlayer;
import games.Games;

import javax.swing.*;

public class Quoridor extends Games<QuoridorPlayer> {
    Scanner inp = new Scanner(System.in);
    QuoridorBoard board = new QuoridorBoard();

    public Quoridor() {
        // To initialize the Quoridor players
        super(2);

        // Setting the size of the board to 9x9
        board.setSize("9x9");
    }

    /**
     * Assigning a colour to each player in the games
     * @return void function
     */
    public void assignColour()
    {
        int i = 0;
        for(QuoridorPlayer player: players) {
            player.colour = c.colours.get(i);
            i++;
        }
    }

    /**
     * The starting point of the game
     * @return void function
     */
    @Override
    public void startGame()
    {
        char ch = 'N';
        boolean checkInput = false;
        System.out.println("Welcome to the Quoridor Game!");
        System.out.println();
        setPlayerCount(players.size());
        setPlayerName();
        setFencesforPlayer();
        assignColour();

        do{
            System.out.println();
            // Gets and validate the board dimensions based on the selected size
            checkInput = board.setDimensions(board.getSize());
            checkInput = false;

            // Initializing the board for the game with the size
            board.dotsBoard = new BoxTile[board.getRows()][board.getCols()];
            board.initializeBoard();
            displayInstructions();
            setPlayerPosition();
            System.out.println();
            board.printBoardState();

            // If the game has slots with no boxes claimed, the game must continue
            while (isGameDone == false)
            {
                players.get(indexOfPlayer).move();
                switch(players.get(indexOfPlayer).choice)
                {
                    case 1:
                        movePosition(checkInput);
                        break;
                    case 2:
                        placeFence(checkInput);
                        break;
                    case 3:
                        isGameDone = true;
                        break;
                    default:
                        players.get(indexOfPlayer).invalidMove();
                        break;
                }
                if(isGameDone == true)
                {
                    break;
                }
                System.out.println();
                board.printBoardState();
                stats();
            }
            restore();
            System.out.print("Do you want to play another round? (Y/N):  ");
            ch = inp.next().charAt(0);
        }while(Character.toLowerCase(ch)=='y');
    }

    public void setFencesforPlayer()
    {
        for(QuoridorPlayer player : players)
        {
            player.setPlayerFences();
            System.out.println(player.getName()+":"+player.getFences());
        }
    }

    public int[] getCurrentPosition(QuoridorPlayer player)
    {
        int[] currPos = new int[2];
        currPos[0] = player.playerPosition.getRow();
        currPos[1] = player.playerPosition.getColumn();
        return currPos;
    }

    /**
     * Initializing the players for the dots and boxes game
     * @return void function
     */
    @Override
    public void initializePlayers(int n)
    {
        int i = 0;
        while(i < n)
        {
            players.add(new QuoridorPlayer());
            i++;
        }
    }

    public void setPlayerPosition()
    {
        int i = 0;
        for(QuoridorPlayer player : players)
        {
            player.playerPiece.setValueOnTile(player.colour+player.getName().substring(0,1)+c.endColour);
            switch(i)
            {
                case 0:
                    player.playerPosition = new Tile<>(0, ((board.getCols() - 1)/2));
                    board.playerPiecePosition[0][((board.getCols() - 1)/2)].piece.setValueOnTile(player.playerPiece.getValueOnTile());
                    player.winPos = new Tile<>(board.getRows()-1, -1);
                    break;
                case 1:
                    player.playerPosition = new Tile<>(board.getRows()-1, ((board.getCols() - 1)/2));
                    board.playerPiecePosition[board.getRows()-1][((board.getCols() - 1)/2)].piece.setValueOnTile(player.playerPiece.getValueOnTile());    
                    player.winPos = new Tile<>(0, -1);               
                    break;
            }
            i++;
        }
    }

    public void printLegalMoves()
    {
        System.out.print("These are your legal moves: ");
        for(int l: board.getLegalMovesList())
        {
            System.out.print(l + "  ");
        }
        System.out.println();
    }

    public boolean findValidPath()
    {
        int count = 0;
        for (QuoridorPlayer p: players)
        {
            //Tile originalPos = new Tile<>(p.playerPosition);
            //originalPos.copy(p.playerPosition);
            int start = ((p.playerPosition.getRow())*board.getCols())+p.playerPosition.getColumn() + 1;
            Queue<Integer> queue = new LinkedList<>();
            List<Integer> visited = new ArrayList<>();

            queue.offer(start);
            visited.add(start);

            while(!queue.isEmpty())
            {
                int current = queue.poll();

                int i = (current - 1)/board.getRows();
                int j = (current - 1)%board.getCols();

                board.getLegalMovesList().clear();
                board.legalMoves(i, j);
                List<Integer> l = board.getLegalMovesList();

                if(p.winPos.getRow() == i)
                {
                    count++;
                    break;
                }

                for (int next: l)
                {
                    if(!visited.contains(next))
                    {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
        }
        board.getLegalMovesList().clear();
        if(count == players.size())
        {
            return true;
        }
        error.invalidPath();
        return false;
    }
    
    @Override
    public void stats()
    {
        System.out.println();
        //board.printBoardState();
        System.out.println(" ---------------------------------------");
        System.out.print("|"+ "\033[1;31;47m");
        for(QuoridorPlayer player: players)
        {
            System.out.print(player.getName()+"'s fences: "+player.getFences());
            System.out.print("      ");
        }
        System.out.print("\033[0m"+"|");
        System.out.println();
        System.out.println(" ---------------------------------------");
    }

    /**
     * Restoring the values of each player for the next round
     * @param No parameters
     * @return void function
     */
    public void restore()
    {
        isGameDone = false;
        for(QuoridorPlayer player: players)
        {
            player.restore();
        }
    }

    public void movePosition(boolean checkInput){
        String move = "";
        int[] currPos = getCurrentPosition(players.get(indexOfPlayer));
        board.legalMoves(currPos[0], currPos[1]);
        board.edgeCaseMoves(currPos[0], currPos[1]);
        while(!checkInput)
        {
            printLegalMoves();
            System.out.print("Enter your move: ");
            move = inp.nextLine();
            try {
                int moveNum = Integer.parseInt(move);

                if (board.getLegalMovesList().contains(moveNum)) {
                    board.makeMove(players.get(indexOfPlayer), moveNum);
                    checkInput = true;
                    players.get(indexOfPlayer).noOfMoves++;
                    indexOfPlayer = getNextPlayer(indexOfPlayer);
                } else {
                    error.invalidMove();
                }
            } catch (NumberFormatException e) {
                error.invalidTypeInput("legal move from the list provided ");
            }
            checkWhoWon();
        }
        board.getLegalMovesList().clear();
        checkInput = false;
    }

    public void placeFence(boolean checkInput){
        String move;
        if(players.get(indexOfPlayer).getFences() == 0)
        {
            System.out.println("You have run out of fences! Select a move!");
        }
        while(checkInput == false && players.get(indexOfPlayer).getFences() > 0)
        {
            System.out.print("Enter the tile numbers and the direction of the wall you want to place: ");
            move = inp.nextLine();
            int i = 0;

            if(board.setFence(move, players.get(indexOfPlayer), i))
            {
                boolean validPath = findValidPath();
                if(validPath == true)
                {
                    System.out.println("Fence placed!");
                    checkInput = true;
                    indexOfPlayer = getNextPlayer(indexOfPlayer);
                }
                else
                {
                    i = 1;
                    board.setFence(move, players.get(indexOfPlayer), i);
                    checkInput = false;
                }
            }
            else
            {
                error.invalidMove();
            }
        }
        checkInput = false;
    }
    /**
     * To display the stats of the game after every move made
     * @param No parameters
     * @return void function
     */

    /**
     * To display the instructions on how to play the game to the users
     * @return void function
     */

    @Override
    public void checkWhoWon()
    {
        for( QuoridorPlayer player : players)
        {
            if(player.winPos.getRow() == player.playerPosition.getRow())
            {
                isGameDone = true;
                board.printBoardState();
                System.out.println(player.getName() + " has won the game with " + player.noOfMoves + " moves !");
                System.out.println();
                break;
            }
        }
    }

    @Override
    public void displayInstructions()
    {
        System.out.println("\u001B[31m------------------------------------------\u001B[0m");
        System.out.println("\033[1;31;47m              QUORIDOR            \033[0m");
        System.out.println("\u001B[31m------------------------------------------\u001B[0m");
        System.out.println();
        System.out.println("GOAL: Reach the opposite side of the board before your opponent! Each player moves their pawn across the 9x9 grid while strategically placing walls to block the other player’s path.");
        System.out.println();
        System.out.println("\u001B[31mHOW TO PLAY:\u001B[0m");
        System.out.println();
        System.out.println("1. The board is labeled with numbers from 1 to 81, representing each tile position.");
        board.printBoardExample();
        System.out.println("2. On your turn, you are given two options:");
        System.out.println("   +> Make Your Move : Move your pawn to a valid adjacent tile by entering its tile number.");
        System.out.println("     Example:");
        System.out.println("        These are your legal moves: 14  6  4 ");
        System.out.println("        Enter your move: 14  moves your pawn to tile 46.");
        System.out.println();
        System.out.println("   +> Place a wall: You may place a wall between two adjacent tiles to block your opponent’s path.");
        System.out.println("     Walls can be placed horizontally or vertically, using the direction 'U' (up) or 'D' (down).");
        System.out.println("     Example:");
        System.out.println("        Enter move: 45 46 U  → places a horizontal wall above tiles 45 and 46.");
        System.out.println("        Enter move: 1 10 D   → places a vertical wall below tiles 1 and 10.");
        System.out.println();
        System.out.println("3. An option to quit will always be present during the players move.");
        System.out.println("4. You will not be allowed to completely block your opponents path towards the goal, just enough to mildly irritate them.");
        System.out.println();
        System.out.println(" MAY THE BEST PLAYER WIN!");
        System.out.println();
        System.out.println("\u001B[31m--------------------------------------------------------------------------------\u001B[0m");
    }
}