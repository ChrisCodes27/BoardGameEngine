/**
 * Filename: PuzzlePlayer.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Sept-14
 * Description: A player class for Sliding Puzzle which extends from the abstract player class. Has functions specific
 * to Sliding Puzzle.
 */

package player;

import java.util.*;
import printerrormessage.printErrorMessage;

public class QuoridorPlayer extends Player{
    private int fences;
    Scanner inp = new Scanner(System.in);
    printErrorMessage error = new printErrorMessage();

    /**
     * Represents a Quoridor player with fences, moves, and status.
     * @returns void function
     */
    public QuoridorPlayer()
    {
        this.win = false;
        this.fences = 0;
        this.noOfMoves=0;
    }

    /**
     * Sets initial number of fences for the player.
     * @return void function
     */
    public void setPlayerFences() {
        fences = 10;
    }

    /** Decreases fence count by one after placing a fence.
     * @return void function
     */
    public void decreaseFences()
    {
        fences--;
    }

    /**
     * Returns current number of fences left
     * @return int function
     */
    public int getFences()
    {
        return fences;
    }

    public void restore()
    {
        setPlayerFences();
    }

    /**
     * To get the input from the user which contains value of the tile that want to move
     * @return void function
     */
    @Override
    public void move()
    {
        // Takes players next move
        boolean flag = true;
        System.out.println(getName() + ", Make your move: ");
        while (flag) {
            System.out.println("-----------------------------------------------------");
            System.out.println("    1. Move your position in the board");
            System.out.println("    2. Place a wall");
            System.out.println("    3. Quit");
            System.out.print("Enter your choice (1-3):  ");
            try {
                choice = inp.nextInt();
                flag = false;
            } catch (InputMismatchException e) {

                // Handles Exception cases
                inp.nextLine();
                error.invalidMove();
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
        System.out.println("That is an invalid choice! Select a valid choice from the menu!");
        move();
    }
}