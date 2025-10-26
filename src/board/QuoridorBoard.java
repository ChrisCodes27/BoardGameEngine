package board;

import java.util.*;
import gameinterfaces.puzzleinterfaces.PuzzleFunctions;
import player.QuoridorPlayer;
import colour.colour;
import printerrormessage.printErrorMessage;

@SuppressWarnings("unchecked")
public class QuoridorBoard extends DotsAndBoxesBoard{

    //public BoxTile[][] quoridorBoard;
    public Tile[][] playerPiecePosition;
    private List<Integer> legalMovesList;
    printErrorMessage error = new printErrorMessage();

    public QuoridorBoard()
    {
        legalMovesList = new ArrayList<>();
    }

    public List<Integer> getLegalMovesList()
    {
        return legalMovesList;
    }

    @Override
    public void initializeBoard()
    {
        initializePlayerPositionBoard();
        int[] arr;
        arr = new int[getRows()*getCols()]; //getting an array of numbers within the range of the board dimensions
        int k =0;
        for(int i =0;i<arr.length;i++)
        {
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

    public void initializePlayerPositionBoard()
    {
        playerPiecePosition = new Tile[getRows()][getCols()];
        for(int i =0;i<getRows();i++){
            for(int j=0;j<getCols();j++){
                //playerPiecePosition[i][j] = new Tile();
                //playerPiecePosition[i][j].val = new Piece<>(0);
                playerPiecePosition[i][j] = new Tile<String>();
                playerPiecePosition[i][j].piece = new Piece<>("0");
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
        //Iterating through an abstract matrix of (2n+1,2m+1). This includes the * and the edges. The *'s start from
        //0 and are incremented by n+2 while the edges start from 1 and increment by n+2.
        for (i=0; i<2*getRows()+1;i++)
        {
            for (j=0; j<2*getCols()+1;j++)
            {
                //to print *
                if (i%2 == 0 && j%2 == 0) //Every * is located at an even position, so we check for i and j %2 = 0
                {
                    System.out.print("  * ");
                }
                //to print the horizontal edges (up and down)
                else if (i%2 == 0 && j%2 == 1) //Every up and down edge is located at a position where the i is even and j is odd inside the abstract matrix
                {
                    int row = i/2;
                    int col = j/2;

                    if (row < getRows()+1 && col < getCols())
                    {
                        if(row < getRows() && dotsBoard[row][col].up.getValueOnTile().equals(1))
                        {System.out.print(dotsBoard[row][col].up.edgeColour+ "  —— " +c.endColour);}
                        else if(row > 0 && dotsBoard[row-1][col].down.getValueOnTile().equals(1))
                        {System.out.print(dotsBoard[row-1][col].down.edgeColour+ "  —— " +c.endColour);}
                        else
                        {System.out.print("  —— ");}
                    }
                }
                //to print the vertical edges (left and rigt)
                else if (i%2 == 1 && j%2 == 0) //The left and right edges are located at positions where i is odd and j is even inside the abstract matrix
                {
                    int row = i/2;
                    int col = j/2;

                    if (row < getRows() && col < getCols() + 1)
                    {
                        if(col < getCols() && dotsBoard[row][col].left.getValueOnTile().equals(1))
                        {System.out.print(dotsBoard[row][col].left.edgeColour+ "    | " +c.endColour);}
                        else if(col > 0 && dotsBoard[row][col-1].right.getValueOnTile().equals(1))
                        {System.out.print(dotsBoard[row][col-1].right.edgeColour+ "    | " +c.endColour);}
                        else
                        {System.out.print("   | ");}
                    }
                } 
                //to print the intitals of the player if all four edges of a tile is 1
                else if (i%2 == 1 && j%2 == 1) //When both i and j are odd, to mark the initial of the player if they have a box claimed
                {
                    int row = (i-1)/2;
                    int col = (j-1)/2;

                    if (i == 1 && !playerPiecePosition[row][col].piece.getValueOnTile().equals("0"))
                    {System.out.print("  "+ playerPiecePosition[row][col].piece.getValueOnTile()+" ");}
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

    public boolean setFence(String fence, QuoridorPlayer player, int i)
    {
        fence = fence.trim();
        String[] parts = fence.split("\\s+");

        int num1 = 0, num2 = 0;
        String edge = " ";

        if (parts.length == 3) {
            num1 = Integer.parseInt(parts[0]);
            num2 = Integer.parseInt(parts[1]);
            edge = parts[2].toUpperCase();
            if(num1 > 0 && num1 < (getRows()*getCols()) && num2 > 0 && num2 < (getRows()*getCols()) && ((num1 + 1 == num2) || (num2 == num1 + 9) || (num2 + 1 == num1) || (num1 == num2 + 9)))
            {
                int i1 = (num1 - 1)/getRows();
                int j1 = (num1 - 1)%getCols();
                int i2 = (num2 - 1)/getRows();
                int j2 = (num2 - 1)%getCols();
                if( (edge.equals("U") || edge.equals("D")) && ((num1 + 1 == num2) || (num2 + 1 == num1)))
                {
                    switch(edge)
                    {
                        case "U":
                            if(dotsBoard[i1][j1].up.getValueOnTile().equals(i) && dotsBoard[i2][j2].up.getValueOnTile().equals(i))
                            {
                                dotsBoard[i1][j1].up.setValueOnTile(~i & 1);
                                dotsBoard[i2][j2].up.setValueOnTile(~i & 1);

                                dotsBoard[i1-1][j1].down.setValueOnTile(~i & 1);
                                dotsBoard[i2-1][j2].down.setValueOnTile(~i & 1);

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
                            if(dotsBoard[i1][j1].down.getValueOnTile().equals(i) && dotsBoard[i2][j2].down.getValueOnTile().equals(i))
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
                else if ((edge.equals("L") || edge.equals("R")) && ((num1 + 9 == num2) || (num2 + 9 == num1)))
                {
                    switch(edge)
                    {
                        case "L":
                            if(dotsBoard[i1][j1].left.getValueOnTile().equals(i) && dotsBoard[i2][j2].left.getValueOnTile().equals(i))
                            {
                                dotsBoard[i1][j1].left.setValueOnTile(~i & 1);
                                dotsBoard[i2][j2].left.setValueOnTile(~i & 1);
                                dotsBoard[i1][j1].left.edgeColour = player.colour;
                                dotsBoard[i2][j2].left.edgeColour = player.colour;

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
                            if(dotsBoard[i1][j1].right.getValueOnTile().equals(i) && dotsBoard[i2][j2].right.getValueOnTile().equals(i))
                            {
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
                else
                {
                    return false;
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


    public void legalMoves(int i, int j)
    {
        if ( i+1 < getRows())
        {
            if(dotsBoard[i][j].down.getValueOnTile().equals(0))
            {
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

    public void edgeCaseMoves(int i, int j){
        int a, b;
        int tile = (i*getCols()) + j + 1;

        for (int l : legalMovesList)
        {
            a = (l - 1)/getRows();
            b = (l - 1)%getCols();

            if( !playerPiecePosition[a][b].piece.getValueOnTile().equals("0"))
            {

                legalMoves(a, b);

                if(legalMovesList.contains(l) && legalMovesList.contains(tile)) {
                    legalMovesList.remove(Integer.valueOf(l));
                    legalMovesList.remove(Integer.valueOf(tile));
                }
                    if (i == a)
                    {
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

    public void printBoardExample() {
        int i, j, val;
        val = 1;

        for (i = 0; i < 2 * getRows() + 1; i++) {
            for (j = 0; j < 2 * getCols() + 1; j++) {
                // To print *
                if (i % 2 == 0 && j % 2 == 0) {
                    System.out.print("  * ");
                }

                //To print the horizontal edges (up and down)
                else if (i % 2 == 0 && j % 2 == 1) {
                    System.out.print("  —— ");
                }

                // To print the vertical edges (left and right)
                else if (i % 2 == 1 && j % 2 == 0) {
                    System.out.print("    | ");
                }

                // To print the intital's of the player
                else if (i % 2 == 1 && j % 2 == 1) {
                    System.out.print("  " + val + " ");
                    val++;
                }
            }
            System.out.println();
        }

    }
}