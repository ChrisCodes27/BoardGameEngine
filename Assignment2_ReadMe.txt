# CS611 Assignment  2
## DOTS AND BOXES 
---------------------------------------------------------------------------


- Group: 
Name: Chris Mary Benson
Email: chris27@bu.edu
ID: U56085268
-
Name: Nandana Shashi
Email: nanda03@bu.edu
ID: U05556171


## Files
---------------------------------------------------------------------------


Game.java - Contains the main class where an instance of the GameStarter class is initialized.
GameStarter.java - Displays the menu of games to the player to choose from.


Board.java - Abstract class that serves as a base class for other boards of specific games.
DotsAndBoxesBoard.java - A Board class that consists of attributes specific to the Dots and Boxes game.
PuzzleBoard.java - A Board class that consists of attributes specific to the Sliding Puzzle.


Player.java - Abstract class that serves as a base class for other players of specific games.
DotsAndBoxesPlayer.java - A player class that consists of attributes specific to the dots and boxes game, such as move(), etc.
PuzzlePlayer.java - A player class that consists of attributes specific to the sliding puzzle game, such as move(), etc.


Tile.java - Represents the tile on the board. Each tile will have certain characteristics - its position on the board indicated by the row and column and also the value on the tile which is represented by an object of the Piece class.
BoxTile.java - A class that can be used for games such as dots and boxes, which focuses on the edges of a tile. It also has an object of the Piece class, which represents the value on the tile.
Edge.java - Represents each edge of a tile on the board. It extends Piece and has an attribute edgeColour.
Piece.java - Represents a piece on a tile on the board. It is of generic type.


Colour.java - A class which contains the ANSI codes for colours.
PrintErrorMessage.java - A class to print the error messages.


________________


## Notes
---------------------------------------------------------------------------


- Made colour an attribute of the Player class, so now each player can be assigned a colour that is used to mark the edges and boxes claimed by the player in the game.

(Note: In the output on terminal, each edge claimed by a player has its own colour.)


  



* Made use of the generic type across a few classes, such as the Games class, to allow initialization of multiple players in multiplayer games.
* Made use of interfaces such as BoardFunctions for common jobs, such as printing and initializing the board.




## How to compile and run
---------------------------------------------------------------------------


* unzip Assignment2.zip
* cd DotsAndBoxes
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
3. Quit Game


INPUT
2


OUTPUT
Hello! Welcome to the Dots and Boxes game!
Player 1, enter your username


INPUT
Nandana




OUTPUT
Player 2, enter your username


INPUT
Chris


OUTPUT
-----------------------------------------------
              DOTS AND BOXES
----------------------------------------------


GOAL: Complete more boxes than your opponent by drawing lines between dots. Each box completed with the 4th edge earns you one point!


HOW TO PLAY:
1. The board is labeled with letters for rows and columns (A, B, C, ...). For example, the coordinates of the first tile in the board is AA.


            A          B          C          D
       *           *           *            *            *
A        AA         AB         AC         AD
       *           *           *            *            *
B        BA         BB         BC         BD
       *           *           *            *            *
C       CA         CB         CC         CD
       *           *           *            *            *
D       DA         DB         DC         DD
       *           *           *            *            *




Each tile in the board has four different directions - UP (U), DOWN (D), LEFT (L) and RIGHT (R)
2. To mark an edge of each tile, type the coordinates of the box and the direction in which you want to draw the line.
   Example:
      Enter move: AA L  → draws a vertical line on the left of the tile AA.
      Enter move: AB U  → draws a horizontal line on the top of the tile AB.


3. Completing a box earns you a point and another turn!
4. If you want to quit the game at any point, please type 'QUIT'
When all boxes in the board are filled, the player with the most boxes wins.


------------------------------------------


Please enter the level of the dots and boxes you would like to solve (rows x column) [2x2, 2x3, 3x3, .....]


INPUT
2x3


OUTPUT
         A          B          C
      *          *          *          *
A 
      *          *          *          *
B
      *          *          *          *
NANDANA, make your move!
NANDANA's Move:     


INPUT
AA R




________________


OUTPUT
         A          B          C
     *          *          *          *
A              |
     *          *          *          *
B
     *          *          *          *


 ---------------------------------------------------------------------------------------
 |  Nandana's boxes: 0      Chris's boxes: 0       Total boxes :0          |
 ---------------------------------------------------------------------------------------
CHRIS, make your move!
CHRIS's Move:     


INPUT
AA L


OUTPUT
         A          B          C
     *          *          *          *
A   |          |
     *          *          *          *
B
     *          *          *          *


 ---------------------------------------------------------------------------------------
 |  Nandana's boxes: 0      Chris's boxes: 0       Total boxes :0          |
 ---------------------------------------------------------------------------------------
NANDANA, make your move!
NANDANA's Move:     


INPUT
BA D


OUTPUT
           A          B          C
      *            *          *          *
A    |            |
      *            *          *          *
B
      *   ——  *          *          *


 


---------------------------------------------------------------------------------------
 |  Nandana's boxes: 0      Chris's boxes: 0       Total boxes :0          |
 ---------------------------------------------------------------------------------------
CHRIS, make your move!
CHRIS's Move:     


INPUT
BB S


OUTPUT
Invalid Input! Input a valid edge!


           A          B          C
      *            *          *          *
A    |            |
      *            *          *          *
B
      *   ——  *          *          *


 ---------------------------------------------------------------------------------------
 |  Nandana's boxes: 0      Chris's boxes: 0       Total boxes :0          |
 ---------------------------------------------------------------------------------------
CHRIS, make your move!
CHRIS's Move:     


INPUT
BB U


OUTPUT
           A          B          C
      *            *          *          *
A    |            |
      *            *  —— *          *
B
      *   ——  *          *          *


 ---------------------------------------------------------------------------------------
 |  Nandana's boxes: 0      Chris's boxes: 0       Total boxes :0          |
 ---------------------------------------------------------------------------------------
NANDANA, make your move!
NANDANA's Move:     


INPUT
AF R
OUTPUT
Invalid Input! Input a valid position/edge (eg. AA U)!


           A          B          C
      *            *          *          *
A    |            |
      *            *  —— *          *
B
      *   ——  *          *          *
 
  ---------------------------------------------------------------------------------------
 |  Nandana's boxes: 0      Chris's boxes: 0       Total boxes :0          |
 ---------------------------------------------------------------------------------------
NANDANA, make your move!
NANDANA's Move:     


INPUT
BB U


OUTPUT
This edge has already been placed!


           A          B          C
      *           *          *          *
A    |           |
     *            *  —— *          *
B
     *   ——  *          *          *


 ---------------------------------------------------------------------------------------
 |  Nandana's boxes: 0      Chris's boxes: 0       Total boxes :0          |
 ---------------------------------------------------------------------------------------
NANDANA, make your move!
NANDANA's Move:     


INPUT
BA U






________________


OUTPUT


           A          B          C
      *            *           *          *
A    |            |
      *   ——  *  ——  *          *
B
      *   ——  *           *          *


  ---------------------------------------------------------------------------------------
 |  Nandana's boxes: 0      Chris's boxes: 0       Total boxes :0          |
 ---------------------------------------------------------------------------------------
CHRIS, make your move!
CHRIS's Move:     


INPUT
AA U


OUTPUT
Chris claimed 1 box(s)!


           A          B          C
      *   ——  *           *          *
A    |    C      |
      *   ——  *  ——  *          *
B
      *   ——  *           *          *


 ---------------------------------------------------------------------------------------
 |  Nandana's boxes: 0      Chris's boxes: 1       Total boxes :1          |
 ---------------------------------------------------------------------------------------
CHRIS, make your move!
CHRIS's Move:     


INPUT
AC U


OUTPUT
           A          B          C
      *   ——  *           *  —— *
A    |    C      |
      *   ——  *  ——  *          *
B
      *   ——  *           *          *


 ---------------------------------------------------------------------------------------
 |  Nandana's boxes: 0      Chris's boxes: 1       Total boxes :1          |
 ---------------------------------------------------------------------------------------
NANDANA, make your move!
NANDANA's Move:    


INPUT
BC R


OUTPUT
           A          B          C
      *   ——  *           *  —— *
A    |    C      |
      *   ——  *  ——  *          *
B                              |
      *   ——  *           *          *


 ---------------------------------------------------------------------------------------
 |  Nandana's boxes: 0      Chris's boxes: 1       Total boxes :1          |
 ---------------------------------------------------------------------------------------
CHRIS, make your move!
CHRIS's Move:    


INPUT
 BC L


OUTPUT


           A          B          C
      *   ——  *           *  —— *
A    |    C      |
      *   ——  *  ——  *          *
B                              |          |
      *   ——  *           *          *


 ---------------------------------------------------------------------------------------
 |  Nandana's boxes: 0      Chris's boxes: 1       Total boxes :1          |
 ---------------------------------------------------------------------------------------
NANDANA, make your move!
NANDANA's Move:     


INPUT
BA L
OUTPUT


            A          B          C
      *   ——  *           *  —— *
A    |    C      |
      *   ——  *  ——  *          *
B    |                         |          |
      *   ——  *           *          *


 ---------------------------------------------------------------------------------------
 |  Nandana's boxes: 0      Chris's boxes: 1       Total boxes :1          |
 ---------------------------------------------------------------------------------------
CHRIS, make your move!
CHRIS's Move:     


INPUT
BA R


OUTPUT
Chris claimed 1 box(s)!


            A          B          C
      *   ——  *           *  —— *
A    |    C      |
      *   ——  *  ——  *          *
B    |    C      |            |          |
      *   ——  *           *          *


 ---------------------------------------------------------------------------------------
 |  Nandana's boxes: 0      Chris's boxes: 2       Total boxes :2          |
 ---------------------------------------------------------------------------------------
CHRIS, make your move!
CHRIS's Move:     


INPUT
BB D


________________


OUTPUT
Chris claimed 1 box(s)!


            A          B          C
      *   ——  *           *  —— *
A    |    C      |
      *   ——  *  ——  *          *
B    |    C      |    C     |           |
      *   ——  *   —— *          *


 ---------------------------------------------------------------------------------------
 |  Nandana's boxes: 0      Chris's boxes: 3       Total boxes :3          |
 ---------------------------------------------------------------------------------------
CHRIS, make your move!
CHRIS's Move:     


INPUT
BC D


OUTPUT


           A          B          C
      *   ——  *           *  —— *
A    |    C      |
      *   ——  *  ——  *          *
B    |    C      |    C     |           |
      *   ——  *   —— *  —— *


 ---------------------------------------------------------------------------------------
 |  Nandana's boxes: 0      Chris's boxes: 3       Total boxes :3          |
 ---------------------------------------------------------------------------------------
NANDANA, make your move!
NANDANA's Move:     


INPUT
BC U


________________


OUTPUT
Nandana claimed 1 box(s)!


           A          B          C
      *   ——  *           *  ——  *
A    |    C      |
      *   ——  *  ——  *  ——  *
B    |    C      |    C     |     N    |
      *   ——  *   —— *  ——  *


 ---------------------------------------------------------------------------------------
 |  Nandana's boxes: 1      Chris's boxes: 3       Total boxes :4          |
 ---------------------------------------------------------------------------------------
NANDANA, make your move!
NANDANA's Move:     


INPUT
AC L


OUTPUT


           A          B          C
      *   ——  *           *  ——  *
A    |    C      |           |       
      *   ——  *  ——  *  ——  *
B    |    C      |    C     |     N    |
      *   ——  *   —— *  ——  *


 ---------------------------------------------------------------------------------------
 |  Nandana's boxes: 1      Chris's boxes: 3       Total boxes :4          |
 ---------------------------------------------------------------------------------------
CHRIS, make your move!
CHRIS's Move:     


INPUT
AC R


________________


OUTPUT
Chris claimed 1 box(s)!


           A          B          C
      *   ——  *           *  ——  *
A    |    C      |           |     C    |
      *   ——  *  ——  *  ——  *
B    |    C      |    C     |     N    |
      *   ——  *   —— *  ——  *


 ---------------------------------------------------------------------------------------
 |  Nandana's boxes: 1      Chris's boxes: 4       Total boxes :5          |
 ---------------------------------------------------------------------------------------
CHRIS, make your move!
CHRIS's Move:     


INPUT
AB U


OUTPUT
Chris claimed 1 box(s)!


           A          B          C
      *   ——  *  ——  *  ——  *
A    |    C      |    C    |     C    |
      *   ——  *  ——  *  ——  *
B    |    C      |    C     |     N    |
      *   ——  *   —— *  ——  *


 ---------------------------------------------------------------------------------------
 |  Nandana's boxes: 1      Chris's boxes: 5       Total boxes :6          |
 ---------------------------------------------------------------------------------------
Chris has won the game!


Do you want to play another round? (Y/N)


INPUT
Y


OUTPUT
Please enter the level of the dots and boxes you would like to solve (rows x column) [2x2, 2x3, 3x3, .....]


INPUT
2x2


OUTPUT


         A          B
   *          *          *
A
   *          *          *
B
   *          *          *
NANDANA, make your move!
NANDANA's Move:     


INPUT
quit


OUTPUT
Do you want to play another round? (Y/N)


INPUT
N


OUTPUT
Do you want to play another game? (Y/N)


INPUT
Y


OUTPUT
Welcome! Choose a game from the menu below by entering the corresponding serial number:
1. Sliding Puzzle
2. Dots And Boxes
3. Quit Game


INPUT
3


OUTPUT
See you later!


________________
 