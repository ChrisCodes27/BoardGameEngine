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

public class Quoridor extends Games<QuoridorPlayer>{
    Scanner inp = new Scanner(System.in);
    QuoridorBoard board = new QuoridorBoard();

    public Quoridor()
    {
        super(2); //To initialize the Quoridor players
        board.setSize("9x9"); //Setting the size of the board to 9x9
    }

    /**
     * Assigning a colour to each player in the games
     * @return void function
     */
    public void assignColour()
    {
        int i =0;
        for(QuoridorPlayer player: players)
        {
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
        String name = " ";
        char ch = 'N';
        String s;
        String move;
        boolean valid = false;
        boolean checkInput = false;

        System.out.println("Welcome to the Quoridor Game!");

        setPlayerCount(players.size());
        setPlayerName();
        setFencesforPlayer();
        assignColour();

        do{
            System.out.println();
            checkInput = board.setDimensions(board.getSize()); //to get the rows and columns from the inputting size of the board
            checkInput = false;
            board.dotsBoard = new BoxTile[board.getRows()][board.getCols()]; //initializing the board for the game with the size
            board.initializeBoard();
            displayInstructions();
            setPlayerPosition();
            int index = 0;

            System.out.println();

            board.printBoardState();
            while (isGameDone == false) //If the game has slots with no boxes claimed, the game must continue
            {
                players.get(index).move();
                switch(players.get(index).choice)
                {
                    case 1:
                        int[] currPos = getCurrentPosition(players.get(index));
                        board.legalMoves(currPos[0], currPos[1]);
                        board.edgeCaseMoves(currPos[0], currPos[1]);
                        while(checkInput == false)
                        {
                            printLegalMoves();
                            System.out.print("Enter your move: ");
                            move = inp.nextLine();
                            if(board.getLegalMovesList().contains(Integer.parseInt(move)))
                            {
                                board.makeMove(players.get(index), Integer.parseInt(move));
                                checkInput = true;
                                players.get(index).noOfMoves++;
                                index = getNextPlayer(index);
                            }
                            else{
                                error.invalidMove();
                            }
                            checkWhoWon();
                        }
                        board.getLegalMovesList().clear();
                        checkInput = false;
                        break;
                    case 2:
                        if(players.get(index).getFences() == 0)
                        {
                            System.out.println("You have run out of fences! Select a move!");
                        }
                        while(checkInput == false && players.get(index).getFences() > 0)
                        {
                            System.out.print("Enter the tile numbers and the direction of the wall you want to place: ");
                            move = inp.nextLine();
                            int i = 0;

                            if(board.setFence(move, players.get(index), i))
                            {
                                boolean validPath = findValidPath();
                                if(validPath == true)
                                {
                                    System.out.println("Fence placed!");
                                    checkInput = true;
                                    index = getNextPlayer(index);
                                }
                                else
                                {
                                    i = 1;
                                    board.setFence(move, players.get(index), i);
                                    checkInput = false;
                                }
                            }
                            else
                            {
                                error.invalidMove();
                            }
                        }
                        checkInput = false;
                        break;
                    case 3:
                        isGameDone = true;
                        break;
                    default:
                        players.get(index).invalidMove();
                        break;
                }
                if(isGameDone == true)
                {
                    break;
                }
                board.printBoardState();
                stats();
                }
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

                //p.playerPosition.setRow(i);
                //.playerPosition.setColumn(j);
                board.getLegalMovesList().clear();
                board.legalMoves(i, j);
                List<Integer> l = board.getLegalMovesList();

                if(p.winPos.getRow() == i)
                {
                    //p.playerPosition.copy(originalPos);
                    count++;
                    break;
                }

                for (int next: l)
                {
                    if(!visited.contains(next))
                    {
                        visited.add(next);
                        //board.makeMove(p, next);
                        queue.offer(next);
                    }
                }
            }
            //p.playerPosition.copy(originalPos);
        }
        board.getLegalMovesList().clear();
        System.out.print(count);
        if(count == players.size())
        {
            //System.out.println("Valid Path!");
            return true;
        }
        System.out.println("No Valid Path! Illegal move!");
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
                restore();
                System.out.println(player.getName() + " has won the game with "+player.noOfMoves+"!");
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