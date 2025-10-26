/**
 * Filename: PuzzleBoard.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Sept-14
 * Description: A board class for Sliding Puzzle which extends from the abstract board class. Has functions specific
 * to Sliding Puzzle. 
 */

package board;

import java.util.*;
import gameinterfaces.puzzleinterfaces.PuzzleFunctions;

@SuppressWarnings("unchecked")
public class PuzzleBoard extends Board implements PuzzleFunctions{

    public Tile emptySlotTracker = new Tile<>(); //To store the position of the empty tile on the board
    public Map<Integer, Tile> posOfNumber = new HashMap<>(); //to store the current position with their corresponding values
    public Map<Integer, Tile> winState = new HashMap<>();//to store the solved state position with their corresponding values
    List<Integer> adjacentVals = new ArrayList<>();

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
                if (i == getRows() - 1 && j == getCols() - 1) {
                    gameBoard[i][j] = new Tile<Integer>();
                    gameBoard[i][j].setRow(i);
                    gameBoard[i][j].setColumn(j);
                    gameBoard[i][j].piece = new Piece<>(0);
                    emptySlotTracker.setRow(i);
                    emptySlotTracker.setColumn(j);
                }       else {
                    gameBoard[i][j] = new Tile<Integer>();
                    gameBoard[i][j].setRow(i);
                    gameBoard[i][j].setColumn(j);
                    gameBoard[i][j].piece = new Piece<>(arr[k]);
                    posOfNumber.put(arr[k], new Tile<>(i,j));
                    winState.put(arr[k], new Tile<>(i,j));
                    k++;
                }
            }}
        shuffleBoard(); //shuffling the board from a solved state to ensure solvability
    }

    public void shuffleBoard()
    {
        int moves=0;
        Random rand = new Random();

        switch(difficultyLevel) //depending on the difficulty level that the player chose, the board is shuffled N times.
        {
            case 1:
                moves = 20;
                break;
            case 2:
                moves = 50;
                break;
            case 3:
                moves = 100;
                break;
        }

        for (int i = 0; i < moves; i++) { //Here, we get the adjacent values of the empty tile on the board into a list (ensures no invalid moves)
            adjacentVals.clear();
            if (emptySlotTracker.getRow() - 1 >= 0) {
                adjacentVals.add((Integer)gameBoard[emptySlotTracker.getRow()-1][emptySlotTracker.getColumn()].piece.getValueOnTile());
            }
            if (emptySlotTracker.getRow() + 1 < getRows()) {
                adjacentVals.add((Integer)gameBoard[emptySlotTracker.getRow()+1][emptySlotTracker.getColumn()].piece.getValueOnTile());
            }
            if (emptySlotTracker.getColumn() - 1 >= 0) {
                adjacentVals.add((Integer)gameBoard[emptySlotTracker.getRow()][emptySlotTracker.getColumn()-1].piece.getValueOnTile());
            }
            if (emptySlotTracker.getColumn() + 1 < getCols()) {
                adjacentVals.add((Integer)gameBoard[emptySlotTracker.getRow()][emptySlotTracker.getColumn()+1].piece.getValueOnTile());
            }
            if (!adjacentVals.isEmpty()) {
                int val = adjacentVals.get(rand.nextInt(adjacentVals.size())); //selecting a random value from the list of adjacent values
                Tile randNum = posOfNumber.get(val);
                posOfNumber.put(val, new Tile<>(emptySlotTracker.getRow(),emptySlotTracker.getColumn()));

                gameBoard[emptySlotTracker.getRow()][emptySlotTracker.getColumn()].piece.setValueOnTile(val); //swapping the random value with the empty tile.
                gameBoard[randNum.getRow()][randNum.getColumn()].piece.setValueOnTile(0);
                emptySlotTracker.copy(randNum);
            }
        }
    }

    @Override
    public boolean checkBoardState()
    {
        int count = 0;
        for (Map.Entry<Integer, Tile> entry : winState.entrySet()) {
            int number = entry.getKey();
            Tile winTile = entry.getValue();
            Tile currentTile = posOfNumber.get(number); //checks the current tile value with the win state tile value for the same position
            if ((winTile.getRow() == currentTile.getRow()) && (winTile.getColumn() == currentTile.getColumn())) {
                count++; //increment count if the tiles contain the same value
            }
        }
        if(count == (getRows()*getCols()-1)) //if the count is equal to the total number of values in the board, it is solved
        {
            winState.clear(); //to restore the values for the next round
            posOfNumber.clear();
            return true;
        }
        else
        {
            return false;
        }
    }


    public boolean makeMove(int choice)
    {
        if(choice > getRows()*getCols() || choice < 0) //to check if the choice is out of the range
        {
            return true;
        }
        else
        {
            //checking if the value selected is an adjacent tile of the empty tile
            Tile pos = posOfNumber.get(choice);
            if(((emptySlotTracker.getRow() - 1 == pos.getRow() || emptySlotTracker.getRow()+1 == pos.getRow()) && emptySlotTracker.getColumn() == pos.getColumn())
                    ||((emptySlotTracker.getColumn() - 1 == pos.getColumn() || emptySlotTracker.getColumn()+1 == pos.getColumn()) && emptySlotTracker.getRow() == pos.getRow()))
            {
                swap(pos, choice); //swap value with the empty tile
                return false;
            }
            else //if the move is invalid
            {
                boolean invalid = true;
                return true;
            }
        }
    }

    @Override
    public void swap(Tile p, int choice)
    {
        gameBoard[p.getRow()][p.getColumn()].piece.setValueOnTile(0);
        gameBoard[emptySlotTracker.getRow()][emptySlotTracker.getColumn()].piece.setValueOnTile(choice);

        Tile temp = new Tile<>(p);
        p.copy(emptySlotTracker);
        emptySlotTracker.copy(temp);
        printBoardState();
    }

    @Override
    public void printBoardState()
    {
        for(int i=0;i<getRows();i++)
        {   for(int j=0;j<getCols();j++) {
            if (gameBoard[i][j].piece.getValueOnTile().equals(0))
            {
                System.out.print("   "); //printing a space to represent the empty tile on the board
            }
            else
            {
                System.out.print(String.format("%2d ", gameBoard[i][j].piece.getValueOnTile()));
            }
        }
            System.out.println();
        }
    }
}