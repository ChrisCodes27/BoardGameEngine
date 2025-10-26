/**
 * Filename: DotsAndBoxesBoard.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Oct-02
 * Description: A board class for dots and boards which extends from the abstract board class. Has functions specific
 * to dots and boxes. 
 */

package board;

import java.util.*;
import player.DotsAndBoxesPlayer;
import colour.colour;
import printerrormessage.printErrorMessage;
import gameinterfaces.ExampleBoard;

@SuppressWarnings("unchecked")
public class DotsAndBoxesBoard extends Board implements ExampleBoard{
    
    public BoxTile[][] dotsBoard;
    private int totalBoxes;
    printErrorMessage error = new printErrorMessage();
    
    public void setTotalBoxes(int b)
    {
        // Total number of boxes gained by both players
        totalBoxes = b;
    }
    public int getTotalBoxes()
    {
        return totalBoxes;
    }

    /**
     * Inititalizes the dotsBoard of BoxTile type and sets the value the row and column of each tile along
     * with the initial value of the tile.
     * @param
     * @return void function
     */
    @Override
    public void initializeBoard()
    {
        setTotalBoxes(0);
        for(int i =0;i<getRows();i++){
            for(int j=0;j<getCols();j++){
                dotsBoard[i][j] = new BoxTile<String>();
                dotsBoard[i][j].setRow(i);
                dotsBoard[i][j].setColumn(j);
                dotsBoard[i][j].piece = new Piece<>("0");
            }
        }
    }

    @Override
    public boolean checkBoardState()
    {
        return false;
    }

    /**
     * Prints the dots and boxes board after every move of both the players.
     * @param
     * @return void function
     */
    @Override 
    public void printBoardState()
    {
        colour c = new colour();
        int i,j;

        // Labeling the rows and columns of the board alphabetically
        char cl = 'A';
        char r = 'A';

        System.out.print("    ");

        for(j=0; j<getCols();j++)
        {
            System.out.print("     "+r+"     ");
            r++;
        }
        System.out.println();

        // Iterating through an abstract matrix of (2n+1,2m+1). This includes the * and the edges. The *'s start from 0 and are incremented by n+2 while the edges start from 1 and increment by n+2.
        for (i=0; i<2*getRows()+1;i++) 
        {
            if(i%2 != 0)
            {
                System.out.print(cl);
                cl++;
            }
            for (j=0; j<2*getCols()+1;j++) 
            {
                // Print *
                // Every * is located at an even position, so we check for i%2 = 0 and j%2 = 0
                if (i%2 == 0 && j%2 == 0)
                {
                    System.out.print("   * ");
                }

                // Print the horizontal edges (up and down)
                // Every up and down edge is located at a position where the i is even and j is odd inside the abstract matrix
                else if (i%2 == 0 && j%2 == 1)
                {
                    // The original position of the edge in the nxm matrix is i and j divided by 2
                    int row = i/2;
                    int col = j/2;

                    // Validating bounds
                    if (row < getRows()+1 && col < getCols()) {
                        if (row < getRows() && dotsBoard[row][col].up.getValueOnTile().equals(1)) {
                            System.out.print(dotsBoard[row][col].up.edgeColour+"  ——— "+c.endColour);
                        } else if (row > 0 && dotsBoard[row - 1][col].down.getValueOnTile().equals(1)) {
                            System.out.print(dotsBoard[row-1][col].down.edgeColour+"  ——— "+c.endColour);
                        } else {
                            System.out.print("      ");
                        }
                    } 
                    else 
                    {
                        System.out.print("      ");
                    }
                }

                // To print the vertical edges (left and right)
                // The left and right edges are located at positions where i is odd and j is even inside the abstract matrix
                else if (i%2 == 1 && j%2 == 0)
                {
                    // The original position of the edge in the nxm matrix is i and j divided by 2
                    int row = i/2;
                    int col = j/2;

                    // Validating bounds
                    if (row < getRows() && col < getCols()+1) {
                        if (col < getCols() && dotsBoard[row][col].left.getValueOnTile().equals(1)){
                            System.out.print(dotsBoard[row][col].left.edgeColour+"   | "+c.endColour);
                        } else if (col > 0 && dotsBoard[row][col - 1].right.getValueOnTile().equals(1)) {
                            System.out.print(dotsBoard[row][col-1].right.edgeColour+"   | "+c.endColour);
                        } else {
                            System.out.print("     ");
                        }
                    } 
                    else
                    {
                        System.out.print("     ");
                    }
                }

                // To print the intital's of the player if all four edges of a tile is 1
                // When both i and j are odd, to mark the initial of the player if they have a box claimed
                else if (i%2 == 1 && j%2 == 1)
                {
                    int row = (i-1)/2;
                    int col = (j-1)/2;
                    if (row < getRows() && col < getCols() && !dotsBoard[row][col].piece.getValueOnTile().equals("0")) 
                    {
                        System.out.print("  "+ dotsBoard[row][col].piece.getValueOnTile()+ "  ");
                    } 
                    else 
                    {
                        System.out.print("     ");
                    }
                }
           }
            System.out.println();
        }
    }


    public boolean makeMove(DotsAndBoxesPlayer player)
    {
        int i,j;
        i = player.position[0];
        j = player.position[1];

        if(i >= getRows() || i < 0 || j >= getCols() || j < 0 || player.edge == null) //checking for valid input
        {
            // Prints an error message
            error.invalidTypeInput("position/edge (eg. AA U)");
            return true;
        }
        else {
            //A switch case according to which direction (U, D, L, R) the user inputs
            switch(player.edge)
            {
                case "U":
                    if(dotsBoard[i][j].up.getValueOnTile().equals(1)) //If the edge of that tile has already been selected
                    {
                        System.out.println("This edge has already been placed!");
                        return true;
                    }
                    else{
                    dotsBoard[i][j].up.setValueOnTile(1); //if it has not, set the value of the edge to 1
                    dotsBoard[i][j].up.edgeColour = player.colour;
                    if(i-1>=0) //Since there are shared edges in between tiles, will have to update to 1 for those tiles as well.
                        {dotsBoard[i-1][j].down.setValueOnTile(1);
                         dotsBoard[i-1][j].down.edgeColour = player.colour;
                        }
                    }
                    break;
                case "D":
                    if(dotsBoard[i][j].down.getValueOnTile().equals(1)) //down edge, checks shared up edge as well
                    {
                        System.out.println("This edge has already been placed!");
                        return true;
                    }
                    else{
                    dotsBoard[i][j].down.setValueOnTile(1);
                    dotsBoard[i][j].down.edgeColour = player.colour;
                    if(i+1<getRows())
                        {dotsBoard[i+1][j].up.setValueOnTile(1);
                        dotsBoard[i+1][j].up.edgeColour = player.colour;
                    }
                    }
                    break;
                case "L":
                    if(dotsBoard[i][j].left.getValueOnTile().equals(1)) //left edge, checks right shared edge as well
                    {
                        System.out.println("This edge has already been placed!");
                        return true;
                    }
                    else{
                    dotsBoard[i][j].left.setValueOnTile(1);
                    dotsBoard[i][j].left.edgeColour = player.colour;
                    if(j-1>=0)
                        {dotsBoard[i][j-1].right.setValueOnTile(1);
                         dotsBoard[i][j-1].right.edgeColour = player.colour;
                        }
                    }
                    break;
                case "R":
                    if(dotsBoard[i][j].right.getValueOnTile().equals(1)) //right edge, checks shared left edge as well
                    {
                        System.out.println("This edge has already been placed!");
                        return true;
                    }
                    else{
                    dotsBoard[i][j].right.setValueOnTile(1);
                    dotsBoard[i][j].right.edgeColour = player.colour;
                    if(j+1<getCols())
                        {
                          dotsBoard[i][j+1].left.setValueOnTile(1);
                          dotsBoard[i][j+1].left.edgeColour = player.colour;
                    }
                    }
                    break;
                default:
                    error.invalidTypeInput("edge"); //If the user enters an invalid edge, eg. N, S, etc
                    return true;
            }
        player.edge = null;
        boolean check = checkBox(player); //After a move is made, check if player has claimed a box
        if (check == true) //If it is true, the player gets another turn
        {
           return true;
        }
        else
        {
           return false;
        }
        }
    }

    public boolean checkBox(DotsAndBoxesPlayer player)
    { 
        int i,j;
        int count = 0;
        colour c = new colour();

        for(i = getRows()-1; i >=0 ;i--)
        {
            //check if box is claimed within the current tile as well as in adjacent tiles for each row, keeping the column constant
            if(dotsBoard[i][player.position[1]].piece.getValueOnTile().equals("0") && dotsBoard[i][player.position[1]].up.getValueOnTile().equals(1) && dotsBoard[i][player.position[1]].left.getValueOnTile().equals(1) && dotsBoard[i][player.position[1]].down.getValueOnTile().equals(1)  && dotsBoard[i][player.position[1]].right.getValueOnTile().equals(1))
            {                
                count++;
                dotsBoard[i][player.position[1]].piece.setValueOnTile(player.colour+player.getName().substring(0,1)+c.endColour); //Sets the player's initial on the tile if they claimed a box
                player.setNumOfBoxes(player.getNumOfBoxes()+1); //Incrementing the number of boxes for the current player
                setTotalBoxes(getTotalBoxes() + 1); //Incrementing the total number of boxes

                System.out.println(c.endColour+ player.getName()+" claimed "+ count+" box(s)!");
            }
        }
        for(j=getCols()-1;j>=0;j--)
        {
            //check if box is claimed within the current tile as well as in adjacent tiles for each column, keeping the row constant
            if(dotsBoard[player.position[0]][j].piece.getValueOnTile().equals("0") && dotsBoard[player.position[0]][j].up.getValueOnTile().equals(1) && dotsBoard[player.position[0]][j].left.getValueOnTile().equals(1) && dotsBoard[player.position[0]][j].down.getValueOnTile().equals(1) && dotsBoard[player.position[0]][j].right.getValueOnTile().equals(1))
            {
                count++;
                dotsBoard[player.position[0]][j].piece.setValueOnTile(player.colour+player.getName().substring(0,1)+c.endColour);//Sets the player's initial on the tile if they claimed a box
                player.setNumOfBoxes(player.getNumOfBoxes()+1);
                setTotalBoxes(getTotalBoxes() + 1);

                System.out.println(c.endColour+player.getName()+" claimed "+count+ "box(s)!");
            }
        }
        if (count>0)
        {
            return true; //return true if a player claimed ateast 1 box during their current move
        }
         return false; //else false
    }
    

    @Override
    public void printExampleBoard()
    {
        int i,j;
        int rows = 4;
        int cols = 4;
        char cl = 'A';
        char r = 'A';
        String temp ="";
        System.out.print("    ");
        for(j=0; j<cols;j++)
        {
            System.out.print("     "+r+"     ");
            r++;
        }
        r = 'A';
        System.out.println();
        for (i=0; i<2*rows+1;i++) 
        {
            if(i%2 != 0)
            {
                System.out.print(cl);
                temp = String.valueOf(cl);
                cl++;
            }
            for (j=0; j<2*cols+1;j++) 
            {
                if (i%2 == 0 && j%2 == 0)
                {
                    System.out.print("   * ");
                }
                else if (i%2 == 0 && j%2 == 1)
                {
                    int row = i/2;
                    int col = j/2;

                    if (row < rows +1 && col < cols) {
                        
                        System.out.print("      ");
                    } 
                    else 
                    {
                        System.out.print("      ");
                    }
                }
                else if (i%2 == 1 && j%2 == 0)
                {
                    int row = i/2;
                    int col = j/2;

                    if (row < rows && col < cols +1) 
                    {
                       System.out.print("     ");
                    }
                    else
                    {
                        System.out.print("     ");
                    }
                }
                else if (i%2 == 1 && j%2 == 1)
                    {
                    int row = (i-1)/2;
                    int col = (j-1)/2;
                    System.out.print("  "+temp+""+r+"  ");
                    r++;
                    }
           }
            System.out.println();
            r = 'A';
        }
    }
}
