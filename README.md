# cs310-tic-tac-toe

## Overview

This program is an implementation of the game tic-tac-toe. There are two branches: Master and Part 2.
The only difference between branches is master utilizes the command prompt for I/O and Part 2 utilizes a GUI. 
In this readme, I will discuss the Part 2 version of the program. Both versions of the program utilize the MVC design pattern.

## TicTacToe

This is the launcher class that contains the main method. The main method initializes values for the rows and columns and creates the MVC objects required for program execution. In this version of the program, only the Model and View classes are instantiated. Since input and output is relatively simple, the controller was not required to connect the model and the view. 

When launched, the program may be launched with command line arguments. If an integer value is given as a command line argument, then the board will be created with the specified number of rows and columns. Otherwise, the board is initialized with 3 rows and columns. 

## TicTacToeModel

This class maintains the game logic and state of the program. The game logic is controlled by three fields of the class: grid, xTurn, and width. grid is a two dimensional array of mark enumerations (mark enumerations will be explained later). xTurn is a boolean value that, when true, represents that the current turn belongs to player X. Otherwise, the turn belongs to player O. Width simply represents the number of rows and columns. Along with these instance fields, TicTacToeModel defines two enumerations: 

1. Mark - an enumeration that represents the mark of a given box. It can represent three values: X, O, and empty.
2. Result - an enumeration that represents the final result of the game. It can represent four values: X, O, Tie, and None (game is not over). 

As previously stated, the grid is just a two dimensional array of mark enumerations. To check for a winning condition, the program checks if every mark in a row, column, or diagonal has the same value. 

### Constructor

This class contains two constructors. When an integer value is given at the command line, the non-default constructor is called with the integer argument. The default constructor calls the non-default constructor with a value of three. The constructor initializes all fields and sets all the marks in "grid" to be empty.

### makeMark()

This method is called whenever a user requests to mark a grid location. The method accepts two integer values that represent the row and column values of the grid box. If the requested grid box is both valid and unmarked, the mark is set to represent the symbol of the current player. If the grid box is either invalid or marked, the user will be told to make another selection and the current player will not change. In the case that a mark was made, a boolean variable set to true is returned. Otherwise, false is returned.

### isValidSquare()

This method is called whenever a method of the model needs to verify that a requested grid space is within the bounds of the game board. It checks to make sure that row and column values retrieved from input are greater than or equal to zero and less than the width of the current gameboard. If valid, a boolean variable set to true is returned. Otherwise, false is returned.

### isSquareMarked()

This method is callled whenever a method of the model needs to check if a grid space is marked. If the grid box represents a player value, the square has been marked and a boolean variable set to true will be returned. Otherwise, false is returned.

### getMark()

Accepts a row and column value and obtains the mark enumeration at that location. Once obtained, the mark is returned.

### getResult()

This method is called after every successful mark to check if an end-game state has been reached. It Calls methods that check for every possible game state (isMarkWin() and isTie()). If any of the method calls return true, the appropriate result enumeration is returned. Otherwise, the result enumeration returned is equal to none.

### isMarkWin()

This method is called by getResult(). It accepts the mark of a player and checks the gameboard to see if that player has won. To determine a winning a condition, all the following must be checked:

1. Every row
2. Every column
3. The diagonal squares

To accomplish this, I create four fields ( rowCount, colCount, frontDiagCount, backDiagCount ) and utilize a nested for loop to check all of the winning conditions simultaneaously. While iterating through the squares in a given row, column, or diagonal, I simply increment the appropriate count every time the specified players mark is encountered. If one of the count fields is ever set equal to the width of the game board, then a winning condition has been met. 

### isTie()

This method is called by getResult() and checks all the mark values of squares in the grid. If a square contains a mark that is not empty, a variable named markCount is incremented. Once we have iterated through all the squares, we compare markCount to the total number of squares in the grid. If these values are equivalent and no one has won the game, then a tie has occured. 

### isGameover()

A method that returns a boolean value that represents if the game is over. To accomplish this, the value of result is compared to a result enumeration set to the "none" state. If result is equivalent to none, false is returned. True is returned for all the other result states.

### isXTurn()

An accessor method for xTurn.

### getWidth()

An accessor method for the width instance field.

## TicTacToeView

This class creates, maintains, and monitors all the GUI elements in the program. It is instantiated by the TicTacToe class. The GUI in this version of the program is constructed by creating an array of JButtons. There is an additional JLabel that represents output about game-state data (who won, was the game a tie, etc.). 

### Constructor

Accepts a model object (that is stored for future communication). The constructor for this class provides code that instantiates and sets up all the required GUI elements. To create the Tic-Tac-Toe grid, a two dimensional array is created. Both the row and columns are set equal to the width of the gameboard. I utilize a nested for loop to generate all the required buttons and add them to a panel. Once all buttons have been added to the button panel, the button panel is added to the overall JPanel. 



## TicTacToeController

This code is not used in the part 2 version of the program. I will briefly summarize what it contributed in the previous, master, version of the program.

### Constructor

The constructor for this class accepts a model and view object. Once these objects have been stored, the constructor instantiates a Scanner object so that input can be retrieved from the command line. 

### controlModel()

This method, in the master version of the program, is called in a loop while the game is not over. The method is responsible for calling the methods of the view that prompt the user input. Once a user submits input, this method retrieves the values submitted and calls the makeMark() method of the model. If a valid, unmarked position has been chosen, a mark is made and the game continues as normal. If invalid input was given, the controller notifies the user.


