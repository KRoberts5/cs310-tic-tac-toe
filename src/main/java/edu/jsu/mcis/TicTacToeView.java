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
		
		
		System.out.println("  012");
		
		for(int i = 0; i < width; ++i){
			
			System.out.print("\n" + i + " ");
			
			for(int j = 0; j < width; ++i){
				System.out.print(model.getMark(i,j));
			}
		}
		

    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */

        /* INSERT YOUR CODE HERE */

    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        /* INSERT YOUR CODE HERE */

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}