/**
 * Filename: Player.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Sept-14
 * Description: An abstract class that serves as a base to other player classes of specific game types.
 */

package player;
import gameinterfaces.MoveFunctions;
import board.Board;
import board.Tile;
import java.util.*;
import board.Piece;

public abstract class Player implements MoveFunctions{
private String name;
public int noOfMoves;
public int choice;
public boolean win;
public boolean move;
public String colour;
public Piece<String> playerPiece;
public Tile playerPosition;

public Player()
{
     playerPiece = new Piece<String>();
}

public String getName()
{
     return name;
}
public void setName(String name)
{
     this.name = name;
}

/**
 * Checks if the win variable for the player is true, if it is, proceeds to congratulate the user and displays the number of moves made.
 * @param No paramteres, uses win variable of this class
 * @return void function
 */
public void checkWin()
{
     if(win==true){
          System.out.println("Congratulation "+name+"! You have solved the game with "+noOfMoves+" moves!");
          restore();
     }
}
/**
 * To restore the value of player if the user decides to play another round
 * @param -
 * @return -
 */
public void restore()
{
     noOfMoves = 0;
     win=false;
}
}