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
    DotsAndBoxesBoard board = new DotsAndBoxesBoard();

    public DotsAndBoxes()
    {
        // To initialize the dots and boxes player. Passing the value 2 for a two player game.
        super(2);
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
        boolean valid = false;
        boolean checkInput = false;

        System.out.println("Hello! Welcome to the Dots and Boxes game!");
        setPlayerCount(players.size());
        setPlayerName();
        assignColour();
        instruction.displayDotsAndBoxesInstructions();

        do{
            System.out.println();
            while (checkInput == false)
            {
                System.out.println("Please enter the level of the dots and boxes you would like to solve (rows x column) [2x2, 2x3, 3x3, .....]");
                s = inp.next();
                inp.nextLine();
                board.setSize(s);

                // To get the rows and columns from the inputting size of the board
                checkInput = board.setDimensions(s);
            }
            checkInput = false;

            // Initializing the board for the game with the size
            board.dotsBoard = new BoxTile[board.getRows()][board.getCols()];
            board.initializeBoard();
            System.out.println();
            board.printBoardState();

            // If the game has slots with no boxes claimed, the game must continue
            while (isGameDone == false)
            {
                // Checking if the current player in the iteration can make another move
                players.get(indexOfPlayer).move();
                switch(players.get(indexOfPlayer).choice.toUpperCase())
                {
                    // If the player wants to quit at any point during the game
                    case "QUIT":
                        isGameDone = true;
                        break;

                    default:     
                        players.get(indexOfPlayer).isMoveValid = board.makeMove(players.get(indexOfPlayer));
                        if(players.get(indexOfPlayer).isMoveValid == true) {
                            // If the player has another move (the player has claimed a box), check if the game is done
                            checkWhoWon();
                        }

                        else {
                            indexOfPlayer = getNextPlayer(indexOfPlayer);
                        }

                        // To display the stats of the game after every move
                        stats();
                        break;
                }

                for(DotsAndBoxesPlayer player: players) {
                    // Checking if a player has won the game if there is no tie
                    if(player.win == true) {
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
     * @param n of players for the game
     * @return void function
     */
    @Override
    public void initializePlayers(int n)
    {
        int i = 0;
        while(i < n) {
          players.add(new DotsAndBoxesPlayer());
          i++;
        }
    }
    
    /**
     * Checking if the game is done
     * @return void function
     */
    @Override
    public void checkWhoWon()
    {
        int maxNum = 0;
        int i = 0;
        int a = 0;

        earlyWin();
        
        // If the total number of boxes is equal to the size of the board (n*m)
        if (board.getTotalBoxes() == (board.getRows()*board.getCols()))
        {
            for(DotsAndBoxesPlayer player: players)
            {
                // Iterating through each player to see who won
                if (maxNum < player.getNumOfBoxes())
                {
                    maxNum = player.getNumOfBoxes();
                    i = players.indexOf(player);
                }

                // Else there is a tie
                else if (maxNum == player.getNumOfBoxes() && maxNum !=0)
                {
                    System.out.println("There is a tie!");
                    a = 1;
                    isGameDone = true;
                }
            }
            if(a == 0) {
                players.get(i).win = true;
                isGameDone = true;
            }
        }
    }

     /**
     * To stop the game if a player has claimed more than half of the boxes that can be made within the board
     * @return void function
     */
    public void earlyWin()
    {
        for(DotsAndBoxesPlayer player: players)
        {
            if (player.getNumOfBoxes() > (board.getRows()*board.getCols())/2)
            {
                players.get(players.indexOf(player)).win = true;
                isGameDone = true;
                break;
            }
        }

    }

    /**
     * Restoring the values of each player for the next round
     * @return void function
     */
    public void restore() {
        isGameDone = false;
        for(DotsAndBoxesPlayer player: players)
        {
            player.restore();
        }
    }

    /**
     * To display the stats of the game after every move made
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
}