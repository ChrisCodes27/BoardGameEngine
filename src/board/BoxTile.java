/**
 * Filename: BoxTile.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Oct-03
 * Description: A class which can be used for games such as Dots and Boxes where there is a focus on each edge
 * of the tile. It also has an object of Piece class to indicate the value on the tile.
 */
package board;

import board.boxpiece.Edge;

public class BoxTile<T> extends Tile<T>{
    Edge up, down, left, right;
    //public Piece<String> piece;

    public BoxTile() {
        up = new Edge(0, "none");
        down = new Edge(0, "none");
        left = new Edge(0, "none");
        right = new Edge(0, "none");
    }
}