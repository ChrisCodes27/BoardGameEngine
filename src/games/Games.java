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
import gameinterfaces.Instructions;
import player.Player;
import java.util.*;

public abstract class Games<T extends Player> implements GameFunctions, Instructions{
    protected int numOfPlayers;
    protected List<T> players = new ArrayList<>();
    Scanner inp = new Scanner(System.in);
    public boolean isGameDone = false;

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
            System.out.println("Player "+(i+1)+", enter your username"); // To iterate through the list of players and get their names
            temp = inp.nextLine();
            player.setName(temp);
            i++;
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
    
}