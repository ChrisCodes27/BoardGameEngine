/**
 * Filename: PuzzleGame.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Sept-14
 * Description: A central class for the Sliding Puzzle game. Extends the Games class
 */

package games.slidingpuzzle;

import board.Tile;
import player.PuzzlePlayer;
import board.PuzzleBoard;
import gameinterfaces.GameFunctions;
import gameinterfaces.Instructions;
import games.Games;
import printerrormessage.printErrorMessage;

import java.sql.SQLOutput;
import java.util.*;

public class PuzzleGame extends Games<PuzzlePlayer>{
    Scanner inp = new Scanner(System.in);
    public PuzzleBoard board = new PuzzleBoard();
    printErrorMessage error = new printErrorMessage();

    public PuzzleGame()
    {
        super(1);
    }

    /**
     * Initializing the player for the sliding puzzle game
     * @param i
     * @return void function
     */
    @Override
    public void initializePlayers(int n)
    {
        int i = 0;
        while(i < n)
        {
          players.add(new PuzzlePlayer());
          i++;
        }
    }

    /**
     * starting point of the game
     * @param No parameters
     * @return void function
     */
    @Override
    public void startGame()
    {
        String name = " ";
        String size;
        char ch = 'N';
        System.out.println("Hello! Welcome to the Sliding Puzzle Game, what is your name?");
        System.out.println();
        name = inp.next();
        inp.nextLine();
        players.get(0).setName(name);
        boolean checkInput = false;
        displayInstructions();

        do{
            System.out.println("Welcome "+ players.get(0).getName()+"!");
            while(checkInput == false) //validating the input from the player
            {
                System.out.println("Please enter the level of the sliding puzzle (rows x column) eg. 2x3");
                size = inp.nextLine();
                checkInput = board.setDimensions(size); //setting the rows and columns of the board
            } 

            board.gameBoard = new Tile[board.getRows()][board.getCols()]; //initializing the board for the game with the size

            while(checkInput == true)
            {
                System.out.println("Choose your Difficulty Level: 1. EASY 2. MEDIUM 3. HARD (Enter the Serial Number)");
                while(!inp.hasNextInt()) //validating input
                {
                    error.invalidMenuInput();
                    inp.next();
                }
                board.difficultyLevel = inp.nextInt();
                if(board.difficultyLevel > 3 || board.difficultyLevel < 1) //validating input
                {
                    error.invalidMenuInput();
                }
                else{
                    checkInput = false;
                }
            }

            System.out.println("BEGIN!");
            board.initializeBoard();
            board.printBoardState();
            while(players.get(0).win==false) //if the player hasnt won the game
            {
                players.get(0).move(); //get the choice from the player
                boolean invalid = board.makeMove(players.get(0).choice); //make the move according to the choice
                if (invalid == true) //if its an invalid move
                {
                    players.get(0).invalidMove();
                }
                else
                {
                    players.get(0).noOfMoves++; //increment the number of moves since it is a valid move
                    System.out.println("Number of Moves: "+ players.get(0).noOfMoves);
                    players.get(0).win = board.checkBoardState(); //checking if the game is solved after every move
                }
            }
            players.get(0).checkWin(); //check if the player has won and display stats
            System.out.println("Do you want to play another round? (Y/N)");
            ch = inp.next().charAt(0);
            inp.nextLine();
        }while(Character.toLowerCase(ch)=='y');
    }
    
    /**
     * to display the instructions of the game to the user
     * @param No parameters
     * @return void function
     */
    @Override
    public void displayInstructions()
    {
        System.out.println("------------------------------------------");
        System.out.println("               SLIDING PUZZLE");
        System.out.println("------------------------------------------");
        System.out.println();
        System.out.println("GOAL: Get the numbers in the puzzle in order (starting 1,2,3 ...) from left to right of each row in the board!");
        //System.out.println(printBoardState());
        System.out.println("HOW TO PLAY:");
        System.out.println("1. The board first begins in a shuffled state, you can only move the numbers which are adjacent to the empty tile.");
        System.out.println("2. To move a tile, type the number present on the tile");
        System.out.println("   Example:");
        System.out.println("      Enter move: 5  → Swaps 5 with the empty tile");
        System.out.println("      Enter move: 3  → Invalid Move");
        System.out.println();
        System.out.println();
        System.out.println("You have completed the puzzle when it is in order!");
        System.out.println("------------------------------------------");
    }

}