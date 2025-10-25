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
     * displays an error message if the menu item selected is not valid
     * @param No parameters
     * @return void function
     */
    public void invalidMenuInput()
    {
        System.out.println("Invalid Input! Select a valid item from the menu.");
        System.out.println();
    }

    public void invalidMove()
    {
        System.out.println("Invalid move! Select a valid move!");
        System.out.println();
    }

    /**
     * displays an error message if the type of input is not valid (for moves, etc)
     * @param No parameters
     * @return void function
     */
    public void invalidTypeInput(String type)
    {
        System.out.println("Invalid Input! Input a valid "+type+"!");
        System.out.println();
    }
}