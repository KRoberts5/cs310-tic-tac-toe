package edu.jsu.mcis;

public class TicTacToeModel {
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */
		
		this.grid = new Mark[width][width];

        /* INSERT YOUR CODE HERE */

        /* Initialize grid by filling every square with empty marks */
		
		for(int i = 0; i < width; ++i){
			for(int j = 0; j < width; ++j){
				this.grid[i][j] = Mark.EMPTY;
			}
		}

        /* INSERT YOUR CODE HERE */
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
        
        /* INSERT YOUR CODE HERE */
		
		boolean madeMark = false;
		
		
		
		if(this.isValidSquare(row, col)){
			
			if(!this.isSquareMarked(row,col)){
				
				madeMark = true;
				
				if(xTurn){
					this.grid[row][col] = Mark.X;
				}
				else{
					this.grid[row][col] = Mark.O;
				}
			}
		}
		

        return madeMark; 
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        
        /* INSERT YOUR CODE HERE */
		
		boolean valid = (row < this.width) && (col < this.width);
		
		

        return valid; /* remove this line! */
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        
        /* INSERT YOUR CODE HERE */
		
		boolean marked = false;
		
		
		if(this.isValidSquare(row,col)){
			marked = (this.grid[row][col] != Mark.EMPTY);
		}
        return marked; /* remove this line! */
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        
        /* use isValidSquare?*/
		
		Mark mark = null;
		
		if(this.isValidSquare(row,col)){
			if(isSquareMarked(row,col)){
				mark = this.grid[row][col];
			}
		}

        return mark; /* remove this line! */
            
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        /* INSERT YOUR CODE HERE */

        return null; /* remove this line! */

    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        /* INSERT YOUR CODE HERE */
		
		boolean won = false;
		int markCount = 0;
		
		for(int i = 0; i < width; ++i){		//checks if theres a winning row
			for(int j = 0; j < width; ++j){
				if(this.grid[i][j] == mark)
					++markCount;
			}
			if(markCount == this.width){
				won = true;
				break;
			}
			markCount = 0;
		}

        return won; /* remove this line! */

    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        /* INSERT YOUR CODE HERE */

        return false; /* remove this line! */
        
    }

    public boolean isGameover() {
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
}