package com.capricorn.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.capricorn.entity.Board;
import com.capricorn.entity.Model;
import com.capricorn.listener.ClearButton_practiceGame;
import com.capricorn.listener.ClickButton_practiceGame;
import com.capricorn.listener.Exit_practiceGame;
import com.capricorn.listener.Reset_practiceGame;
/**
 * View part is designed by JFrame. PracticeGame is an interface
 * connect to the player who want to play a single game without request and response. 
 * Which means practice game can be run under the condition without connecting to server.
 *<p>
 * JFrame owns the advantage that different parts are individually and will not affect each other.
 * @author Chen Li, Tianyu Wu, Yu Li
 */
public class PracticeGame extends JFrame {
	public List<String> list=new ArrayList<String>();
	public JTextField txtOwn;
	public JTextField textField;
	public Model m; 
	public int sum; 
	public JButton btnArray[][] = new JButton[4][4];
	public JButton btn_submit;
	public JButton btnResetBoard;
	public JButton btnUndo;
	public JButton btn_exit;
	/** Here is a constructor for PracticeGame in order to make a fault value.
	 *  Construct PracticeGame object to use default port number.
	 */
    public PracticeGame(Model m) {
    	this.m=m;
		setTitle("PracticeGame");
		/** Define the size of the game zone.*/
		getContentPane().setLayout(null);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int x = 30 + i * 100;
				int y = 80 + j * 40;
				btnArray[i][j] = new JButton(m.getBoard().getCells()[i][j].getLetter());
				btnArray[i][j].setToolTipText(m.getBoard().getCells()[i][j].getPoints());
				btnArray[i][j].setBounds(x, y, 89, 23);
				ClickButton_practiceGame clickControl = new ClickButton_practiceGame(this);
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

		btn_submit = new JButton("Submit");
		btn_submit.setBounds(322, 13, 134, 40);
		getContentPane().add(btn_submit);


		JLabel lblScore = new JLabel("Score :");
		lblScore.setBounds(64, 54, 61, 16);
		getContentPane().add(lblScore);

		textField = new JTextField();
		textField.setBounds(130, 48, 134, 28);
		getContentPane().add(textField);
		textField.setText("0");
		textField.setEditable(false);
		textField.setColumns(10);

		btnResetBoard = new JButton("Reset Board");
		Reset_practiceGame resetControl = new Reset_practiceGame(this,m);
		btnResetBoard.addActionListener(resetControl);
		btnResetBoard.setBounds(462, 89, 111, 23);
		getContentPane().add(btnResetBoard);


		btnUndo = new JButton("Clear");
		ClearButton_practiceGame clearControl = new ClearButton_practiceGame(this);  
		btnUndo.addActionListener(clearControl);
		btnUndo.setBounds(333, 49, 117, 29);
		getContentPane().add(btnUndo);
		
		btn_exit = new JButton("Exit Practice");
		Exit_practiceGame exitControl = new Exit_practiceGame(this,m);
		btn_exit.addActionListener(exitControl);
		btn_exit.setBounds(462, 14, 111, 38);
		getContentPane().add(btn_exit);
	}

}
