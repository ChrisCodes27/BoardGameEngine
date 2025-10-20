package board;

import java.util.*;
import gameinterfaces.puzzleinterfaces.PuzzleFunctions;

public class QuoridorBoard extends DotsAndBoxesBoard{

    //public BoxTile[][] quoridorBoard;
    List<Integer> legalMovesList;

    public QuoridorBoard()
    {
        legalMovesList = new ArrayList<>();
    }

    @Override
    public void initializeBoard()
    {
        int[] arr;
        arr = new int[getRows()*getCols()]; //getting an array of numbers within the range of the board dimensions
        int k =0;
        for(int i =0;i<arr.length-1;i++)
        {
            arr[i] = i+1;
        }
        for(int i =0;i<getRows();i++){
            for(int j=0;j<getCols();j++){
                dotsBoard[i][j] = new BoxTile();
                dotsBoard[i][j].setRow(i);
                dotsBoard[i][j].setColumn(j);
                dotsBoard[i][j].val = new Piece<>(arr[k]);
                k++;
        }
        }
    }
    @Override
    public boolean checkBoardState()
    {
        return true;
    }
    @Override
    public void printBoardState()
    {
        colour c = new colour();
        int i,j;
        System.out.print("    ");
        // for(j=0; j<getCols();j++)
        // {
        //     System.out.print("     "+r+"     ");
        //     r++;
        // }
        System.out.println();
        //Iterating through an abstract matrix of (2n+1,2m+1). This includes the * and the edges. The *'s start from
        //0 and are incremented by n+2 while the edges start from 1 and increment by n+2.
        for (i=0; i<2*getRows()+1;i++) 
        {
            // if(i%2 != 0)
            // {
            //     System.out.print(cl);
            //     cl++;
            // }
            for (j=0; j<2*getCols()+1;j++) 
            {
                //to print *
                if (i%2 == 0 && j%2 == 0) //Every * is located at an even position, so we check for i and j %2 = 0
                {
                    System.out.print("   * ");
                }
                //to print the horizontal edges (up and down)
                else if (i%2 == 0 && j%2 == 1) //Every up and down edge is located at a position where the i is even and j is odd inside the abstract matrix
                {
                    int row = i/2; //The original position of the edge in the nxm matrix is i and j divided by 2
                    int col = j/2;

                    if (row < getRows()+1 && col < getCols()) { //validating bounds
                       // if (row < getRows() && dotsBoard[row][col].up.getValueOnTile().equals(1)) {
                            System.out.print(dotsBoard[row][col].up.edgeColour+"  ——— "+c.endColour);
                       // } else if (row > 0 && dotsBoard[row - 1][col].down.getValueOnTile().equals(1)) {
                            System.out.print(dotsBoard[row-1][col].down.edgeColour+"  ——— "+c.endColour);
                        //} else {
                            System.out.print("      ");
                        //}
                    } 
                    else 
                    {
                        System.out.print("      ");
                    }
                }
                //to print the vertical edges (left and rigt)
                else if (i%2 == 1 && j%2 == 0) //The left and right edges are located at positions where i is odd and j is even inside the abstract matrix
                {
                    int row = i/2; //The original position of the edge in the nxm matrix is i and j divided by 2
                    int col = j/2;

                    if (row < getRows() && col < getCols()+1) { //validating bounds
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
                //to print the intitals of the player if all four edges of a tile is 1
                else if (i%2 == 1 && j%2 == 1) //When both i and j are odd, to mark the initial of the player if they have a box claimed
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

    public void makeMove(Quoridor player, int move)
    {
        int i = (move - 1)/getRows();
        int j = (mvoe - 1)%getCols();
                
        if(dotsBoard[i][j].val.getValueOnTile() == move)
        {
            player.playerPosition.setRow(i);
            player.playerPosition.setColumn(j);
            break;
        } 
                
    }

    public boolean setFence(String fence)
    {
        fence = fence.trim();
        String[] parts = fence.split("\\s+");

        int num1 = 0, num2 = 0;
        String edge = " ";

        if (parts.length == 3) {
            num1 = Integer.parseInt(parts[0]);
            num2 = Integer.parseInt(parts[1]);
            edge = parts[2];
            if(num1 > 0 && num1 < (getRows*getCols) && num2 > 0 && num2 < (getRows*getCols) && (num1 + 1 == num2 || num2 == num1 + 9))
            {
                int i1 = (num1 - 1)/getRows();
                int j1 = (num1 - 1)%getCols();
                int i2 = (num2 - 1)/getRows();
                int j2 = (num2 - 1)%getCols();
                if((edge.equals("U") || edge.equals("D")) && num1 + 1 == num2)
                {
                    switch(edge)
                    {
                        case 'U':
                            if(dotsBoard[i1][j1].up.getValueOnTile.equals(0) && dotsBoard[i2][j2].up.getValueOnTile.equals(0))
                            {
                                dotsBoard[i1][j1].up.setValueOnTile(1);
                                dotsBoard[i2][j2].up.setValueOnTile(1);
                            }
                            else{
                                System.out.println("A fence has already been placed here!");
                                return false;
                            }
                            break;
                        case 'D':
                            if(dotsBoard[i1][j1].up.getValueOnTile.equals(0) && dotsBoard[i2][j2].up.getValueOnTile.equals(0))
                            {
                                dotsBoard[i1][j1].up.setValueOnTile(1);
                                dotsBoard[i2][j2].up.setValueOnTile(1);
                            }
                            else{
                                System.out.println("A fence has already been placed here!");
                                return false;
                            }
                            break;
                        default:
                            return isValid;
                    }
                    return true;
                }
                else if ((edge.equals("L") || edge.equals("R")) && num1 + 9 == num2)
                {
                     switch(edge)
                    {
                        case 'L':
                            if(dotsBoard[i1][j1].left.getValueOnTile.equals(0) && dotsBoard[i2][j2].left.getValueOnTile.equals(0))
                            {
                                dotsBoard[i1][j1].left.setValueOnTile(1);
                                dotsBoard[i2][j2].left.setValueOnTile(1);
                            }
                            else{
                                System.out.println("A fence has already been placed here!");
                                return false;
                            }
                            break;
                        case 'R':
                            if(dotsBoard[i1][j1].right.getValueOnTile.equals(0) && dotsBoard[i2][j2].right.getValueOnTile.equals(0))
                            {
                                dotsBoard[i1][j1].right.setValueOnTile(1);
                                dotsBoard[i2][j2].right.setValueOnTile(1);
                            }
                            else{
                                System.out.println("A fence has already been placed here!");
                                return false;
                            }
                            break;
                        default:
                            return isValid;
                    }
                    return true;
                }
            }
            else{
                return false;
            }
        } 
        else
        {
            return false;
        }
    }

    public void legalMoves(Quoridor player)
    {
        int i = player.playerPosition.getRow();
        int j = player.playerPosition.getColumn();

        if ( i+1 < getRows())
        {
            if(dotsBoard[i][j].down.getValueOnTile().equals(0))
            {
                legalMovesList.add(dotsBoard[i+1][j].val);
            }
        }

         if ( i-1 > 0)
        {
            if(dotsBoard[i][j].up.getValueOnTile().equals(0))
            {
                legalMovesList.add(dotsBoard[i-1][j].val);
            }
        }

         if ( j+1 < getCols())
        {
            if(dotsBoard[i][j].down.getValueOnTile().equals(0))
            {
                legalMovesList.add(dotsBoard[i][j+1].val);
            }
        }
         if ( j-1 > 0)
        {
            if(dotsBoard[i][j].down.getValueOnTile().equals(0))
            {
                legalMovesList.add(dotsBoard[i][j-1].val);
            }
        }

        System.out.print("These are your legal moves: ");
        for(int i: legalMovesList)
        {
            System.out.print(i + "  ");
        }
        System.out.println();
    }
}