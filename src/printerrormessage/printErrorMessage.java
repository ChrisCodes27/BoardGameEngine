/**
 * Filename: printErrorMessage.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Oct-06
 * Description: A class for displaying various common error messages for the games
 */

package printerrormessage;

import java.util.*;
import colour.colour;

public class printErrorMessage{

    colour c = new colour();
    public String errorStatement;

    /**
     * Displays an error message if the menu item selected is not valid
     * @return void function
     */
    public void invalidMenuInput()
    {
        errorStatement = "Invalid Input! Select a valid item from the menu  ";
        print(errorStatement);
    }

    /**
     * Displays an error message if the move selected is not valid
     * @return void function
     */
    public void invalidMove()
    {
        errorStatement = "Invalid move! Select a valid move!";
        print(errorStatement);
    }

    /**
     * Displays an error message if the type of input is not valid (for moves, etc)
     * @return void function
     */
    public void invalidTypeInput(String type)
    {
        errorStatement = "Invalid Input! Input a valid " + type;
        print(errorStatement);
    }

    /**
     * Displays an error message if the fence placed is not valid
     * @return void function
     */
    public void fencePlacement(){
        errorStatement = "Invalid Placement! Select a valid fence position!";
        print(errorStatement);
    }

    /**
     * Displays an error message if the fence placed blocks opponent
     * @return void function
     */
    public void invalidPath(){
        errorStatement = "No Valid Path Available For your Opponent! Illegal move!";
        print(errorStatement);
    }

    public void invalidName()
    {
        errorStatement = "Name must contain characters!";
        print(errorStatement);
    }

    public void print(String statement)
    {
        System.out.println(c.red + statement + c.endColour);
    }
}