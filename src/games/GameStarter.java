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
     * @return void function
     */
    public void chooseGame()
    {
        char continueGame = 'N';
        // Main menu
        do{
        System.out.println("Welcome! Choose a game from the menu below by entering the corresponding serial number: ");
        System.out.println("    1. Sliding Puzzle");
        System.out.println("    2. Dots And Boxes");
        System.out.println("    3. Quoridor");
        System.out.println("    4. Quit Game");
        System.out.print("Enter Your Choice (1-4):  ");
        try
        {
            choice = inp.nextInt();
            System.out.println();
        }
        catch (InputMismatchException e)
        {
            // Handles exception cases
            error.invalidMenuInput();
            inp.nextLine();
        }

        // Players input is checked in switch case
        switch(choice)
        {
            // Sliding Puzzle
            case 1:
                PuzzleGame p = new PuzzleGame();
                p.startGame();
                break;

            // Dots and Boxes
            case 2:
                DotsAndBoxes d = new DotsAndBoxes();
                d.startGame();
                break;

            // Quoridor
            case 3:
                Quoridor q = new Quoridor();
                q.startGame();
                break;

            // Exit from the game
            case 4:
                System.out.println("See you later!");
                System.exit(0);
                break;

            // Handles invalid inputs
            default:
                error.invalidMenuInput();
                boolean loop = true;
                break;
        }

        // After a game is played, asks the player if they want to play another type of game
        System.out.print("Do you want to play another game? (Y/N):  ");

        // Players response
        continueGame = inp.next().charAt(0);
        } while(Character.toLowerCase(continueGame)=='y');
        System.out.println();
        System.out.println("See you later!");
    }
}
