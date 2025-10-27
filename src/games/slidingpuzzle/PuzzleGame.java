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
import games.Games;
import printerrormessage.printErrorMessage;

import java.sql.SQLOutput;
import java.util.*;

public class PuzzleGame extends Games<PuzzlePlayer>{
    public PuzzleBoard board = new PuzzleBoard();
    printErrorMessage error = new printErrorMessage();

    public PuzzleGame()
    {
        super(1);
    }

    /**
     * Initializing the player for the sliding puzzle game
     * @param n
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
        instruction.displaySlidingPuzzleInstructions();

        do{
            System.out.println("Welcome "+ players.get(0).getName()+"!");

            // Validating the input from the player
            while(checkInput == false)
            {
                System.out.println("Please enter the level of the sliding puzzle (rows x column) eg. 2x3");
                size = inp.nextLine();

                // Setting the rows and columns of the board
                checkInput = board.setDimensions(size);
            }

            // Initializing the board for the game with the size
            board.gameBoard = new Tile[board.getRows()][board.getCols()];

            while(checkInput == true)
            {
                System.out.println("Choose your Difficulty Level: 1. EASY 2. MEDIUM 3. HARD (Enter the Serial Number)");

                // Validating input
                while(!inp.hasNextInt())
                {
                    error.invalidMenuInput();
                    inp.next();
                }
                board.difficultyLevel = inp.nextInt();

                // Validating input
                if(board.difficultyLevel > 3 || board.difficultyLevel < 1)
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

            // If the player hasnt won the game
            while(players.get(0).win==false)
            {
                // Get the choice from the player
                players.get(0).move();

                // Make the move according to the choice
                boolean invalid = board.makeMove(players.get(0).choice);

                // If its an invalid move
                if (invalid == true){
                    players.get(0).invalidMove();
                }

                else {
                    // Increment the number of moves since it is a valid move
                    players.get(0).noOfMoves++;
                    stats();
                    checkWhoWon();
                }
            }

            // Check if the player has won and display stats
            players.get(0).checkWin();
            System.out.println("Do you want to play another round? (Y/N)");
            ch = inp.next().charAt(0);
            inp.nextLine();
        }while(Character.toLowerCase(ch)=='y');
    }

    @Override
    public void checkWhoWon()
    {
        // Checking if the game is solved after every move
        players.get(0).win = board.checkBoardState();
    }

    @Override
    public void stats()
    {
        System.out.println("Number of Moves: "+ players.get(0).noOfMoves);
    }
}