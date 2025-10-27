# CS611 Assignment  3
## QUORIDOR  
---------------------------------------------------------------------------


- Group: 
Name: Chris Mary Benson
Email: chris27@bu.edu
ID: U56085268
-
Name: Nandana Shashi
Email: nanda03@bu.edu
ID: U05556171


Github Link: https://github.com/ChrisCodes27/BoardGameEngine.git


## Files
---------------------------------------------------------------------------
(NOTE: * indicates the files added in this assignment)


Game.java - Contains the main class where an instance of the GameStarter class is initialized.
GameStarter.java - Displays the menu of games to the player to choose from.
DotsAndBoxes.java - A class specific for the DotsAndBoxes game.
PuzzleGame.java  - A class specific for the Sliding Puzzle game.
*Quoridor.java -  A class specific for the Quoridor game.




Board.java - Abstract class that serves as a base class for other boards of specific games.
DotsAndBoxesBoard.java - A Board class that consists of attributes specific to the Dots and Boxes game.
PuzzleBoard.java - A Board class that consists of attributes specific to the Sliding Puzzle.
*QuoridorBoard.java - A Board class that consists of attributes specific to Quoridor.


Player.java - Abstract class that serves as a base class for other players of specific games.
DotsAndBoxesPlayer.java - A player class that consists of attributes specific to the dots and boxes game, such as move(), etc.
PuzzlePlayer.java - A player class that consists of attributes specific to the sliding puzzle game, such as move(), etc.
*QuoridorPlayer.java - A player class that consists of attributes specific to the quoriodor game, such as move(), etc.


Tile.java - Represents the tile on the board. Each tile will have certain characteristics - its position on the board indicated by the row and column and also the value on the tile which is represented by an object of the Piece class.
BoxTile.java - A class that can be used for games such as dots and boxes, which focuses on the edges of a tile. It also has an object of the Piece class, which represents the value on the tile.
Edge.java - Represents each edge of a tile on the board. It extends Piece and has an attribute edgeColour.
Piece.java - Represents a piece on a tile on the board. It is of generic type.


Colour.java - A class which contains the ANSI codes for colours.
PrintErrorMessage.java - A class to print the error messages.
*Instructions.java - A class to print the instructions for each game




## Notes
---------------------------------------------------------------------------
- Made a utility class called Instruction to print the instructions for each game.
- Made colour an attribute of the Player class, so now each player can be assigned a colour that is used to mark the fences claimed by the player in the game.
- QuoridorBoard class extends the DotsAndBoxesBoard class to make use of the board which has common attributes between the two games.
- Implemented BFS algorithm (which finds the shortest path) to check whether each player has a way to get to its goal state whenever a player places a fence.


(Note: In the output on terminal, each edge claimed by a player has its own colour.)


* Made use of the generic type across a few classes, such as the Games class, to allow initialization of multiple players in multiplayer games.
* Made use of interfaces such as BoardFunctions for common jobs, such as printing and initializing the board.


## How to compile and run
---------------------------------------------------------------------------


* unzip Assignment3.zip
* cd BoardGameEngine
* mkdir -p out
* javac -d out/ $(find src -name "*.java")
* java -cp out main.Game




________________


## Input/Output Example
---------------------------------------------------------------------------
OUTPUT
Welcome! Choose a game from the menu below by entering the corresponding serial number: 
    1. Sliding Puzzle
    2. Dots And Boxes
    3. Quoridor
    4. Quit Game
Enter Your Choice (1-4):  


* INPUT :         3


OUTPUT
Welcome to the Quoridor Game!


Player 1, Enter your username:    


* INPUT :         Nanda


OUTPUT
Player 2, Enter your username: 
 
* INPUT :         “      “


OUTPUT         
Name Must Contain Characters (A - Z)!


Player 2, Enter your username:  
  
* INPUT :         Chris


OUTPUT
Nanda:10
Chris:10


----------------------------------------------------------
                       QUORIDOR                          
-----------------------------------------------------------


GOAL: Reach the opposite side of the board before your opponent! Each player moves their pawn across the 9x9 grid while strategically placing walls to block the other player’s path.


HOW TO PLAY:


1. The board is labeled with numbers from 1 to 81, representing each tile position.




    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    N    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    |   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    |   39    |   40    |   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    |   48    |   49    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    |   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |    C    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 




2. On your turn, you are given two options:
   +> Make Your Move : Move your pawn to a valid adjacent tile by entering its tile number.
     Example:
        These are your legal moves: 14  6  4 
        Enter your move: 14  moves your pawn to tile 46.


   +> Place a wall: You may place a wall between two adjacent tiles to block your opponent’s path.
     Walls can be placed horizontally or vertically, using the direction 'U' (up) or 'D' (down).
     Example:
        Enter move: 45 46 U  → places a horizontal wall above tiles 45 and 46.
        Enter move: 1 10 D   → places a vertical wall below tiles 1 and 10.


3. An option to quit will always be present during the players move.
4. You will not be allowed to completely block your opponents path towards the goal, just enough to mildly irritate them.


 MAY THE BEST PLAYER WIN!


--------------------------------------------------------------------------------


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    N    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    |   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    |   39    |   40    |   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    |   48    |   49    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    |   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |    C    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  14  6  4  
Enter your move: 


* INPUT : 14


OUTPUT
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |    N    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    |   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    |   39    |   40    |   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    |   48    |   49    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    |   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |    C    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 10      Chris's fences: 10      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         5


OUTPUT
Invalid Input! Select a valid item from the menu.  


-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         Whoops


OUTPUT
Invalid move! Select a valid move!


-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         23 24 d


OUTPUT
Invalid move! Select a valid move!


-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         12


OUTPUT
Invalid Input! Select a valid item from the menu.  


-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  68  78  76  
Enter your move: 


* INPUT :         60


OUTPUT
Invalid move! Select a valid move!


These are your legal moves:  68  78  76  
Enter your move: 


* INPUT :           68


OUTPUT
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |    N    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    |   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    |   39    |   40    |   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    |   48    |   49    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    |   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |    C    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 10      Chris's fences: 10      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         2


OUTPUT
Enter the tile numbers and the direction of the wall you want to place: 


* INPUT :           23 24 u


OUTPUT
Fence placed!




  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |    N    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    |   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    |   39    |   40    |   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    |   48    |   49    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    |   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |    C    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 9      Chris's fences: 10      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3): 


* INPUT :          2


OUTPUT
Enter the tile numbers and the direction of the wall you want to place: 


* INPUT :         60 61 d


OUTPUT
Fence placed!




  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |    N    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    |   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    |   39    |   40    |   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    |   48    |   49    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    |   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |    C    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 9      Chris's fences: 9      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3): 


* INPUT :          1


OUTPUT
These are your legal moves:  5  15  13  
Enter your move: 


* INPUT :         13


OUTPUT
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |    N    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    |   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    |   39    |   40    |   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    |   48    |   49    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    |   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |    C    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 9      Chris's fences: 9      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         2


OUTPUT
Enter the tile numbers and the direction of the wall you want to place: 


* INPUT :         14 15 r


OUTPUT
Invalid Placement! Select a Valid Fence Position! (Fence already placed or intersects with an existing fence.)


Enter the tile numbers and the direction of the wall you want to place: 


* INPUT :         39 48 l


OUTPUT
Fence placed!




  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |    N    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    |   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    |   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    |   49    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    |   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |    C    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 9      Chris's fences: 8      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  22  4  14  12  
Enter your move: 




* INPUT :         22


OUTPUT
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |    N    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    |   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    |   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    |   49    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    |   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |    C    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 9      Chris's fences: 8      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         c


OUTPUT
Invalid move! Select a valid move!


-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         2


OUTPUT
Enter the tile numbers and the direction of the wall you want to place: 


* INPUT :         32 41 l


OUTPUT
Fence placed!




  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |    N    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    |   49    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    |   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |    C    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 9      Chris's fences: 7      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  31  13  23  21  
Enter your move: 


* INPUT :         31


OUTPUT
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |    N    #   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    |   49    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    |   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |    C    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 9      Chris's fences: 7      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  77  59  69  67  


Enter your move: 


* INPUT :         67
________________


OUTPUT


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |    N    #   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    |   49    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    |   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |    C    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 9      Chris's fences: 7      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  40  22  30  


Enter your move: 


* INPUT :         40


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |    N    #   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    |   49    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    |   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |    C    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 9      Chris's fences: 7      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  76  58  68  66  
Enter your move: 


* INPUT :         58


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |    N    #   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    |   49    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    |    C    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 9      Chris's fences: 7      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         2


OUTPUT
Enter the tile numbers and the direction of the wall you want to place: 


* INPUT :         48 57 r


OUTPUT
Fence placed!




  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |    N    #   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #    C    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 8      Chris's fences: 7      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  67  49  59  
Enter your move: 


* INPUT :         49


OUTPUT


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |    N    #   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #    C    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 8      Chris's fences: 7      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  31  39  58  


Enter your move: 


* INPUT :         58


OUTPUT


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #    C    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #    N    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 8      Chris's fences: 7      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         2


OUTPUT
Enter the tile numbers and the direction of the wall you want to place: 


* INPUT :         67 68 u


OUTPUT
Fence placed!




  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #    C    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #    N    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 8      Chris's fences: 6      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  59  40  
Enter your move: 


* INPUT :         40


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |    N    #   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #    C    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 8      Chris's fences: 6      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         2


OUTPUT
Enter the tile numbers and the direction of the wall you want to place: 


* INPUT :         30 31 d


OUTPUT
Fence placed!


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |    N    #   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #    C    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 8      Chris's fences: 5      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  39  58  
Enter your move: 


* INPUT :         39


OUTPUT
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #    N    |   40    #   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #    C    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 8      Chris's fences: 5      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  58  40  50  
Enter your move: 


* INPUT :         50


OUTPUT


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #    N    |   40    #   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |    C    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 8      Chris's fences: 5      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  48  40  
Enter your move: 


* INPUT :         40


OUTPUT


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |    N    #   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |    C    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 8      Chris's fences: 5      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  
* INPUT :         1


OUTPUT
These are your legal moves:  59  41  51  49  
Enter your move: 


* INPUT :         51


OUTPUT


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |    N    #   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |   50    |    C    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 8      Chris's fences: 5      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  49  39  
Enter your move: 


* INPUT :         49


OUTPUT
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #    N    |   50    |    C    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 8      Chris's fences: 5      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  60  42  52  50  
Enter your move: 


* INPUT :         50




OUTPUT


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #    N    |    C    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 8      Chris's fences: 5      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3): 
 
* INPUT :         2


OUTPUT
Enter the tile numbers and the direction of the wall you want to place: 


* INPUT :         41 42 D


OUTPUT
Fence placed!




  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #    N    |    C    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 7      Chris's fences: 5      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  59  51  58  40  
Enter your move: 


* INPUT :         58


OUTPUT


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #    N    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #    C    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 7      Chris's fences: 5      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         2


OUTPUT
Enter the tile numbers and the direction of the wall you want to place: 


* INPUT :         56 57 U


OUTPUT
Fence placed!




  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #    N    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #    C    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 6      Chris's fences: 5      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  59  40  
Enter your move: 


* INPUT :         59


OUTPUT


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #    N    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |    C    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 6      Chris's fences: 5      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         2


OUTPUT
Enter the tile numbers and the direction of the wall you want to place: 


* INPUT :         51 60 L


OUTPUT
No Valid Path Available For Your Opponent! Illegal Move!


Enter the tile numbers and the direction of the wall you want to place: 


* INPUT :         33 42 R


OUTPUT
Fence placed!




  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #    N    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |    C    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 5      Chris's fences: 5      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         2


OUTPUT
Enter the tile numbers and the direction of the wall you want to place: 


* INPUT :         9 188 R


IOUTPUT
Invalid Placement! Select a Valid Fence Position! (Fence already placed or intersects with an existing fence.)


Enter the tile numbers and the direction of the wall you want to place: 


* INPUT :         9 18 R


OUTPUT
Invalid Placement! Select a Valid Fence Position! (Fence already placed or intersects with an existing fence.)


Enter the tile numbers and the direction of the wall you want to place: 


* INPUT :         17 18 U


OUTPUT
Fence placed!




  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #    N    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |    C    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 5      Chris's fences: 4      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  58  40  50  
Enter your move: 


* INPUT :         50


OUTPUT


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |    N    |   51    |   52    |   53    |   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |    C    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 5      Chris's fences: 4      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  60  58  51  49  
Enter your move: 


* INPUT :         60


OUTPUT 


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |    N    |   51    |   52    |   53    |   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |    C    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 5      Chris's fences: 4      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         2


OUTPUT
Enter the tile numbers and the direction of the wall you want to place: 


* INPUT :         73 64 R


OUTPUT
Fence placed!




  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |    N    |   51    |   52    |   53    |   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |    C    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 4      Chris's fences: 4      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  51  61  59  
Enter your move: 


* INPUT :         61


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |    N    |   51    |   52    |   53    |   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |    C    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 4      Chris's fences: 4      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         2


OUTPUT
Enter the tile numbers and the direction of the wall you want to place: 


* INPUT :         20 21 D


OUTPUT
Fence placed!




  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |    N    |   51    |   52    |   53    |   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |    C    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 3      Chris's fences: 4      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  52  62  60  
Enter your move: 


* INPUT :         62


OUTPUT


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |    N    |   51    |   52    |   53    |   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |    C    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 3      Chris's fences: 4      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         2


OUTPUT
Enter the tile numbers and the direction of the wall you want to place: 


* INPUT :         70 71 D


OUTPUT
Fence placed!




  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |    N    |   51    |   52    |   53    |   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |    C    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 2      Chris's fences: 4      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  71  53  63  61  
Enter your move: 


* INPUT :         71


OUTPUT


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |    N    |   51    |   52    |   53    |   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |   69    |   70    |    C    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 2      Chris's fences: 4      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         2


OUTPUT
Enter the tile numbers and the direction of the wall you want to place: 


* INPUT :         44 56 R


OUTPUT
Invalid Placement! Select a Valid Fence Position! (Fence already placed or intersects with an existing fence.)


Enter the tile numbers and the direction of the wall you want to place: 


* INPUT :         44 53 R


OUTPUT
Fence placed!




  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    #   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |    N    |   51    |   52    |   53    #   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |   69    |   70    |    C    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 1      Chris's fences: 4      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  62  72  70  
Enter your move: 


* INPUT :         72


OUTPUT


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    #   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |    N    |   51    |   52    |   53    #   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |   69    |   70    |   71    |    C    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 1      Chris's fences: 4      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         2


OUTPUT
Enter the tile numbers and the direction of the wall you want to place: 


* INPUT :         25 26 U


OUTPUT
Fence placed!




  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    #   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |    N    |   51    |   52    |   53    #   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |   69    |   70    |   71    |    C    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 0      Chris's fences: 4      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         2


OUTPUT
Enter the tile numbers and the direction of the wall you want to place: 


* INPUT :         35 34 U


OUTPUT
Fence placed!




  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    #   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |    N    |   51    |   52    |   53    #   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |   69    |   70    |   71    |    C    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 0      Chris's fences: 3      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         2


OUTPUT
You have run out of fences! Select a move!




  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    #   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |    N    |   51    |   52    |   53    #   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |   69    |   70    |   71    |    C    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 0      Chris's fences: 3      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  59  51  49  
Enter your move: 


* INPUT :         51


OUTPUT


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    #   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |   50    |    N    |   52    |   53    #   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |   69    |   70    |   71    |    C    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 0      Chris's fences: 3      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  81  63  71  
Enter your move: 


* INPUT :         81


OUTPUT
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    #   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |   50    |    N    |   52    |   53    #   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |   78    |   79    |   80    |    C    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 0      Chris's fences: 3      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  60  52  50  
Enter your move: 


* INPUT :         60


OUTPUT
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    #   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |   50    |   51    |   52    |   53    #   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |    N    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |   78    |   79    |   80    |    C    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 0      Chris's fences: 3      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  72  80  
Enter your move: 


* INPUT :         80


OUTPUT


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    #   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |   50    |   51    |   52    |   53    #   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |    N    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |   78    |   79    |    C    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 0      Chris's fences: 3      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  51  61  59  
Enter your move: 
* INPUT :         61


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    #   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |   50    |   51    |   52    |   53    #   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |    N    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |   78    |   79    |    C    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 0      Chris's fences: 3      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1
These are your legal moves:  81  79  
Enter your move: 


* INPUT :         79


OUTPUT


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    #   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |   50    |   51    |   52    |   53    #   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |    N    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |   78    |    C    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 0      Chris's fences: 3      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  52  62  60  
Enter your move: 


* INPUT :         62


OUTPUT


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    #   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |   50    |   51    |   52    |   53    #   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |    N    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |   78    |    C    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 0      Chris's fences: 3      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  80  78  
Enter your move: 


* INPUT :         78


OUTPUT
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    #   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |   50    |   51    |   52    |   53    #   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |    N    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |    C    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 0      Chris's fences: 3      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  71  53  63  61  
Enter your move: 


* INPUT :         63


OUTPUT


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    #   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |   50    |   51    |   52    |   53    #   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |   62    |    N    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |    C    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 0      Chris's fences: 3      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  69  79  77  
Enter your move: 


* INPUT :         69


OUTPUT
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    #   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |   50    |   51    |   52    |   53    #   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |   62    |    N    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |    C    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 0      Chris's fences: 3      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  72  54  62  
Enter your move: 


* INPUT :         72


OUTPUT


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    #   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |   50    |   51    |   52    |   53    #   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |    C    |   70    |   71    |    N    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 0      Chris's fences: 3      |
 ------------------------------------------


Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OUTPUT
These are your legal moves:  78  70  68  
Enter your move: 


* INPUT :         78


OUTPUT


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    #   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |   50    |   51    |   52    |   53    #   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |   69    |   70    |   71    |    N    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |    C    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


 ------------------------------------------
|Nanda's fences: 0      Chris's fences: 3      |
 ------------------------------------------


Nanda, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3):  


* INPUT :         1


OOUTPUT
These are your legal moves:  81  63  71  
Enter your move: 


* INPUT :         81


OUTPUT


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   28    |   29    |   30    |   31    #   32    |   33    #   34    |   35    |   36    |  
  *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    #   39    |   40    #   41    |   42    #   43    |   44    #   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    * 
  |   46    |   47    #   48    #   49    |   50    |   51    |   52    |   53    #   54    |  
  *   ——    *   ##    *   ##    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    #   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ##    *   ##    *   ##    *   ##    *   ——    *   ——    * 
  |   64    #   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ##    *   ##    *   ——    * 
  |   73    #   74    |   75    |   76    |   77    |    C    |   79    |   80    |    N    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
Nanda has won the game with 18 moves !


Do you want to play another round? (Y/N):  


* INPUT :         Y


OUTPUT
----------------------------------------------------------
                       QUORIDOR                          
-----------------------------------------------------------


GOAL: Reach the opposite side of the board before your opponent! Each player moves their pawn across the 9x9 grid while strategically placing walls to block the other player’s path.


HOW TO PLAY:


1. The board is labeled with numbers from 1 to 81, representing each tile position.




  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    5    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    |   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    |   39    |   40    |   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    |   48    |   49    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    |   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |   77    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 


2. On your turn, you are given two options:
   +> Make Your Move : Move your pawn to a valid adjacent tile by entering its tile number.
     Example:
        These are your legal moves: 14  6  4 
        Enter your move: 14  moves your pawn to tile 46.


   +> Place a wall: You may place a wall between two adjacent tiles to block your opponent’s path.
     Walls can be placed horizontally or vertically, using the direction 'U' (up) or 'D' (down).
     Example:
        Enter move: 45 46 U  → places a horizontal wall above tiles 45 and 46.
        Enter move: 1 10 D   → places a vertical wall below tiles 1 and 10.


3. An option to quit will always be present during the players move.
4. You will not be allowed to completely block your opponents path towards the goal, just enough to mildly irritate them.


 MAY THE BEST PLAYER WIN!


--------------------------------------------------------------------------------


  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |    1    |    2    |    3    |    4    |    N    |    6    |    7    |    8    |    9    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   10    |   11    |   12    |   13    |   14    |   15    |   16    |   17    |   18    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   19    |   20    |   21    |   22    |   23    |   24    |   25    |   26    |   27    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   28    |   29    |   30    |   31    |   32    |   33    |   34    |   35    |   36    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   37    |   38    |   39    |   40    |   41    |   42    |   43    |   44    |   45    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   46    |   47    |   48    |   49    |   50    |   51    |   52    |   53    |   54    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   55    |   56    |   57    |   58    |   59    |   60    |   61    |   62    |   63    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   64    |   65    |   66    |   67    |   68    |   69    |   70    |   71    |   72    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
  |   73    |   74    |   75    |   76    |    C    |   78    |   79    |   80    |   81    |  
  *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    *   ——    * 
Chris, Make your move: 
-----------------------------------------------------
    1. Move your position in the board
    2. Place a wall
    3. Quit
Enter your choice (1-3): 


* INPUT :         3


OUTPUT
Do you want to play another round? (Y/N):  


* INPUT :         N


OUTPUT
Do you want to play another game? (Y/N):  


* INPUT :         Y


OUTPUT
Welcome! Choose a game from the menu below by entering the corresponding serial number: 
    1. Sliding Puzzle
    2. Dots And Boxes
    3. Quoridor
    4. Quit Game
Enter Your Choice (1-4):  


* INPUT :         4


OUTPUT
See you later!