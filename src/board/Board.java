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
   private int numOfRows, numOfCols;
   public Tile[][] gameBoard;
   private String size;
   public int boardState;
   public int difficultyLevel;

   public int getRows()
   {
      return numOfRows;
   }

   public int getCols()
   {
      return numOfCols;
   }
   public void setRows(int n)
   {
      numOfRows = n;
   }
   public void setCols(int m)
   {
      numOfCols = m;
   }

   public void setSize(String s)
   {
      size = s;
   }

   public String getSize()
   {
      return size;
   }

    /**
    * Sets the rows and columns for the given "nxm" input
    * @param size the input of the player for the board size
    * @return a boolean value to indicate whether the input was of a valid form or not
    */
   
   public boolean setDimensions(String size)
   {
      if(size.matches("([2-9]+)[x]([2-9]+)")) //Uses Regex Expression to assure that the input is of "nxm" form
      {
         String[] x = size.split("x"); 
         numOfRows = Integer.parseInt(x[0]); //Extracting the rows and columns from the input
         numOfCols = Integer.parseInt(x[1]);
         return true;
      }
      else{
         System.out.println("Invalid Input! Must be of the form nxm");
         return false;
      }
   }
}