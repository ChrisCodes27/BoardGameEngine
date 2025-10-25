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
     * @return void  This method does not return any value.
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

        // Initializations
        setPlayerCount(players.size());
        setPlayerName();
        setFencesforPlayer();
        assignColour();

        do{
            System.out.println();
            // Gets the size and validate the board dimensions based on the size
            checkInput = board.setDimensions(board.getSize());

            // Reset the flag before continuing
            checkInput = false;

            // Initializing the board for the game with the size
            board.dotsBoard = new BoxTile[board.getRows()][board.getCols()];
            board.initializeBoard();
            displayInstructions();
            setPlayerPosition();
            System.out.println();
            board.printBoardState();

            // Continue the game loop until a player wins
            while (isGameDone == false)
            {
                // Gets player to make a move
                players.get(indexOfPlayer).move();

                // Switch case based on player's move
                switch(players.get(indexOfPlayer).choice) {
                    case 1:
                        // Made a position move
                        movePosition(checkInput);
                        break;

                    case 2:
                        // Player placed a fence
                        placeFence(checkInput);
                        break;

                    case 3:
                        // Player chooses quit condition
                        isGameDone = true;
                        break;

                    default:
                        // Handles invalid inputs
                        players.get(indexOfPlayer).invalidMove();
                        break;
                }

                //Exits loop if player chose QUIT
                if(isGameDone == true) {
                    break;
                }

                // Prints Current board status and status of the players fences and their positions
                System.out.println();
                board.printBoardState();
                stats();
                System.out.println();
            }

            // Restores the values for each of the players for the next round
            restore();

            // After quit, option to return to main menu to play another game
            System.out.print("Do you want to play another round? (Y/N):  ");
            ch = inp.next().charAt(0);
        } while(Character.toLowerCase(ch)=='y');
    }


    /**
     * Assigns the number of fences for each player and prints the number of fences assigned.
     * @returns void function
     */
    public void setFencesforPlayer()
    {
        for(QuoridorPlayer player : players)
        {
            player.setPlayerFences();
            System.out.println(player.getName()+":"+player.getFences());
        }
    }


    /**
     * Retrieves the current position of a specific player on the board.
     * @param player The player whose current position is being retrieved.
     * @return An integer array containing the player's row and column coordinates.
     */

    public int[] getCurrentPosition(QuoridorPlayer player)
    {
        int[] currPos = new int[2];

        // Gets row index and column index of the player passed to this function
        currPos[0] = player.playerPosition.getRow();
        currPos[1] = player.playerPosition.getColumn();
        return currPos;
    }


    /**
     * Initializing the players for the Quoridor game by creating player objects and adds them to the player list.
     * @return void function
     */
    @Override
    public void initializePlayers(int n)
    {
        int i = 0;
        while(i < n)
        {
            // Adds new player to game
            players.add(new QuoridorPlayer());
            i++;
        }
    }


    /**
     * Sets the position of each player on the board along with their respective win cases.
     * @return void function
     */
    public void setPlayerPosition()
    {
        int i = 0;
        for(QuoridorPlayer player : players)
        {
            // Setting players initial on the tile
            player.playerPiece.setValueOnTile(player.colour+player.getName().substring(0,1)+c.endColour);
            switch(i)
            {
                case 0:
                    // Initializing Player 1 position to start at the top middle cell
                    player.playerPosition = new Tile<>(0, ((board.getCols() - 1)/2));
                    board.playerPiecePosition[0][((board.getCols() - 1)/2)].piece.setValueOnTile(player.playerPiece.getValueOnTile());

                    // Assigns Player 1's winning position
                    player.winPos = new Tile<>(board.getRows()-1, -1);
                    break;

                case 1:
                    // Initializing Player 2 position to start at the botton middle cell
                    player.playerPosition = new Tile<>(board.getRows()-1, ((board.getCols() - 1)/2));
                    board.playerPiecePosition[board.getRows()-1][((board.getCols() - 1)/2)].piece.setValueOnTile(player.playerPiece.getValueOnTile());

                    // Assigns Player 1's winning position
                    player.winPos = new Tile<>(0, -1);               
                    break;
            }
            i++;
        }
    }

    /**
     * Prints the list of all currently available legal moves for each active player.
     * @return void function
     */
    public void printLegalMoves()
    {
        System.out.print("These are your legal moves:  ");

        // Iterates through the list of legal moves available
        for(int l: board.getLegalMovesList()) {
            System.out.print(l + "  ");
        }
        System.out.println();
    }

    /**
     * Breadth First Search (BFS) to check whether each player from their current position still has a valid path to their wiinning side.
     * @return boolean function
     */
    public boolean findValidPath()
    {
        // Count to keep track whether each player has a valid path to win side
        int count = 0;

        // Iterates through the players
        for (QuoridorPlayer p: players)
        {
            // Calculates current position of each player
            int start = ((p.playerPosition.getRow())*board.getCols())+p.playerPosition.getColumn() + 1;

            // Queue created to manage tiles to be explored during BFS and Create a list to keep track of all tiles that have already been visited
            Queue<Integer> queue = new LinkedList<>();
            List<Integer> visited = new ArrayList<>();
            queue.offer(start);
            visited.add(start);

            // Performs BFS traversal to find a path to the winning row
            while(!queue.isEmpty())
            {
                int current = queue.poll();

                // Finds the index value by using the value on the tile
                int i = (current - 1)/board.getRows();
                int j = (current - 1)%board.getCols();

                // Resets Legal moves list to be empty
                board.getLegalMovesList().clear();

                // Finds the new legal moves from the current position
                board.legalMoves(i, j);
                List<Integer> l = board.getLegalMovesList();

                // Count increments if the player's goal row is reached
                if(p.winPos.getRow() == i) {
                    count++;
                    break;
                }

                // Explores all reachable neighboring tiles
                for (int next: l) {
                    if(!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
        }

        board.getLegalMovesList().clear();

        // Returns true ONLY when count is equal to number of players, as a valid pth was found for both
        if(count == players.size()) {
            return true;
        }

        // Handles exception and will not allow player to block opponent
        error.invalidPath();
        return false;
    }

    /**
     * Displays the current statistics of the game (fences of each player)
     * @returns void function.
     */
    @Override
    public void stats()
    {
        System.out.println();
        System.out.println(" ------------------------------------------");
        System.out.print("|"+ "\033[1;31;47m");
        for(QuoridorPlayer player: players) {
            System.out.print(player.getName()+"'s fences: "+player.getFences());
            System.out.print("      ");
        }
        System.out.print("\033[0m"+"|");
        System.out.println();
        System.out.println(" ------------------------------------------");
    }

    /**
     * Restoring the values of each player for the next round
     * @return void function
     */
    public void restore()
    {
        // Resets players values
        isGameDone = false;
        for(QuoridorPlayer player: players) {
            player.restore();
        }
    }

    /**
     * Handles a player's move action
     * @param checkInput Boolean flag indicating whether the input is valid.
     * @return void function
     */
    public void movePosition(boolean checkInput){
        String move = "";
        int[] currPos = getCurrentPosition(players.get(indexOfPlayer));

        // Generates possible moves from player's current position, with edge cases
        board.legalMoves(currPos[0], currPos[1]);
        board.edgeCaseMoves(currPos[0], currPos[1]);

        while(!checkInput)
        {
            printLegalMoves();
            System.out.print("Enter your move: ");
            move = inp.nextLine();

            try {
                int moveNum = Integer.parseInt(move);

                // Checks if entered move is valid by checking if it is one of the available legal moves
                if (board.getLegalMovesList().contains(moveNum)) {
                    board.makeMove(players.get(indexOfPlayer), moveNum);
                    checkInput = true;

                    // Tracks total number of moves
                    players.get(indexOfPlayer).noOfMoves++;

                    // Switches plyers
                    indexOfPlayer = getNextPlayer(indexOfPlayer);
                } else {
                    // Handles exception cases of wrong input
                    error.invalidMove();
                }
            } catch (NumberFormatException e) {
                // Handles wrong input type
                error.invalidTypeInput("legal move from the list provided ");
            }
            // Checks whether player has won
            checkWhoWon();
        }

        // legal list is reset
        board.getLegalMovesList().clear();
        checkInput = false;
    }

    /**
     * Handles a player's action to place a fence on the board.
     * @param checkInput Boolean flag used to track valid input.
     * @return void function
     */
    public void placeFence(boolean checkInput){
        String move;

        // If player has no fences left, will not allow to place a fence
        if(players.get(indexOfPlayer).getFences() == 0) {
            System.out.println("You have run out of fences! Select a move!");
        }

        // Checks if players fence will block off the opponent or itself
        while(checkInput == false && players.get(indexOfPlayer).getFences() > 0)
        {
            System.out.print("Enter the tile numbers and the direction of the wall you want to place: ");
            move = inp.nextLine();
            int i = 0;

            // Try placing the fence at the given position
            if(board.setFence(move, players.get(indexOfPlayer), i))
            {
                // Fence placement if valid path exists for both players
                boolean validPath = findValidPath();
                if(validPath == true) {
                    System.out.println("Fence placed!");
                    System.out.println();
                    checkInput = true;
                    indexOfPlayer = getNextPlayer(indexOfPlayer);
                }

                // Will undo the fence placed if it was an invalid move
                else {
                    i = 1;
                    board.setFence(move, players.get(indexOfPlayer), i);
                    checkInput = false;
                }
            }

            // Handeles exception errors
            else {
                error.invalidMove();
            }
        }
        checkInput = false;
    }


    /**
     * Checks whether has reached their goal side
     * @return void function
     */
    @Override
    public void checkWhoWon()
    {
        for( QuoridorPlayer player : players)
        {
            // Checks if the players row matches their goal side
            if(player.winPos.getRow() == player.playerPosition.getRow())
            {
                // Updates the flag to game will be done
                isGameDone = true;
                board.printBoardState();
                System.out.println(player.getName() + " has won the game with " + player.noOfMoves + " moves !");
                System.out.println();
                break;
            }
        }
    }
}