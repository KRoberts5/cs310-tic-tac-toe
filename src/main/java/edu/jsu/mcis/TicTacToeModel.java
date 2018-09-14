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
		
		this.grid = new Mark[this.width][this.width];

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
					xTurn = false;
				}
				else{
					this.grid[row][col] = Mark.O;
					xTurn = true;
				}
			}
		}
		

        return madeMark; 
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        
        /* INSERT YOUR CODE HERE */
		
		boolean rowValid = (row < this.width) && (row >= 0);
		boolean colValid = (col < this.width) && (col >= 0);
		
		boolean valid = rowValid && colValid;
		
		

        return valid; /* remove this line! */
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        
        /* INSERT YOUR CODE HERE */
		
		boolean marked = false;
		
		
		if(this.isValidSquare(row,col)){
			if((grid[row][col] == Mark.X) || (grid[row][col] == Mark.O))
				marked = true;
		}
        return marked; /* remove this line! */
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        
		
		Mark mark = grid[row][col]; 

        return mark; /* remove this line! */
            
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        /* INSERT YOUR CODE HERE */
		
		Result result = null;
		
		boolean xWon = isMarkWin(Mark.X);
		boolean oWon = isMarkWin(Mark.O);
		boolean tie = isTie();
		
		if(tie)
			result = Result.TIE;
		else if(xWon)
			result = Result.X;
		else if(oWon)
			result = Result.O;
		else
			result = Result.NONE;

        return result; /* remove this line! */

    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        /* INSERT YOUR CODE HERE */
		
		boolean won = false;
		int rowCount = 0;
		int colCount = 0;
		int frontDiagCount = 0;
		int backDiagCount = 0;
		
		for(int i = 0; i < width; ++i){		
			for(int j = 0; j < width; ++j){
				if(this.grid[i][j] == mark)
					++rowCount;
				if(this.grid[j][i] == mark )
					++colCount;
					
			}
			if(this.grid[i][i] == mark)
				++frontDiagCount;
			
			if(this.grid[i][this.width - 1 - i] == mark)
				++backDiagCount;
				
			
			
			if(rowCount == this.width){
				won = true;
				break;
			}
			if(colCount == this.width){
				won = true;
				break;
			}
			if(frontDiagCount == this.width){
				won = true;
			}
			if(backDiagCount == this.width){
				won = true;
			}
			
			
			rowCount = 0;
			colCount = 0;
		}

        return won; /* remove this line! */

    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        /* INSERT YOUR CODE HERE */
		
		int markCount = 0;
		int spaceTotal = this.width*this.width;
		
		boolean tied = false;
		boolean full = false;
		boolean xWon = this.isMarkWin(Mark.X);
		boolean oWon = this.isMarkWin(Mark.O);
		
		for(int i = 0; i < this.width; ++i){
			for(int j = 0; j < this.width; ++j){
				
				if(grid[i][j] != Mark.EMPTY)
					++markCount;
				
			}
		}
		
		if(markCount == spaceTotal)
			full = true;
		
		if((!xWon) && (!oWon) && (full))
			tied = true;
	

        return tied; /* remove this line! */
        
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