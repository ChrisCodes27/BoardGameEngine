/**
 * Filename: Games.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Oct-02
 * Description: An abstract class that serves as a base to other game classes of specific game types. This class consists
 * of a List of generic type to use for any kind of game player (works well for multiplayer games). Main use case to initialize
 * any number of players and get their details.
 */

package games;

import gameinterfaces.GameFunctions;
import player.DotsAndBoxesPlayer;
import printerrormessage.printErrorMessage;
import instructions.Instructions;
import colour.colour;
import player.Player;
import java.util.*;

public abstract class Games<T extends Player>{
    protected int numOfPlayers;
    protected List<T> players = new ArrayList<>();
    public printErrorMessage error = new printErrorMessage();
    public colour c = new colour();
    public Instructions instruction = new Instructions();
    public Scanner inp = new Scanner(System.in);
    public boolean isGameDone = false;
    public int indexOfPlayer;

    /**
     * Constructs a Games object and initializes the players.
     * @param n The number of players participating in the game.
     */
    public Games(int n)
    {
        initializePlayers(n); //Initializes the players of each type of game. Refers to the implementation in its own class
    }

    /**
     * Sets the total number of players in the game.
     * @param n The number of players.
     */
    public void setPlayerCount(int n) {
        this.numOfPlayers = n;
    }

    /**
     * Returns the current number of players.
     * @return The number of players in the game.
     */
    public int getPlayerCount()
    {
        return numOfPlayers;
    }

    /**
     * Prompts each player to enter their username and assigns it.
     * Iterates through the player list and updates their names
     */
    public void setPlayerName()
    {
        int i = 0;
        String temp;
        boolean flagName;
        // To iterate through the list of players and get their names
        for(T player: players)
        {
            flagName = true;
            while (flagName)
            {
                System.out.print("Player "+(i+1)+", Enter your username:    ");
                temp = inp.nextLine();
                if(!temp.trim().equals(""))
                {
                    player.setName(temp);
                    flagName = false;
                    i++;
                }
                else
                {
                    error.invalidName();
                }
            }
        }
    }

    /**
     * Determines the index of the next player in turn order.
     * @param indexOfPlayer The index of the current player.
     * @return The index of the next player; or 0 if at the end of the list
     */
    public int getNextPlayer(int indexOfPlayer)
    {
        if(indexOfPlayer + 1 < players.size()) {
            return indexOfPlayer + 1;
        }

        else{
            return 0;
        }
    }

    /**
     * To restore the variables of Games class if the user decides to play another round
     * @return void function
     */
    public void restore() {
        isGameDone = false;
    }

    /**
     * Assigning a colour to each player in the game
     * @return void function
     */
    public void assignColour() {
        colour c = new colour();
        int i =0;
        for(T player: players) {
            player.colour = c.colours.get(i);
            i++;
        }
    }

    /**
     * Abstract method to initialize the players for a specific game.
     * Each subclass should create and configure its player objects here
     * @param num The number of players to initialize.
     */
    public abstract void initializePlayers(int num);

    /**
     * Abstract method that defines the main game loop or flow.
     * Each subclass implements the logic for starting and running its game
     */
    public abstract void startGame();

    /**
     * Abstract method that checks if any player has met the win conditions.
     * Should be called after each move or round
     */
    public abstract void checkWhoWon();

    /**
     * Abstract method that displays game statistics such as scores or win records.
     */
    public abstract void stats();

}