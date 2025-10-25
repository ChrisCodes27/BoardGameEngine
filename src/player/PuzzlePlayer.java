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

    public PuzzlePlayer()
    {
        this.win = false;
        this.noOfMoves=0;
    }

    /**
     * to get the input from the user which contains value of the tile that want to move
     * @param No parameters
     * @return void function
     */
    @Override
    public void move()
    {
        boolean flag = true;
        while(flag)
        {
            try
            {
            System.out.println("Enter the tile number that you want to move:");
            choice = inp.nextInt();
            flag = false;
            }
            catch (InputMismatchException e)
            {
                inp.nextLine();
                invalidMove();
            }
        }
    }

    /**
     * To display an error message if the input of the player is not a valid one
     * @param No parameters
     * @return void function
     */
    @Override
    public void invalidMove()
    {
        System.out.println("Thats an invalid move! Select a tile adjacent to the empty slot");
    }
}