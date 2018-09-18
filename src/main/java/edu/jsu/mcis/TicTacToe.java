package edu.jsu.mcis;

import java.awt.*;
import javax.swing.*;

public class TicTacToe {

    private static final int DEFAULT_WIDTH = 3;

    public static void main(String[] args) {
        
        /* Set initial size of game board (default is 3x3) */

        int width = DEFAULT_WIDTH;
		
		int windowWidth = 0;
		int windowHeight = 0;
        
        /* If a different size is provided as a command-line argument, use it instead */

        if (args.length >= 1) {
            
            try {
                width = Integer.parseInt(args[0]);
            }
            catch(NumberFormatException e) {}
            
        }
        
        /* Create MVC Objects */
		
		

        TicTacToeModel model = new TicTacToeModel(width);
		TicTacToeView view = new TicTacToeView(model);
		
		windowWidth = view.BUTTON_SIZE*width;
		windowHeight = (view.BUTTON_SIZE*width) + view.LABEL_SIZE;
		
		JFrame window = new JFrame("Tic-Tac-Toe");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(windowWidth,windowHeight);
		window.add(view);
		window.pack();
		window.setVisible(true);
		
		/*EventQueue.invokeLater(() ->{
			JFrame window = new JFrame("Tic-Tac-Toe");
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        window.setSize(300, 300);
			window.getContentPane().add(new TicTacToeView(model));
			window.setVisible(true);
		});*/
		
		
		
        //TicTacToeView view = new TicTacToeView(model);
        //TicTacToeController controller = new TicTacToeController(model, view);
        
        /* MAIN LOOP */

       /* while (!model.isGameover()) {
            
            view.viewModel();
            controller.controlModel();
            
        }*/
        
        /* Game is over; show the final board and the winner */

        //view.viewModel();

        //view.showResult(model.getResult().toString());

    }

}