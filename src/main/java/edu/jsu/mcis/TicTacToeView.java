package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        
        /* INSERT YOUR CODE HERE */
		int width = model.getWidth();
		
		System.out.print("  ");
		
		for(int i = 0; i < width; ++i){
			System.out.print(i);
		}
		System.out.println("\n");
		
		
		for(int i = 0; i < width; ++i){
			
			System.out.print( i + " ");
			
			for(int j = 0; j < width; ++j){
				System.out.print(model.getMark(i,j));
			}
			System.out.println();
		}
		
		
		

    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */

        /* INSERT YOUR CODE HERE */
		
		if(model.isXTurn()){
			System.out.println("Player 1 (X) Move:");
		}
		else{
			System.out.println("Player 2 (O) Move:");
		}
		
		System.out.print("Enter the row and column numbers, separated by a space: ");

    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        /* INSERT YOUR CODE HERE */
		
		System.out.println("\nINVALID INPUT!!! Please Try Again:\n");

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}