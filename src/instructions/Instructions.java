/**
 * Filename: Instructions.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Oct-26
 * Description: An instruction utility class for all games.
 */

package instructions;

import java.util.*;
import board.*;

public class Instructions
{
    DotsAndBoxesBoard b = new DotsAndBoxesBoard();
    QuoridorBoard q = new QuoridorBoard();

    /**
     * to display the instructions of the Sliding Puzzle game to the user
     * @param No parameters
     * @return void function
     */
    public void displaySlidingPuzzleInstructions()
    {
        System.out.println("------------------------------------------");
        System.out.println("               SLIDING PUZZLE");
        System.out.println("------------------------------------------");
        System.out.println();
        System.out.println("GOAL: Get the numbers in the puzzle in order (starting 1,2,3 ...) from left to right of each row in the board!");
        System.out.println("HOW TO PLAY:");
        System.out.println("1. The board first begins in a shuffled state, you can only move the numbers which are adjacent to the empty tile.");
        System.out.println("2. To move a tile, type the number present on the tile");
        System.out.println("   Example:");
        System.out.println("      Enter move: 5  → Swaps 5 with the empty tile");
        System.out.println("      Enter move: 3  → Invalid Move");
        System.out.println();
        System.out.println();
        System.out.println("You have completed the puzzle when it is in order!");
        System.out.println("------------------------------------------");
    }

    /**
     * To display the instructions on how to play the dots and boxes game to the users
     * @param No parameters
     * @return void function
     */
    public void displayDotsAndBoxesInstructions()
    {
        System.out.println("\u001B[31m------------------------------------------\u001B[0m");
        System.out.println("\033[1;31;47m              DOTS AND BOXES            \033[0m");
        System.out.println("\u001B[31m------------------------------------------\u001B[0m");
        System.out.println();
        System.out.println("GOAL: Complete more boxes than your opponent by drawing lines between dots. Each box completed with the 4th edge earns you one point!");
        System.out.println();
        System.out.println("\u001B[31mHOW TO PLAY:\u001B[0m");
        System.out.println("1. The board is labeled with letters for rows and columns (A, B, C, ...). For example, the coordinates of the first tile in the board is AA.");
        b.printExampleBoard(); //to print an example of how the dots and board board is
        System.out.println();
        System.out.println("Each tile in the board has four different directions - UP (U), DOWN (D), LEFT (L) and RIGHT (R)");   
        System.out.println("2. To mark an edge of each tile, type the coordinates of the box and the direction in which you want to draw the line.");
        System.out.println("   Example:");
        System.out.println("      Enter move: AA L  → draws a vertical line on the left of the tile AA.");
        System.out.println("      Enter move: AB U  → draws a horizontal line on the top of the tile AB.");
        System.out.println();
        System.out.println("3. Completing a box earns you a point and another turn!");
        System.out.println("4. If you want to quit the game at any point, please type 'QUIT'");
        System.out.println("When all boxes in the board are filled, the player with the most boxes wins.");
        System.out.println();
        System.out.println("\u001B[31m------------------------------------------\u001B[0m");

    }

    public void displayQuoridorInstructions()
    {
        System.out.println("\u001B[31m------------------------------------------\u001B[0m");
        System.out.println("\033[1;31;47m              QUORIDOR            \033[0m");
        System.out.println("\u001B[31m------------------------------------------\u001B[0m");
        System.out.println();
        System.out.println("GOAL: Reach the opposite side of the board before your opponent! Each player moves their pawn across the 9x9 grid while strategically placing walls to block the other player’s path.");
        System.out.println();
        System.out.println("\u001B[31mHOW TO PLAY:\u001B[0m");
        System.out.println();
        System.out.println("1. The board is labeled with numbers from 1 to 81, representing each tile position.");
        q.printBoardExample();
        System.out.println("2. On your turn, you are given two options:");
        System.out.println("   +> Make Your Move : Move your pawn to a valid adjacent tile by entering its tile number.");
        System.out.println("     Example:");
        System.out.println("        These are your legal moves: 14  6  4 ");
        System.out.println("        Enter your move: 14  moves your pawn to tile 46.");
        System.out.println();
        System.out.println("   +> Place a wall: You may place a wall between two adjacent tiles to block your opponent’s path.");
        System.out.println("     Walls can be placed horizontally or vertically, using the direction 'U' (up) or 'D' (down).");
        System.out.println("     Example:");
        System.out.println("        Enter move: 45 46 U  → places a horizontal wall above tiles 45 and 46.");
        System.out.println("        Enter move: 1 10 D   → places a vertical wall below tiles 1 and 10.");
        System.out.println();
        System.out.println("3. An option to quit will always be present during the players move.");
        System.out.println("4. You will not be allowed to completely block your opponents path towards the goal, just enough to mildly irritate them.");
        System.out.println();
        System.out.println(" MAY THE BEST PLAYER WIN!");
        System.out.println();
        System.out.println("\u001B[31m--------------------------------------------------------------------------------\u001B[0m");
    }
}