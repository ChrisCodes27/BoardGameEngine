/**
 * Filename: Board.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Sept-14
 * Description: An abstract class that serves as a base to other board classes of specific game types.
 */

package board;
import gameinterfaces.BoardFunctions;
import java.util.regex.*;

public abstract class Board implements BoardFunctions{

   // Initializing variables
   private int numOfRows, numOfCols;
   public Tile[][] gameBoard;
   private String size;
   public int boardState;
   public int difficultyLevel;

   /**
    * Returns the total number of rows in the board.
    * @return int — current number of rows.
    */
   public int getRows()
   {
      return numOfRows;
   }

   /**
    * Returns the total number of columns in the board.
    * @return int — current number of columns.
    */
   public int getCols()
   {
      return numOfCols;
   }

   /**
    * Sets how many rows the board should have.
    * @param n number of rows to assign.
    * @return void function
    */
   public void setRows(int n)
   {
      numOfRows = n;
   }

   /**
    * Sets how many columns the board should have.
    * @param m number of columns to assign.
    * @return void function
    */
   public void setCols(int m)
   {
      numOfCols = m;
   }

   /**
    * Saves the board size in string form (e.g., "9x9").
    * @param s size string entered by the player.
    * @return void function
    */
   public void setSize(String s)
   {
      size = s;
   }

   /**
    * Returns the size of the board as a string.
    * @return String — size in "nxm" format.
    */
   public String getSize() {
      return size;
   }

    /**
    * Sets the rows and columns for the given "nxm" input
    * @param size the input of the player for the board size
    * @return a boolean value to indicate whether the input was of a valid form or not
    */
   
   public boolean setDimensions(String size)
   {
      // Uses Regex Expression to assure that the input is of "nxm" form
      if(size.matches("([2-9]+)[x]([2-9]+)")) {
         String[] x = size.split("x");

         // Extracting the rows and columns from the input
         numOfRows = Integer.parseInt(x[0]);
         numOfCols = Integer.parseInt(x[1]);
         return true;
      }

      else{
         // Handles errors
         System.out.println("Invalid Input! Must be of the form nxm");
         return false;
      }
   }
}