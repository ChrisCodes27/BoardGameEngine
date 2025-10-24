/**
 * Filename: PuzzlePlayer.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Sept-14
 * Description: A player class for Sliding Puzzle which extends from the abstract player class. Has functions specific
 * to Sliding Puzzle.
 */

package player;

import board.Tile;
import board.Board;
import java.util.*;

public class QuoridorPlayer extends Player{
    Scanner inp = new Scanner(System.in);
    private int fences;

    public QuoridorPlayer()
    {
        this.win = false;
        this.fences = 0;
        this.noOfMoves=0;
    }

    public void setPlayerFences(int n)
    {
        if (n == 2)
        {
            fences = 10;
        }
        else if (n == 4)
        {
            fences = 5;
        }
    }

    public int getFences()
    {
        return fences;
    }

    /**
     * to get the input from the user which contains value of the tile that want to move
     * @param No parameters
     * @return void function
     */
    @Override
    public void move()
    {
        System.out.println(getName() + ", Make your move: ");
        System.out.println("1. Move your position in the board");
        System.out.println("2. Place a wall");
        choice = inp.nextInt();

    }

    /**
     * To display an error message if the input of the player is not a valid one
     * @param No parameters
     * @return void function
     */
    @Override
    public void invalidMove()
    {
        System.out.println("Thats an invalid choice! Select a valid choice from the menu!");
        move();
    }
}