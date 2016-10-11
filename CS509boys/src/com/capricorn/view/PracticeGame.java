package com.capricorn.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.capricorn.controller.CellController;
import com.capricorn.entity.Board;

public class PracticeGame extends JFrame implements ActionListener {
	List<String> list=new ArrayList<String>();
	private JTextField word_text;
	private JTextField score_text;
	Board board = new Board();
	

	JButton btnArray[][] = new JButton[4][4];

	public PracticeGame() {
		
		
		//put to controller to handle;
		CellController cellCon = new CellController(this);
		
		setTitle("PracticeGame");
		getContentPane().setLayout(null);
		board.setcellArray();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int x = 30 + i * 100;
				int y = 80 + j * 40;
				btnArray[i][j] = new JButton(board.letterArray[i][j].letter);
				btnArray[i][j].setBounds(x, y, 89, 23);
				btnArray[i][j].addActionListener(this);
				
				getContentPane().add(btnArray[i][j]);
			}
		}
		
		
		
		JButton btnNewButton_2 = new JButton("Exit Practice");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				StartPage page = new StartPage();
				page.setSize(600, 300); // set StartPage size
				page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				page.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(462, 14, 111, 38);
		getContentPane().add(btnNewButton_2);
		

		
		JLabel lblLettersYouPick = new JLabel("Your Word :");
		lblLettersYouPick.setBounds(35, 22, 89, 20);
		getContentPane().add(lblLettersYouPick);

		word_text = new JTextField();
		word_text.setColumns(10);
		word_text.setBounds(130, 22, 180, 20);
		word_text.setEditable(false);
		getContentPane().add(word_text);

		JButton btnNewButton_4 = new JButton("Submit");
		btnNewButton_4.setBounds(322, 13, 134, 40);
		getContentPane().add(btnNewButton_4);

		
		JLabel lblScore = new JLabel("Score :");
		lblScore.setBounds(64, 54, 61, 16);
		getContentPane().add(lblScore);

		score_text = new JTextField();
		score_text.setBounds(130, 48, 134, 28);
		score_text.setEditable(false);
		getContentPane().add(score_text);
		score_text.setColumns(10);

		JButton btnResetBoard = new JButton("Reset Board");
		btnResetBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (word_text.getText().length() != 0) {
					word_text.setText(null);
				}
				board.setcellArray();
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {						
					btnArray[i][j].setText(board.letterArray[i][j].letter); 												
					}					
				}
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						btnArray[i][j].setEnabled(true);;
					}
			}
				list=new ArrayList<String>();	
			}
		});
		btnResetBoard.setBounds(462, 89, 111, 23);
		getContentPane().add(btnResetBoard);

		//Clear text when click clear button
		JButton btnUndo = new JButton("Clear");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (word_text.getText().length() != 0) {
					word_text.setText(null);
				}
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						btnArray[i][j].setEnabled(true);;
					}
			}
				 list=new ArrayList<String>();	
			}
		});
		btnUndo.setBounds(333, 49, 117, 29);
		getContentPane().add(btnUndo);
		
		//initialized practice page
		setSize(600, 300); // set practicegame size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	
	
	
	public void actionPerformed(ActionEvent a) {
		
		JButton button = (JButton) a.getSource();
		int x=button.getBounds().x;
		int y=button.getBounds().y;
		int indx=(x-30)/100;
		int indy=(y-80)/40;
		
		String coor=indx+""+indy+"";
		list.add(coor);
        
		for (int i = 0; i < 4; i++) {
			
			for (int j = 0; j < 4; j++) {
				if (((indx-1==i&&indy-1==j)||(indx-1==i&&indy==j)||(indx-1==i&&indy+1==j)||(indx==i&&indy-1==j)||
						(indx==i&&indy+1==j)||(indx+1==i&&indy-1==j)||(indx+1==i&&indy==j)||(indx+1==i&&indy+1==j))&&(!list.contains(i+""+j+""))){
				btnArray[i][j].setEnabled(true);}
				else{
					btnArray[i][j].setEnabled(false);
				}
				
			}
	}
		
		String val = word_text.getText();
		word_text.setText(val + button.getText());
		button.setEnabled(false);
		

	}
}
