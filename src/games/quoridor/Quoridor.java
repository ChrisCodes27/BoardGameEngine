/**
 * Filename: DotsAndBoxes.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Oct-02
 * Description: A central class for the Dots and Boxes game. Extends the Games class.
 */

package games.quoridor;

import java.util.*;
import board.QuoridorBoard;
import board.BoxTile;
import player.QuoridorPlayer;
import games.Games;
import colour.colour;

public class Quoridor extends Games<QuoridorPlayer>{
    Scanner inp = new Scanner(System.in);
    QuoridorBoard board = new QuoridorBoard();

    public Quoridor(int numPlayers)
    {
        super(numPlayers); //To initialize the Quoridor players
    }

    /**
     * Assigning a colour to each player in the game.
     * @param No parameters
     * @return void function
     */
    public void assignColour()
    {
        colour c = new colour();
        int i =0;
        for(QuoridorPlayer player: players)
        {
            // player.colour = c.colours.get(i);
            // i++;
        }
    }

    /**
     * The starting point of the game
     * @param No parameters
     * @return void function
     */
    @Override
    public void startGame()
    {
        String name = " ";
        char ch = 'N';
        String s;
        boolean valid = false;
        boolean checkInput = false;

        //setPlayerCount(2);
        setPlayerName();
        setFencesforPlayer();
        assignColour();
        displayInstructions();

        do{
            System.out.println();
            board.setSize("9x9");
            checkInput = board.setDimensions(board.getSize()); //to get the rows and columns from the inputting size of the board
            //checkInput = false;
            board.dotsBoard = new BoxTile[board.getRows()][board.getCols()]; //initializing the board for the game with the size
            board.initializeBoard();
            System.out.println();
            board.printBoardState();
            while (isGameDone == false) //If the game has slots with no boxes claimed, the game must continue
            {
                for(QuoridorPlayer player: players) //iterating through the list of players
                {
    
                }

            }
            System.out.println("Do you want to play another round? (Y/N)");
            ch = inp.next().charAt(0);
            //restore();
        }while(Character.toLowerCase(ch)=='y');
    }

    public void setFencesforPlayer()
    {
        for(QuoridorPlayer player : players)
        {
            player.setPlayerFences(players.size());
            System.out.println(player.getName()+":"+player.getFences());        
        }
    }

    /**
     * Initializing the players for the dots and boxes game
     * @param number of players for the game
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
    
    /**
     * Checking if the game is done
     * @param No parameters
     * @return void function
     */
    // public void checkWhoWon()
    // {
    //     int maxNum = 0;
    //     int i = 0;
    //     int a = 0;
        
    //     // if (board.getTotalBoxes() == (board.getRows()*board.getCols())) //if the total number of boxes is equal to the size of the board (n*m)
    //     // {
    //     // for(DotsAndBoxesPlayer player: players)
    //     // {
           

    //     // }
    //     // if(a == 0)
    //     // {
    //     //     players.get(i).win = true;
    //     //     isGameDone = true;
    //     // }
    //     // }
    // }

    /**
     * Restoring the values of each player for the next round
     * @param No parameters
     * @return void function
     */
    // public void restore()
    // {
    //     isGameDone = false;
    //     for(DotsAndBoxesPlayer player: players)
    //     {
    //         player.restore();
    //     }
    // }

    /**
     * To display the stats of the game after every move made
     * @param No parameters
     * @return void function
     */
    // public void stats()
    // {
    //     System.out.println();
    //     board.printBoardState();
    //     System.out.println();
    //     System.out.println(" -------------------------------------------------------------");
    //     System.out.print("|"+ "\033[1;31;47m"+players.get(0).getName()+"'s boxes: "+players.get(0).getNumOfBoxes());
    //     System.out.print("      "+ players.get(1).getName()+"'s boxes: "+players.get(1).getNumOfBoxes());
    //     System.out.println("       Total boxes :" + board.getTotalBoxes() +"          \033[0m"+"|");
    //     System.out.println(" -------------------------------------------------------------");
    // }

    /**
     * To display the instructions on how to play the game to the users
     * @param No parameters
     * @return void function
     */
    @Override
    public void displayInstructions()
    {
        System.out.println("\u001B[31m------------------------------------------\u001B[0m");
        System.out.println("\033[1;31;47m              DOTS AND BOXES            \033[0m");
        System.out.println("\u001B[31m------------------------------------------\u001B[0m");
        System.out.println();
        System.out.println("GOAL: Complete more boxes than your opponent by drawing lines between dots. Each box completed with the 4th edge earns you one point!");
        System.out.println();
        System.out.println("\u001B[31mHOW TO PLAY:\u001B[0m");
        System.out.println("1. The board is labeled with letters for rows and columns (A, B, C, ...). For example, the coordinates of the first tile in the board is AA.");
        //board.printExampleBoard(); //to print an example of how the dots and board board is
        System.out.println();
        System.out.println("Each tile in the board has four different directions - UP (U), DOWN (D), LEFT (L) and RIGHT (R)");   
        System.out.println("2. To mark an edge of each tile, type the coordinates of the box and the direction in which you want to draw the line.");
        System.out.println("   Example:");
        System.out.println("      Enter move: AA L  → draws a vertical line on the left of the tile AA.");
        System.out.println("      Enter move: AB U  → draws a horizontal line on the top of the tile AB.");
        System.out.println();
        System.out.println("3. Completing a box earns you a point and another turn!");
        System.out.println("4. If you want to quit the game at any point, please type 'QUIT'");
        System.out.println("When all boxes in the board are filled, the player with the most boxes wins.");
        System.out.println();
        System.out.println("\u001B[31m------------------------------------------\u001B[0m");
    }    
}