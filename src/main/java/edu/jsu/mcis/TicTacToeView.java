package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeView extends JPanel implements ActionListener  {
	
	public static final int BUTTON_SIZE = 64;
	public static final int LABEL_SIZE = 30;
	
	private TicTacToeModel model;
	private JButton[][] squares;
	private JLabel resultLabel;
	
	public TicTacToeView(TicTacToeModel model){
            
		super();
            
		this.model = model;
		
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		
		int width = model.getWidth();
		JPanel squaresPanel = new JPanel(new GridLayout(width,width));
		
		squares = new JButton[width][width];
		
		Dimension d = new Dimension(BUTTON_SIZE,BUTTON_SIZE);
		
		for(int i = 0; i < width; ++i){
			for(int j = 0; j < width; ++j){
				squares[i][j] = new JButton();
				squares[i][j].addActionListener(this);
				squares[i][j].setName("Square" + i + j);
				//finish initializing JButton; add to JPanel
				squares[i][j].setPreferredSize(d);
				squaresPanel.add(squares[i][j]);
				
			}
		}
		this.add(squaresPanel);
		
		resultLabel = new JLabel();
		resultLabel.setName("ResultLabel");
		resultLabel.setText("Welcome to Tic-Tac-Toe");
		this.add(resultLabel);
	}
	
	public void actionPerformed(ActionEvent e){
            
            
		
		boolean madeMark = false;
		JButton square = null;
		TicTacToeModel.Mark mark = TicTacToeModel.Mark.EMPTY;
		
		if(!model.isGameover()){		
			for(int i = 0; i < model.getWidth(); ++i){
				for(int j = 0; j < model.getWidth(); ++j){
					if(squares[i][j] == (e.getSource())){
						madeMark = model.makeMark(i,j);
						
						if(madeMark){
							square = squares[i][j];
							mark = model.getMark(i,j);
						}
						
					}
				}
			}
			
			if(madeMark){
				this.squareChosen(square,mark);
				this.showNextMovePrompt();
			}
			else{
				this.showInputError();
			}
		}
		if(model.isGameover()){
			this.showResult();
		}
		
	}
        
        private void showResult(){
            String output = "";
			
			output = model.getResult().toString();
            
            /*if(model.getResult() == TicTacToeModel.Result.TIE){
                
                output = "Well, This is Awkward... It Was a Tie!";
                
            }
            
            else{
                output = "Congratulations to ";
                output += model.getResult();
                output += "! You've Won the Game!";
            }*/
            
            resultLabel.setText(output);
            
            
        }
	
	private void squareChosen(JButton square, TicTacToeModel.Mark mark){
		
		square.setLabel(mark.toString());
		
                
		/*for(int i = 0; i < model.getWidth(); ++i){
			for(int j = 0; j < model.getWidth(); ++j){
				if(squares[i][j] == square){
					square.setLabel(model.getMark(i, j).toString());
					//square.removeActionListener(this);
				}
			}
		}*/
		
		
			
	}
	
	private void showNextMovePrompt(){
		
		if(model.isXTurn()){
			resultLabel.setText("Player 1 (X) Turn");
		}
		else{
			resultLabel.setText("Player 2 (O) Turn");
		}
			
		
	}
	private void showInputError(){
            
            String output = "Square Chosen! ";
            
            if(model.isXTurn()){
                output += "Player 1 (X) Try Again";
            }
            else{
                output+= "Player 2 (O) Try Again";
            }
            
            resultLabel.setText(output);
	}

    
	
}