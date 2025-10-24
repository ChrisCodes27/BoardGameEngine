/**
 * Filename: DotsAndBoxesPlayer.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Oct-02
 * Description: A player class for Dots and Boxes which extends from the abstract player class. Has functions specific
 * to Sliding Puzzle.
 */

package player;

import java.util.*;

public class DotsAndBoxesPlayer extends Player{
    Scanner inp = new Scanner(System.in);
    public String choice;
    public int[] position;
    public String edge;
    private int numOfBoxes;
    public boolean isMoveValid;

    public DotsAndBoxesPlayer()
    {
        isMoveValid = true;
        numOfBoxes = 0;
    }

    public void setNumOfBoxes(int n)
    {
        numOfBoxes = n;
    }

    public int getNumOfBoxes()
    {
        return numOfBoxes;
    }

    /**
     * to get the input from the user which contains the coordinates of the tile and the edge that they want to claim
     * @param No parameters
     * @return void function
     */
    @Override
    public void move()
    {
        System.out.println(getName().toUpperCase()+", make your move!");
        System.out.print(getName().toUpperCase()+"'s Move:     ");
        choice = inp.nextLine();
        if(!choice.toUpperCase().equals("QUIT")) //if the user decides to quit during the game
        {
                trimPlayerChoice(); //to get the coordinates and the edge separate from the input
        }
    }
    
    /**
     * display message if player inputted an invalid move
     * @param No parameters
     * @return void function
     */
    @Override
    public void invalidMove() 
    {
        System.out.println("That is an invalid move! Select a valid edge");
        isMoveValid = true;
    }

    /**
     * To get the coordinates of the tile and the edge that the user wants to claim. eg. AA U is the input from the player,
     * get the coordinates AA and the edge U.
     * @param No parameters
     * @return void function
     */
    public void trimPlayerChoice()
    {
       choice.trim(); //removing space
       String[] ch = choice.toUpperCase().split("\\s+"); //split by the space
       position = new int[2];
       
       if(ch.length == 2 && ch[0].trim().length() ==2) //checking if the input is valid
       {
         position[0] = ch[0].charAt(0) - 'A';
         position[1] = ch[0].charAt(1) - 'A';
         edge = ch[1];
       }
       else
       {
        invalidMove();
       }
    }
    
     /**
     * To restore the values of the player for the next round
     * @param No parameters
     * @return void function
     */
    public void restore()
    {
        isMoveValid = true;
        numOfBoxes = 0;
        win = false;
    }
}