package Ui;

import Entity.*;

import java.awt.BorderLayout;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;

public class PracticeGame extends JFrame implements ActionListener {
	private JTextField txtOwn;
	private JTextField textField;
	Board board = new Board();

	JButton btnArray[][] = new JButton[4][4];

	public PracticeGame() {
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
		board.setcellArray();

		// JButton btn11 = new JButton(board.letterArray[0][0].letter);
		// btn11.addActionListener(new ActionListener() {
		//
		// public void actionPerformed(ActionEvent e) {
		//
		// }
		// });
		// btn11.setBounds(31, 89, 89, 23);
		// getContentPane().add(btn11);
		//
		// JButton btn12 = new JButton("s");
		// btn12.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// }
		// });
		// btn12.setBounds(130, 89, 89, 23);
		// getContentPane().add(btn12);
		//
		// JButton btn13 = new JButton("k");
		// btn13.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// }
		// });
		// btn13.setBounds(233, 89, 89, 23);
		// getContentPane().add(btn13);
		//
		// JButton btn14 = new JButton("o");
		// btn14.setBounds(332, 89, 89, 23);
		// getContentPane().add(btn14);
		//
		// JButton btn15 = new JButton("l");
		// btn15.setBounds(31, 123, 89, 23);
		// getContentPane().add(btn15);
		//
		// JButton btn16 = new JButton("l");
		// btn16.setBounds(130, 123, 89, 23);
		// getContentPane().add(btn16);
		//
		// JButton btn17 = new JButton("o");
		// btn17.setBounds(233, 123, 89, 23);
		// getContentPane().add(btn17);
		//
		// JButton btn18 = new JButton("w");
		// btn18.setBounds(332, 123, 89, 23);
		// getContentPane().add(btn18);
		//
		// JButton btn19 = new JButton("l");
		// btn19.setBounds(31, 157, 89, 23);
		// getContentPane().add(btn19);
		//
		// JButton btn110 = new JButton("o");
		// btn110.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// }
		// });
		// btn110.setBounds(130, 157, 89, 23);
		// getContentPane().add(btn110);
		//
		// JButton btn111 = new JButton("a");
		// btn111.setBounds(233, 157, 89, 23);
		// getContentPane().add(btn111);
		//
		// JButton btn112 = new JButton("n");
		// btn112.setBounds(332, 157, 89, 23);
		// getContentPane().add(btn112);
		//
		// JButton btn113 = new JButton("y");
		// btn113.setBounds(31, 191, 89, 23);
		// getContentPane().add(btn113);
		//
		// JButton btn114 = new JButton("e");
		// btn114.setBounds(130, 191, 89, 23);
		// getContentPane().add(btn114);
		//
		// JButton btn115 = new JButton("s");
		// btn115.setBounds(233, 191, 89, 23);
		// getContentPane().add(btn115);
		//
		// JButton btn116 = new JButton("o");
		// btn116.setBounds(332, 191, 89, 23);
		// getContentPane().add(btn116);

		JLabel lblLettersYouPick = new JLabel("Your Word :");
		lblLettersYouPick.setBounds(35, 22, 89, 20);
		getContentPane().add(lblLettersYouPick);

		txtOwn = new JTextField();
		txtOwn.setColumns(10);
		txtOwn.setBounds(130, 22, 180, 20);
		getContentPane().add(txtOwn);

		JButton btnNewButton_4 = new JButton("Submit");
		btnNewButton_4.setBounds(322, 13, 134, 40);
		getContentPane().add(btnNewButton_4);

		// JButton btnUp = new JButton("UP");
		// btnUp.setToolTipText("");
		// btnUp.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// }
		// });
		// btnUp.setBounds(496, 142, 53, 38);
		// getContentPane().add(btnUp);
		//
		// JButton btnLeft = new JButton("LEFT");
		// btnLeft.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// }
		// });
		// btnLeft.setBounds(444, 160, 53, 38);
		// getContentPane().add(btnLeft);
		//
		// JButton btnDown = new JButton("DOWN");
		// btnDown.setBounds(496, 176, 53, 38);
		// getContentPane().add(btnDown);
		//
		// JButton btnRight = new JButton("RIGHT");
		// btnRight.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// }
		// });
		// btnRight.setBounds(548, 160, 53, 38);
		// getContentPane().add(btnRight);

		JLabel lblScore = new JLabel("Score :");
		lblScore.setBounds(64, 54, 61, 16);
		getContentPane().add(lblScore);

		textField = new JTextField();
		textField.setBounds(130, 48, 134, 28);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnResetBoard = new JButton("Reset Board");
		btnResetBoard.setBounds(462, 89, 111, 23);
		getContentPane().add(btnResetBoard);

		JButton btnUndo = new JButton("Undo");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtOwn.getText().length() != 0) {
					txtOwn.setText(txtOwn.getText().substring(0, txtOwn.getText().length() - 1));
				}
			}
		});
		btnUndo.setBounds(333, 49, 117, 29);
		getContentPane().add(btnUndo);
	}

	public void actionPerformed(ActionEvent a) {
		JButton button = (JButton) a.getSource();
		String val = txtOwn.getText();

		txtOwn.setText(val + button.getText());

	}
}
