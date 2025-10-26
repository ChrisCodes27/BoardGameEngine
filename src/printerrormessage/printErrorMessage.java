/**
 * Filename: printErrorMessage.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Oct-06
 * Description: A class for displaying various common error messages for the games
 */

package printerrormessage;

import java.util.*;

public class printErrorMessage{

    /**
     * Displays an error message if the menu item selected is not valid
     * @return void function
     */
    public void invalidMenuInput()
    {
        System.out.println("Invalid Input! Select a valid item from the menu  ");
    }

    /**
     * Displays an error message if the move selected is not valid
     * @return void function
     */
    public void invalidMove()
    {
        System.out.println("Invalid move! Select a valid move!");
        System.out.println();
    }

    /**
     * Displays an error message if the type of input is not valid (for moves, etc)
     * @return void function
     */
    public void invalidTypeInput(String type)
    {
        System.out.println("Invalid Input! Input a valid "+type+"!");
        System.out.println();
    }

    /**
     * Displays an error message if the fence placed is not valid
     * @return void function
     */
    public void fencePlaced(){
        System.out.println("A fence has already been placed here!");;
    }

    /**
     * Displays an error message if the fence placed blocks opponent
     * @return void function
     */
    public void invalidPath(){
        System.out.println("No Valid Path Available For your Opponent! Illegal move!");
    }
}