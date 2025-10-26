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

@SuppressWarnings("unchecked")
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
            instruction.displayQuoridorInstructions();
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
}