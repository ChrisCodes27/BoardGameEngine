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

public class Tile<T>{
    private int row;
    private int column;
    public Piece<T> piece;

    /**
     * Constructs a Tile with the specified row and column.
     * @param row The row index of the tile.
     * @param column The column index of the tile.
     */
    public Tile(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Constructs a Tile with the same coordinates
     * @param copy The tile to copy values from.
     */
    public Tile(Tile copy) {
        this.row = copy.row;
        this.column = copy.column;
    }

    /**
     * Updates the current tile's coordinates to match another tile.
     * @param copy The tile whose coordinates should be copied.
     */
    public void copy(Tile copy) {
        this.row = copy.row;
        this.column = copy.column;
    }

    /**
     * Sets the row index of this tile.
     * @param row The new row value.
     */

    public void setRow(int row)
    {
        this.row = row;
    }

    /**
     * Sets the column index of this tile
     * @param column The new column value.
     */
    public void setColumn(int column)
    {
        this.column = column;
    }

    /**
     * Retrieves the row index of this tile
     * @return The current row index
     */
    public int getRow()
    {
        return row;
    }

    /**
     * Retrieves the column index of this tile
     * @return The current column index
     */
    public int getColumn()
    {
        return column;
    }

    public Tile()
    {}

    /**
     * Returns a string representation of this tile in coordinate form
     * @return A string
     */
    public String toString(){
        return "("+row+","+column+")";
    }
}