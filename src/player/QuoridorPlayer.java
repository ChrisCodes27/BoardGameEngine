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

    public void setPlayerFences()
    {
        fences = 3;
    }

    public void decreaseFences()
    {
        fences--;
    }

    public int getFences()
    {
        return fences;
    }

    public void restore()
    {
        setPlayerFences();
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
        System.out.println("-----------------------------------------------------");
        System.out.println("    1. Move your position in the board");
        System.out.println("    2. Place a wall");
        System.out.println("    3. Quit");
        System.out.print("Enter your choice (1-3):  ");
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
        System.out.println("That is an invalid choice! Select a valid choice from the menu!");
        move();
    }
}