/**
 * Filename: Edge.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Oct-05
 * Description: Represents each edge of a tile in a board. It extends Piece and has an attribute edgeColour.
 */

package board;

public class Edge extends Piece<Integer>{
    public String edgeColour;
    public Edge(Integer value, String edgeColour) {
        super(value);
        this.edgeColour = edgeColour;
    }
}