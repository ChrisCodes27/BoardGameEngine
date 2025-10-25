/**
 * Filename: DotsAndBoxes.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Oct-02
 * Description: A central class for the Dots and Boxes game. Extends the Games class.
 */

package games.dotsandboxes;

import java.util.*;
import board.DotsAndBoxesBoard;
import board.BoxTile;
import player.DotsAndBoxesPlayer;
import games.Games;
import colour.colour;

public class DotsAndBoxes extends Games<DotsAndBoxesPlayer>{
    Scanner inp = new Scanner(System.in);
    DotsAndBoxesBoard board = new DotsAndBoxesBoard();

    public DotsAndBoxes()
    {
        super(2); //To initialize the dots and boxes player. Passing the value 2 for a two player game.
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
        for(DotsAndBoxesPlayer player: players)
        {
            player.colour = c.colours.get(i);
            i++;
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

        System.out.println("Hello! Welcome to the Dots and Boxes game!");
        setPlayerCount(2);
        setPlayerName();
        assignColour();
        displayInstructions();

        do{
            System.out.println();
            while (checkInput == false)
            {
                System.out.println("Please enter the level of the dots and boxes you would like to solve (rows x column) [2x2, 2x3, 3x3, .....]");
                s = inp.next();
                inp.nextLine();
                board.setSize(s);
                checkInput = board.setDimensions(s); //to get the rows and columns from the inputting size of the board
            }
            checkInput = false;
            board.dotsBoard = new BoxTile[board.getRows()][board.getCols()]; //initializing the board for the game with the size
            board.initializeBoard();
            System.out.println();
            board.printBoardState();
            while (isGameDone == false) //If the game has slots with no boxes claimed, the game must continue
            {
                for(DotsAndBoxesPlayer player: players) //iterating through the list of players
                {
                    while (player.isMoveValid == true && isGameDone == false) { //checking if the current player in the iteration can make another move
                        //player.invalidMove();
                        player.move();
                        switch(player.choice.toUpperCase())
                        {
                            case "QUIT":   //if the player wants to quit at any point during the game
                                isGameDone = true;
                                break;
                            default:     
                                player.isMoveValid = board.makeMove(player);
                                if(player.isMoveValid == true)
                                {
                                    checkWhoWon(); //if the player has another move (the player has claimed a box), check if the game is done
                                }
                                stats(); //to display the stats of the game after every move
                                break;
                        }
                    }
                    if(isGameDone == true) //to stop the game from moving on to the next player if the game is done
                    {
                        player.isMoveValid = false;
                        continue;
                    }
                    else
                    {
                    player.isMoveValid = true;
                    }
                }

                for(DotsAndBoxesPlayer player: players)
                {
                    if(player.win == true) //checking if a player has won the game if there is no tie
                    {
                        System.out.println(player.getName()+" has won the game!");
                    }
                }
                checkWhoWon();
            }
            System.out.println("Do you want to play another round? (Y/N)");
            ch = inp.next().charAt(0);
            restore();
        }while(Character.toLowerCase(ch)=='y');
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
          players.add(new DotsAndBoxesPlayer());
          i++;
        }
    }
    
    /**
     * Checking if the game is done
     * @param No parameters
     * @return void function
     */
    @Override
    public void checkWhoWon()
    {
        int maxNum = 0;
        int i = 0;
        int a = 0;
        
        if (board.getTotalBoxes() == (board.getRows()*board.getCols())) //if the total number of boxes is equal to the size of the board (n*m)
        {
        for(DotsAndBoxesPlayer player: players)
        {
            if (maxNum < player.getNumOfBoxes()) //iterating through each player to see who won
            {
                maxNum = player.getNumOfBoxes();
                i = players.indexOf(player);
            }

            else if (maxNum == player.getNumOfBoxes() && maxNum !=0) //else there is a tie
            {
                System.out.println("There is a tie!");
                a = 1;
                isGameDone = true;
            }
        }
        if(a == 0)
        {
            players.get(i).win = true;
            isGameDone = true;
        }
        }
    }

    /**
     * Restoring the values of each player for the next round
     * @param No parameters
     * @return void function
     */
    public void restore()
    {
        isGameDone = false;
        for(DotsAndBoxesPlayer player: players)
        {
            player.restore();
        }
    }

    /**
     * To display the stats of the game after every move made
     * @param No parameters
     * @return void function
     */
    @Override
    public void stats()
    {
        System.out.println();
        board.printBoardState();
        System.out.println(" -----------------------------------------------------------------");
        System.out.print("|"+ "\033[1;31;47m");
        for(DotsAndBoxesPlayer player: players)
        {
            System.out.print(player.getName()+"'s boxes: "+player.getNumOfBoxes());
            System.out.print("      ");
        }
        System.out.print("       Total boxes :" + board.getTotalBoxes() +"          \033[0m"+"|");
        System.out.println();
        System.out.println(" ------------------------------------------------------------------");
    }

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
        board.printExampleBoard(); //to print an example of how the dots and board board is
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