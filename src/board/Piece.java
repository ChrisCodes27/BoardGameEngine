/**
 * Filename: Piece.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Oct-02
 * Description: Represents the piece on a tile in the board. It is of Generic type.
 */

package board;

import java.util.*;

public class Piece<T> {
    private T valueOnTile;

    public Piece()
    {
        this.valueOnTile = null;
    }

    public Piece(T value)
    {
        this.valueOnTile = value;
    }

    public T getValueOnTile()
    {
        return valueOnTile;
    }
    public void setValueOnTile(T val)
    {
        this.valueOnTile = val;
    }
}