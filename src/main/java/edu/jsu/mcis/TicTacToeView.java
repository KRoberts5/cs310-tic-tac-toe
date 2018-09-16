package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeView extends JPanel implements ActionListener  {

	Model model;
	JButton[][] squares;
	JLabel resultLabel;
	
	public TicTacToeGUI(Model model){
		this.model = model;
		
		int width = model.getWidth();
		
		JPanel squaresPanel = new JPanel(new GridLayout(width,width);
		
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
	}

    
	
}