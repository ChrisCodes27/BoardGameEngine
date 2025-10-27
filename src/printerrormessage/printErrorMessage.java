/**
 * Filename: printErrorMessage.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Oct-06
 * Description: A class for displaying various common error messages for the games
 */

package printerrormessage;
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
        errorStatement = "Invalid Input! Select a valid item from the menu.  ";
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
        errorStatement = "Invalid Placement! Select a Valid Fence Position! (Fence already placed or intersects with an existing fence.)";
        print(errorStatement);
    }

    /**
     * Displays an error message if the fence placed blocks opponent
     * @return void function
     */
    public void invalidPath(){
        errorStatement = "No Valid Path Available For Your Opponent! Illegal Move!";
        print(errorStatement);
    }

    public void invalidName()
    {
        errorStatement = "Name Must Contain Characters (A - Z)!";
        print(errorStatement);
    }

    public void noFences(){
        errorStatement = "You have run out of fences! Select a move!";
        print(errorStatement);
    }

    public void print(String statement)
    {
        System.out.println(c.red + statement + c.endColour);
        System.out.println();
    }
}