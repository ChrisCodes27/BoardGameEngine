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

import java.util.*;

public class GameStarter{
    private int choice;
    Scanner inp = new Scanner(System.in);

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
        System.out.println("1. Sliding Puzzle");
        System.out.println("2. Dots And Boxes");
        System.out.println("3. Quoridor");
        System.out.println("4. Quit Game");
        
        choice = inp.nextInt();
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
                System.out.println("Choose a number from the menu!"); //invalid input
                break;
        }
        System.out.println("Do you want to play another game? (Y/N)"); //after a game is played, asks the player if they want to play another type of game

        continueGame = inp.next().charAt(0);
        }while(Character.toLowerCase(continueGame)=='y');

        System.out.println("See you later!");
    }
}
