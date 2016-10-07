package com.capricorn.view;

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
import javax.swing.Box;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.UIManager;

public class GuestGame extends JFrame {
	private JTextField textField;
	private JTextField textField_1;

	public GuestGame() {
		setTitle("Your Game");
		getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(132, 21, 192, 22);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Your Word :");
		lblNewLabel.setBounds(35, 22, 85, 20);
		getContentPane().add(lblNewLabel);

		JButton btnK = new JButton("k");
		btnK.setBounds(136, 89, 89, 23);
		getContentPane().add(btnK);

		JButton btnO = new JButton("o");
		btnO.setBounds(235, 89, 89, 23);
		getContentPane().add(btnO);

		JButton btnL_2 = new JButton("l");
		btnL_2.setBounds(37, 123, 89, 23);
		getContentPane().add(btnL_2);

		JButton btnO_3 = new JButton("o");
		btnO_3.setBounds(136, 123, 89, 23);
		getContentPane().add(btnO_3);

		JButton btnW = new JButton("w");
		btnW.setBounds(235, 123, 89, 23);
		getContentPane().add(btnW);

		JButton btnO_2 = new JButton("o");
		btnO_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnO_2.setBounds(37, 157, 89, 23);
		getContentPane().add(btnO_2);

		JButton btnA = new JButton("a");
		btnA.setBounds(136, 157, 89, 23);
		getContentPane().add(btnA);

		JButton btnN = new JButton("n");
		btnN.setBounds(235, 157, 89, 23);
		getContentPane().add(btnN);

		JButton btnE = new JButton("e");
		btnE.setBounds(37, 191, 89, 23);
		getContentPane().add(btnE);

		JButton btnS_1 = new JButton("s");
		btnS_1.setBounds(136, 191, 89, 23);
		getContentPane().add(btnS_1);

		JButton btnO_1 = new JButton("o");
		btnO_1.setBounds(235, 191, 89, 23);
		getContentPane().add(btnO_1);

		JButton btnA_2 = new JButton("a");
		btnA_2.setBounds(334, 157, 89, 23);
		getContentPane().add(btnA_2);

		JButton btnD = new JButton("d");
		btnD.setBounds(334, 191, 89, 23);
		getContentPane().add(btnD);

		JButton btnS_2 = new JButton("s");
		btnS_2.setBounds(334, 123, 89, 23);
		getContentPane().add(btnS_2);

		JButton btnA_1 = new JButton("a");
		btnA_1.setBounds(334, 89, 89, 23);
		getContentPane().add(btnA_1);

		JLabel label = new JLabel("Score :");
		label.setBounds(66, 54, 61, 16);
		getContentPane().add(label);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(130, 48, 134, 28);
		getContentPane().add(textField_1);

		JButton button = new JButton("UP");
		button.setToolTipText("");
		button.setBounds(496, 142, 53, 38);
		getContentPane().add(button);

		JButton button_1 = new JButton("LEFT");
		button_1.setBounds(444, 157, 53, 38);
		getContentPane().add(button_1);

		JButton button_2 = new JButton("RIGHT");
		button_2.setBounds(548, 157, 53, 38);
		getContentPane().add(button_2);

		JButton button_3 = new JButton("DOWN");
		button_3.setBounds(496, 176, 53, 38);
		getContentPane().add(button_3);

		JButton button_4 = new JButton("Submit");
		button_4.setBounds(336, 13, 147, 40);
		getContentPane().add(button_4);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				StartPage page = new StartPage();
				page.setSize(600, 300); // set StartPage size
				page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				page.setVisible(true);
			}
		});
		btnExit.setBounds(511, 14, 69, 38);
		getContentPane().add(btnExit);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(211, 237, 390, 199);
		getContentPane().add(textPane);

		JLabel lblScoreRanking = new JLabel("Score Ranking :");
		lblScoreRanking.setBounds(98, 237, 101, 16);
		getContentPane().add(lblScoreRanking);

		JButton button_6 = new JButton("k");
		button_6.setBounds(37, 89, 89, 23);
		getContentPane().add(button_6);
	}
}
