/**3
 * Filename: Game.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Sept-14
 * Description: The main class to start the entire program.
 */

package main;

import java.util.*;
import games.GameStarter;

public class Game{
    public static void main(String[] args) {
        GameStarter g = new GameStarter();
        // Directs to the class containing the menu
        g.chooseGame();
    }
}