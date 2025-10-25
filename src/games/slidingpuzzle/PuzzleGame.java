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
        instruction.displaySlidingPuzzleInstructions();

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
                    stats();
                    checkWhoWon();
                }
            }
            players.get(0).checkWin(); //check if the player has won and display stats
            System.out.println("Do you want to play another round? (Y/N)");
            ch = inp.next().charAt(0);
            inp.nextLine();
        }while(Character.toLowerCase(ch)=='y');
    }

    @Override
    public void checkWhoWon()
    {
        players.get(0).win = board.checkBoardState(); //checking if the game is solved after every move
    }

    @Override
    public void stats()
    {
        System.out.println("Number of Moves: "+ players.get(0).noOfMoves);
    }
}