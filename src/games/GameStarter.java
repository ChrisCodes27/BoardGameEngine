/**
 * Filename: GameStarter.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Oct-02
 * Description: A class which contains the menu of different games for the player to choose from.
 */

package games;

import games.slidingpuzzle.PuzzleGame;
import games.dotsandboxes.DotsAndBoxes;
import games.quoridor.Quoridor;
import printerrormessage.printErrorMessage;

import java.util.*;

public class GameStarter{
    private int choice;
    Scanner inp = new Scanner(System.in);
    printErrorMessage error = new printErrorMessage();
    /**
     * contains a menu of games for the player to choose from
     * @param no parameters
     * @return void function
     */
    public void chooseGame()
    {
        char continueGame = 'N';
        do{
        System.out.println("Welcome! Choose a game from the menu below by entering the corresponding serial number: ");
        System.out.println("    1. Sliding Puzzle");
        System.out.println("    2. Dots And Boxes");
        System.out.println("    3. Quoridor");
        System.out.println("    4. Quit Game");
        System.out.print("Enter Your Choice (1-4):  ");
        try{
            choice = inp.nextInt();}
        catch (InputMismatchException e) {
            error.invalidMenuInput();
            inp.nextLine();
            }

        switch(choice)
        {
            case 1:
                PuzzleGame p = new PuzzleGame(); //Sliding Puzzle
                p.startGame();
                break;
            case 2:
                DotsAndBoxes d = new DotsAndBoxes(); //Dots and Boxes
                d.startGame();
                break;
            case 3:
                int numPlayers;
                System.out.println("Welcome to the Quoridor Game!");
                System.out.println("Please choose either 2 or 4 players!");
                numPlayers = inp.nextInt();
                Quoridor q = new Quoridor(numPlayers); //Quoridor
                q.startGame();
                break;
            case 4:
                System.out.println("See you later!"); //To exit from the game
                System.exit(0);
                break;
            default:
                error.invalidMenuInput();//invalid input
                boolean loop = true;
                break;
        }

        System.out.print("Do you want to play another game? (Y/N):  "); //after a game is played, asks the player if they want to play another type of game

        continueGame = inp.next().charAt(0);
        } while(Character.toLowerCase(continueGame)=='y');
        System.out.println();
        System.out.println("See you later!");
    }
}
