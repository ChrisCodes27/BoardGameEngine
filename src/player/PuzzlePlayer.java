/**
 * Filename: PuzzlePlayer.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Sept-14
 * Description: A player class for Sliding Puzzle which extends from the abstract player class. Has functions specific
 * to Sliding Puzzle.
 */

package player;

import board.Tile;
import board.PuzzleBoard;
import board.Board;


import java.util.*;

public class PuzzlePlayer extends Player{
    Scanner inp = new Scanner(System.in);

    /**
     * Constructor for PuzzlePlayer.
     * Initializes the win status to false and number of moves to zero.
     */
    public PuzzlePlayer()
    {
        this.win = false;
        this.noOfMoves=0;
    }

    /**
     * Prompts the player to enter the tile number they want to move.
     * @return void function
     */
    @Override
    public void move()
    {
        boolean flag = true;

        // Loop flag to continue until valid input is provided
        while(flag) {
            try {
                System.out.println("Enter the tile number that you want to move:");
                choice = inp.nextInt();

                // Resets flag to exit after valid input
                flag = false;
            }
            catch (InputMismatchException e) {
                // Clears the invalid input and displays error message
                inp.nextLine();
                invalidMove();
            }
        }
    }

    /**
     * To display an error message if the input of the player is not a valid one
     * @return void function
     */
    @Override
    public void invalidMove()
    {
        System.out.println("Thats an invalid move! Select a tile adjacent to the empty slot");
    }
}