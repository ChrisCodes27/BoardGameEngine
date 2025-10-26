/**
 * Filename: QuoridorBoard.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Oct-18
 * Description: A board class for quoridor which extends from the DotsAndBoxesBoard class. Has functions specific
 * to quoridor. 
 */

package board;

import java.util.*;
import gameinterfaces.puzzleinterfaces.PuzzleFunctions;
import player.QuoridorPlayer;
import colour.colour;
import printerrormessage.printErrorMessage;

@SuppressWarnings("unchecked")
public class QuoridorBoard extends DotsAndBoxesBoard{

    public Tile[][] playerPiecePosition;
    private List<Integer> legalMovesList;
    printErrorMessage error = new printErrorMessage();

    public QuoridorBoard() {
        legalMovesList = new ArrayList<>();
    }

    public List<Integer> getLegalMovesList() {
        return legalMovesList;
    }

    /**
     * To iniitialize the board with the tile values
     * @return void function
     */
    @Override
    public void initializeBoard()
    {
        initializePlayerPositionBoard();
        int[] arr;

        // Getting an array of numbers within the range of the board dimensions
        arr = new int[getRows()*getCols()];
        int k =0;
        for(int i =0;i<arr.length;i++) {
            // Getting valid tile values within the range
            arr[i] = i+1;
        }
        for(int i =0;i<getRows();i++){
            for(int j=0;j<getCols();j++){
                dotsBoard[i][j] = new BoxTile<Integer>();
                dotsBoard[i][j].setRow(i);
                dotsBoard[i][j].setColumn(j);
                dotsBoard[i][j].piece = new Piece<>(arr[k]);
                k++;
            }
        }
    }

    /**
     * Initialize the playerPositionBoard
     * @return void function
     */
    public void initializePlayerPositionBoard()
    {
        playerPiecePosition = new Tile[getRows()][getCols()];
        for(int i =0;i<getRows();i++){
            for(int j=0;j<getCols();j++){
                playerPiecePosition[i][j] = new Tile<String>();

                // Assigning all zeros first
                playerPiecePosition[i][j].piece = new Piece<>("0");
            }
        }
    }

    /**
     * checkBoardState
     * @return void function
     */
    @Override
    public boolean checkBoardState() {
        return true;
    }

    /**
     * Print the Quoridor Board after every move
     * @return void function
     */
    @Override
    public void printBoardState()
    {
        colour c = new colour();
        int i, j, row, col;

        // Iterating through an abstract matrix of (2n+1,2m+1). This includes the * and the edges. The *'s start from 0 and are incremented by n+2 while the edges start from 1 and increment by n+2.
        for (i=0; i<2*getRows()+1;i++)
        {
            for (j=0; j<2*getCols()+1;j++)
            {
                // To print *
                if (i%2 == 0 && j%2 == 0) //Every * is located at an even position, so we check for i and j %2 = 0
                {
                    System.out.print("  * ");
                }

                // To print the horizontal edges (up and down)
                // Every up and down edge is located at a position where the i is even and j is odd inside the abstract matrix
                else if (i%2 == 0 && j%2 == 1)
                {
                    row = i/2;
                    col = j/2;

                    if (row < getRows()+1 && col < getCols())
                    {
                        // If an up edge is placed
                        if(row < getRows() && dotsBoard[row][col].up.getValueOnTile().equals(1))
                            {System.out.print(dotsBoard[row][col].up.edgeColour+ "  —— " +c.endColour);}

                        // If a down edge is placed
                        else if(row > 0 && dotsBoard[row-1][col].down.getValueOnTile().equals(1))
                            {System.out.print(dotsBoard[row-1][col].down.edgeColour+ "  —— " +c.endColour);}

                        else
                            {System.out.print("  —— ");}
                    }
                }

                // To print the vertical edges (left and right)
                // The left and right edges are located at positions where i is odd and j is even inside the abstract matrix
                else if (i%2 == 1 && j%2 == 0)
                {
                    row = i/2;
                    col = j/2;

                    if (row < getRows() && col < getCols() + 1)
                    {
                        // If a left edge is placed
                        if(col < getCols() && dotsBoard[row][col].left.getValueOnTile().equals(1))
                            {System.out.print(dotsBoard[row][col].left.edgeColour+ "    | " +c.endColour);}

                        // If a right edge is placed
                        else if(col > 0 && dotsBoard[row][col-1].right.getValueOnTile().equals(1))
                            {System.out.print(dotsBoard[row][col-1].right.edgeColour+ "    | " +c.endColour);}

                        else
                        {System.out.print("   | ");}
                    }
                } 
                // To print the inititals of the player if all four edges of a tile is 1
                // When both i and j are odd, to mark the initial of the player if they have a box claimed
                else if (i%2 == 1 && j%2 == 1)
                {
                    row = (i-1)/2;
                    col = (j-1)/2;

                    // If a player is on the first row and is on the current tile
                    if (i == 1 && !playerPiecePosition[row][col].piece.getValueOnTile().equals("0"))
                        {System.out.print("  "+ playerPiecePosition[row][col].piece.getValueOnTile()+" ");}

                    // If a player is on the current tile
                    else if (!playerPiecePosition[row][col].piece.getValueOnTile().equals("0"))
                        {System.out.print("  "+ playerPiecePosition[row][col].piece.getValueOnTile()+" ");}
                    else if (i==1)
                        {System.out.print("  "+ dotsBoard[row][col].piece.getValueOnTile()+" ");}
                    else
                    {System.out.print(" "+ dotsBoard[row][col].piece.getValueOnTile()+" ");}
                }
            }
            System.out.println();
        }
    }

    /**
     * Places an edge on the board according to the players input
     * @param player,move the current player and their move
     * @return void function
     */
    public void makeMove(QuoridorPlayer player, int move)
    {
        int i = (move - 1)/getRows();
        int j = (move - 1)%getCols();

        playerPiecePosition[player.playerPosition.getRow()][player.playerPosition.getColumn()].piece.setValueOnTile("0");

        if((Integer)dotsBoard[i][j].piece.getValueOnTile() == move)
        {
            player.playerPosition.setRow(i);
            player.playerPosition.setColumn(j);
            playerPiecePosition[i][j].piece.setValueOnTile(player.playerPiece.getValueOnTile());
        }
    }

    /**
     * Functionality for setting the fence, inputted by the player, on the board
     * @param fence,player,i inputted fence, current player and i which indicates (0 - to place a fence OR 1 - to remove a fence)
     * @return void function
     */
    public boolean setFence(String fence, QuoridorPlayer player, int i)
    {
        fence = fence.trim();
        String[] parts = fence.split("\\s+");

        int num1 = 0, num2 = 0;
        String edge = " ";

        if (parts.length == 3) {
            // Splitting the input into the tile1, tile2 and edge value
            num1 = Integer.parseInt(parts[0]);
            num2 = Integer.parseInt(parts[1]);
            edge = parts[2].toUpperCase();

            // To check and validate if the inputted values are within bounds
            if(num1 > 0 && num1 < (getRows()*getCols()) && num2 > 0 && num2 < (getRows()*getCols()) && ((num1 + 1 == num2) || (num2 == num1 + 9) || (num2 + 1 == num1) || (num1 == num2 + 9)))
            {
                // Getting the coordinates of the two tiles
                int i1 = (num1 - 1)/getRows();
                int j1 = (num1 - 1)%getCols();
                int i2 = (num2 - 1)/getRows();
                int j2 = (num2 - 1)%getCols();

                // If the edge is Up or Down (they are on the same row)
                if( (edge.equals("U") || edge.equals("D")) && ((num1 + 1 == num2) || (num2 + 1 == num1)))
                {
                    switch(edge)
                    {
                        case "U":
                            if(dotsBoard[i1][j1].up.getValueOnTile().equals(i) && dotsBoard[i2][j2].up.getValueOnTile().equals(i)  && i1 - 1 > 0 && i2 - 1 > 0)
                            {
                                // Assigning the edge of that object tile to be 1
                                dotsBoard[i1][j1].up.setValueOnTile(~i & 1);
                                dotsBoard[i2][j2].up.setValueOnTile(~i & 1);

                                // Assign the upper edge of the current tile a value of 1, since the down edge of the tile above corresponds to the up edge of the current tile.
                                dotsBoard[i1-1][j1].down.setValueOnTile(~i & 1);
                                dotsBoard[i2-1][j2].down.setValueOnTile(~i & 1);

                                // Assigning the edge colour the player's colour to indicate that it is their fence
                                dotsBoard[i1][j1].up.edgeColour = player.colour;
                                dotsBoard[i2][j2].up.edgeColour = player.colour;

                                dotsBoard[i1-1][j1].down.edgeColour = player.colour;
                                dotsBoard[i2-1][j2].down.edgeColour = player.colour;
                            }
                            else{
                                error.fencePlaced();
                                return false;
                            }
                            break;

                        case "D":
                            if(dotsBoard[i1][j1].down.getValueOnTile().equals(i) && dotsBoard[i2][j2].down.getValueOnTile().equals(i) && i1 + 1 < getRows() && i2 + 1 < getRows())
                            {
                                dotsBoard[i1][j1].down.setValueOnTile(~i & 1);
                                dotsBoard[i2][j2].down.setValueOnTile(~i & 1);

                                dotsBoard[i1][j1].down.edgeColour = player.colour;
                                dotsBoard[i2][j2].down.edgeColour = player.colour;

                                dotsBoard[i1+1][j1].up.setValueOnTile(~i & 1);
                                dotsBoard[i2+1][j2].up.setValueOnTile(~i & 1);

                                dotsBoard[i1+1][j1].up.edgeColour = player.colour;
                                dotsBoard[i2+1][j2].up.edgeColour = player.colour;
                            }
                            else{
                                error.fencePlaced();
                                return false;
                            }
                            break;
                        default:
                            return false;
                    }
                    player.decreaseFences();
                    return true;
                }

                // If the edge is left or right (same column)
                else if ((edge.equals("L") || edge.equals("R")) && ((num1 + 9 == num2) || (num2 + 9 == num1)))
                {
                    switch(edge)
                    {
                        case "L":
                            if(dotsBoard[i1][j1].left.getValueOnTile().equals(i) && dotsBoard[i2][j2].left.getValueOnTile().equals(i)  && j1 - 1 > 0 && j2 - 1 > 0){
                                // Assigning the edge of that object tile to be 1 and assigning the colour
                                dotsBoard[i1][j1].left.setValueOnTile(~i & 1);
                                dotsBoard[i2][j2].left.setValueOnTile(~i & 1);
                                dotsBoard[i1][j1].left.edgeColour = player.colour;
                                dotsBoard[i2][j2].left.edgeColour = player.colour;

                                // Assign the side edge of the current tile a value of 1, since the right edge of the tile above corresponds to the left edge of the current tile.
                                dotsBoard[i1][j1-1].right.setValueOnTile(~i & 1);
                                dotsBoard[i2][j2-1].right.setValueOnTile(~i & 1);
                                dotsBoard[i1][j1-1].right.edgeColour = player.colour;
                                dotsBoard[i2][j2-1].right.edgeColour = player.colour;
                            }
                            else{
                                error.fencePlaced();
                                return false;
                            }
                            break;

                        case "R":
                            if(dotsBoard[i1][j1].right.getValueOnTile().equals(i) && dotsBoard[i2][j2].right.getValueOnTile().equals(i)  && j1 + 1 < getCols() && j2 + 1 < getCols()){
                                dotsBoard[i1][j1].right.setValueOnTile(~i & 1);
                                dotsBoard[i2][j2].right.setValueOnTile(~i & 1);
                                dotsBoard[i1][j1].right.edgeColour = player.colour;
                                dotsBoard[i2][j2].right.edgeColour = player.colour;

                                dotsBoard[i1][j1+1].left.setValueOnTile(~i & 1);
                                dotsBoard[i2][j2+1].left.setValueOnTile(~i & 1);
                                dotsBoard[i1][j1+1].left.edgeColour = player.colour;
                                dotsBoard[i2][j2+1].left.edgeColour = player.colour;
                            }
                            else{
                                error.fencePlaced();
                                return false;
                            }
                            break;
                        default:
                            return false;
                    }
                    player.decreaseFences();
                    return true;
                }
                else {
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return false;
    }

    /**
     * Getting the legal moves for the player to choose from
     * @param i,j the coordinates of the player's current position
     * @return void function
     */
    public void legalMoves(int i, int j)
    {
        // Checking which tiles are adjacent to the current position of the player
        if ( i+1 < getRows()) 
        {
            // Checking if there is an edge blocking a valid move of the player
            if(dotsBoard[i][j].down.getValueOnTile().equals(0))
            {
                // If not, add to legal moves list
                legalMovesList.add((Integer)dotsBoard[i+1][j].piece.getValueOnTile() );
            }
        }

        if ( i-1 >= 0)
        {
            if(dotsBoard[i][j].up.getValueOnTile().equals(0))
            {
                legalMovesList.add((Integer)dotsBoard[i-1][j].piece.getValueOnTile());
            }
        }

        if ( j+1 < getCols())
        {
            if(dotsBoard[i][j].right.getValueOnTile().equals(0))
            {
                legalMovesList.add((Integer)dotsBoard[i][j+1].piece.getValueOnTile());
            }
        }
        if ( j-1 >= 0)
        {
            if(dotsBoard[i][j].left.getValueOnTile().equals(0))
            {
                legalMovesList.add((Integer)dotsBoard[i][j-1].piece.getValueOnTile());
            }
        }
    }

    /**
     * Edge Case - If another player is adjacent to the current player, the current player can jump over them
     * Adding on to the legal moves list of the player if there is a valid edge case
     * @param i,j the coordinates of the player's current position
     * @return void function
     */
    public void edgeCaseMoves(int i, int j){
        int a, b;

        // Getting the tile value of the current position of the player
        int tile = (i*getCols()) + j + 1;

        // Iterating through the list obtained from getLegalMoves()
        for (int l : legalMovesList)
        {
            // Coordinates of the tile
            a = (l - 1)/getRows();
            b = (l - 1)%getCols();

            // If there is a player adjacent to the current player (by checking the playerPositionBoard)
            if( !playerPiecePosition[a][b].piece.getValueOnTile().equals("0"))
            {
                // Getting the legal moves of the other player
                legalMoves(a, b);

                // Removing the tiles of the current player and other player from the list
                if(legalMovesList.contains(l) && legalMovesList.contains(tile)) {
                    legalMovesList.remove(Integer.valueOf(l));
                    legalMovesList.remove(Integer.valueOf(tile));
                }

                //if the players are in the same row
                if (i == a) {
                    //if there is no wall blocking the other player, remove the diagnol moves for the current player
                    //the current player can only jump over the other player in this case
                    if( dotsBoard[a][b].left.getValueOnTile().equals(0) && dotsBoard[a][b].right.getValueOnTile().equals(0)) {
                        if (a - 1 > 0) {
                            int invalid1 = ((a - 1 ) * getCols()) + b + 1;
                            legalMovesList.remove(Integer.valueOf(invalid1));
                        }
                        if (a + 1 < getCols()) {
                            int invalid2 = ((a+1) * getCols()) + b + 1;
                            legalMovesList.remove(Integer.valueOf(invalid2));
                        }
                    }
                }

                // If the players are in the same column
                if (j == b)
                {
                    if( dotsBoard[a][b].up.getValueOnTile().equals(0) && dotsBoard[a][b].down.getValueOnTile().equals(0)) {
                        if (b - 1 > 0) {
                            int invalid1 = (a * getCols()) + b;
                            legalMovesList.remove(Integer.valueOf(invalid1));
                        }
                        if (b + 1 < getCols()) {
                            int invalid2 = (a * getCols()) + b + 2;
                            legalMovesList.remove(Integer.valueOf(invalid2));
                        }
                    }
                }
                break;
            }
        }
    }

    /**
     * Printing an example board to be used for the Instruction class
     * @return void function
     */
    public void printBoardExample() {
        int i, j, val, rows, cols;
        val = 1;
        rows = 9;
        cols = 9;

        System.out.println();
        System.out.println();
        for (i = 0; i < 2 * rows + 1; i++) {
            for (j = 0; j < 2 * cols + 1; j++) {

                // To print *
                if (i % 2 == 0 && j % 2 == 0) {
                    System.out.print("  * ");
                }

                // To print the horizontal edges (up and down)
                else if (i % 2 == 0 && j % 2 == 1) {
                    System.out.print("  ——  ");
                }

                // To print the vertical edges (left and right)
                else if (i % 2 == 1 && j % 2 == 0) {
                    System.out.print("  |  ");
                }

                // To print the initial's of the player
                else if (i % 2 == 1 && j % 2 == 1) {
                    System.out.printf(" %2d  ", val);
                    val++;
                }
                else {
                    System.out.print("     ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}