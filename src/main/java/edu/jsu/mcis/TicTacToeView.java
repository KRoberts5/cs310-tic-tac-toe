package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeView extends JPanel implements ActionListener  {

	private TicTacToeModel model;
	private JButton[][] squares;
	private JLabel resultLabel;
	
	public TicTacToeView(TicTacToeModel model){
		this.model = model;
		
		int width = model.getWidth();
		
		JPanel squaresPanel = new JPanel(new GridLayout(width,width));
		
		squares = new JButton[width][width];
		
		Dimension d = new Dimension(64,64);
		
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
		
		for(int i = 0; i < model.getWidth(); ++i){
			for(int j = 0; j < model.getWidth(); ++j){
				if(squares[i][j].equal(e.getSource())){
					madeMark = model.makeMark(i,j);
				}
			}
		}
		
		if(madeMark){
			this.squareChosen(e.getSource());
			this.showNextMovePrompt();
		}
		else{
			this.showInputError();
		}
		
	}
	
	private void squareChosen(JButton square){
		if(model.isXTurn()){
			square.setLabel("X"); 					//use Mark enum?
			square.removeActionListener(this);
		}
		else{
			square.setLabel("O");
			square.removeActionListener(this);
		}
		
		
			
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
		
	}

    
	
}