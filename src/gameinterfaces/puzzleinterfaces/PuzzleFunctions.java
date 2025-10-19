/**
 * Filename: PuzzleFunctions.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-09-14
 * Description: An interface for functions specific to Sliding Puzzle
 */

package gameinterfaces.puzzleinterfaces;
import board.Tile;
import board.PuzzleBoard;

public interface PuzzleFunctions{
    public void swap(Tile p, int choice);
}