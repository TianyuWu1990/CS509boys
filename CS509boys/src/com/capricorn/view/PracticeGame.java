package com.capricorn.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.capricorn.controller.Clear;
import com.capricorn.controller.ClickLetter;
import com.capricorn.controller.Exit;
import com.capricorn.controller.Reset;
import com.capricorn.entity.Board;
import com.capricorn.model.Model;
public class PracticeGame extends JFrame {
	public List<String> list=new ArrayList<String>();
	public JTextField txtOwn;
	public JTextField textField;
	public Model m;
	public JButton btnArray[][] = new JButton[4][4];
    public PracticeGame(Model m) {
    	this.m=m;
		setTitle("PracticeGame");
		getContentPane().setLayout(null);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int x = 30 + i * 100;
				int y = 80 + j * 40;
				btnArray[i][j] = new JButton(m.board.letterArray[i][j].letter);
				btnArray[i][j].setBounds(x, y, 89, 23);
				ClickLetter clickControl = new ClickLetter(this);
				btnArray[i][j].addActionListener(clickControl);
				getContentPane().add(btnArray[i][j]);
			}
		}
		JLabel lblLettersYouPick = new JLabel("Your Word :");
		lblLettersYouPick.setBounds(35, 22, 89, 20);
		getContentPane().add(lblLettersYouPick);

		txtOwn = new JTextField();
		txtOwn.setColumns(10);
		txtOwn.setBounds(130, 22, 180, 20);
		txtOwn.setEditable(false);
		getContentPane().add(txtOwn);

		JButton btnNewButton_4 = new JButton("Submit");
		btnNewButton_4.setBounds(322, 13, 134, 40);
		getContentPane().add(btnNewButton_4);


		JLabel lblScore = new JLabel("Score :");
		lblScore.setBounds(64, 54, 61, 16);
		getContentPane().add(lblScore);

		textField = new JTextField();
		textField.setBounds(130, 48, 134, 28);
		getContentPane().add(textField);
		textField.setEditable(false);
		textField.setColumns(10);

		JButton btnResetBoard = new JButton("Reset Board");
		Reset resetControl = new Reset(this,m);
		btnResetBoard.addActionListener(resetControl);
		btnResetBoard.setBounds(462, 89, 111, 23);
		getContentPane().add(btnResetBoard);

		//Clear text when click clear button
		JButton btnUndo = new JButton("Clear");
		Clear clearControl = new Clear(this);
		btnUndo.addActionListener(clearControl);
		btnUndo.setBounds(333, 49, 117, 29);
		getContentPane().add(btnUndo);
		
		JButton btnNewButton_2 = new JButton("Exit Practice");
		Exit exitControl = new Exit(this);
		btnNewButton_2.addActionListener(exitControl);
		btnNewButton_2.setBounds(462, 14, 111, 38);
		getContentPane().add(btnNewButton_2);
	}

}
