/**
 * Filename: Tile.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Oct-02
 * Description: Represents the Tile on a board. Each tile will have certain characteristics -
 * its position on the board - indicated by row and column and the value of the tile which is an
 * object of class Piece.
 */

package board;

import java.util.*;

public class Tile{
    private int row;
    private int column;
    public Piece<Integer> val;

    public void setRow(int row)
    {
        this.row = row;
    }

    public void setColumn(int column)
    {
        this.column = column;
    }

    public int getRow()
    {
        return row;
    }

    public int getColumn()
    {
        return column;
    }

    public Tile()
    {}

    public Tile(int row, int column)
    {
        this.row = row;
        this.column = column;
    }
    public Tile(Tile copy)
    {
        this.row = copy.row;
        this.column = copy.column;
    }
    public void copy(Tile copy)
    {
        this.row = copy.row;
        this.column = copy.column;
    }
    public String toString(){
        return "("+row+","+column+")";
    }
}