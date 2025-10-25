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

    Scanner inp = new Scanner(System.in);
    public boolean isGameDone = false;
    public int indexOfPlayer;

    public Games(int n)
    {
        initializePlayers(n); //Initializes the players of each type of game. Refers to the implementation in its own class
    }

    public void setPlayerCount(int n)
    {
        this.numOfPlayers = n;
    }

    public int getPlayerCount()
    {
        return numOfPlayers;
    }

    public void setPlayerName()
    {
        int i = 0;
        String temp;
        for(T player: players)
        {
            System.out.print("Player "+(i+1)+", Enter your username:    "); // To iterate through the list of players and get their names
            temp = inp.nextLine();
            player.setName(temp);
            i++;
        }
    }

    public int getNextPlayer(int indexOfPlayer)
    {
        if(indexOfPlayer + 1 < players.size())
        {
            return indexOfPlayer + 1;
        }
        else{
            return 0;
        }
    }

    /**
     * To restore the variables of Games class if the user decides to play another round
     * @param -
     * @return void function
     */
    public void restore()
    {
        isGameDone = false;
    }

    public abstract void initializePlayers(int num);

    public abstract void startGame();

    public abstract void checkWhoWon();

    public abstract void stats();

}