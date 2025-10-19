/**
 * Filename: colour.java
 * Author: Chris Mary Benson, Nandana Shashi
 * Date: 2025-Oct-05
 * Description: A class which contains different ANSI codes for colours.
 */

package colour;

import java.util.*;

public class colour{
    public String red = "\u001B[31m";
    public String green = "\u001B[32m";
    public String endColour = "\u001B[0m";
    public List<String> colours;
    
    public colour()
    {
        colours = Arrays.asList(red, green); //An list of two colours for a two player game
    }
}