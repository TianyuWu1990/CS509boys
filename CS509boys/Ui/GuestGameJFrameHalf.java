package com.java.Ui;
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
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;

public class GuestGameJFrameHalf extends JFrame{
	private JTextField textField;
	private JTextField txtLaren;
	private JTextField txtDay;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	public GuestGameJFrameHalf() {
		setTitle("Eric's Game");
		getContentPane().setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setBounds(492, 172, 96, 50);
		getContentPane().add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setText("25");
		textField.setBounds(97, 23, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Your Score:");
		lblNewLabel.setBounds(20, 23, 85, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Identity:");
		lblNewLabel_1.setBounds(211, 23, 68, 20);
		getContentPane().add(lblNewLabel_1);
		
		txtLaren = new JTextField();
		txtLaren.setText("Guest");
		txtLaren.setBounds(279, 23, 86, 20);
		getContentPane().add(txtLaren);
		txtLaren.setColumns(10);
		
		JButton btnA = new JButton("a");
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnA.setBounds(20, 112, 89, 23);
		getContentPane().add(btnA);
		
		JButton btnW_1 = new JButton("w");
		btnW_1.setBounds(119, 112, 89, 23);
		getContentPane().add(btnW_1);
		
		JButton btnB = new JButton("b");
		btnB.setBounds(222, 112, 89, 23);
		getContentPane().add(btnB);
		
		JButton button_2 = new JButton("a");
		button_2.setBounds(321, 112, 89, 23);
		getContentPane().add(button_2);
		
		JButton btnL = new JButton("l");
		btnL.setBounds(20, 146, 89, 23);
		getContentPane().add(btnL);
		
		JButton btnO_1 = new JButton("o");
		btnO_1.setBounds(119, 146, 89, 23);
		getContentPane().add(btnO_1);
		
		JButton button_13 = new JButton("a");
		button_13.setBounds(222, 146, 89, 23);
		getContentPane().add(button_13);
		
		JButton btnN = new JButton("n");
		btnN.setBounds(321, 146, 89, 23);
		getContentPane().add(btnN);
		
		JButton btnO = new JButton("o");
		btnO.setBounds(20, 180, 89, 23);
		getContentPane().add(btnO);
		
		JButton btnW = new JButton("w");
		btnW.setBounds(20, 214, 89, 23);
		getContentPane().add(btnW);
		
		JButton btnR = new JButton("r");
		btnR.setBounds(119, 180, 89, 23);
		getContentPane().add(btnR);
		
		JButton btnD = new JButton("d");
		btnD.setBounds(119, 214, 89, 23);
		getContentPane().add(btnD);
		
		JButton button_8 = new JButton("a");
		button_8.setBounds(222, 214, 89, 23);
		getContentPane().add(button_8);
		
		JButton btnO_2 = new JButton("o");
		btnO_2.setBounds(321, 180, 89, 23);
		getContentPane().add(btnO_2);
		
		JButton btnY = new JButton("y");
		btnY.setBounds(321, 214, 89, 23);
		getContentPane().add(btnY);
		
		JButton btnD_1 = new JButton("d");
		btnD_1.setBounds(222, 180, 89, 23);
		getContentPane().add(btnD_1);
		
		JLabel lblWordYouPick = new JLabel("Word you pick");
		lblWordYouPick.setBounds(20, 271, 85, 20);
		getContentPane().add(lblWordYouPick);
		
		txtDay = new JTextField();
		txtDay.setText("day");
		txtDay.setColumns(10);
		txtDay.setBounds(111, 271, 200, 20);
		getContentPane().add(txtDay);
		
		JLabel lblEricScore = new JLabel("Eric Score:");
		lblEricScore.setBounds(20, 320, 85, 20);
		getContentPane().add(lblEricScore);
		
		JLabel lblPeterScore = new JLabel("Peter Score:");
		lblPeterScore.setBounds(20, 351, 85, 20);
		getContentPane().add(lblPeterScore);
		
		JLabel lblBobScore = new JLabel("Bob Score:");
		lblBobScore.setBounds(20, 383, 85, 20);
		getContentPane().add(lblBobScore);
		
		JLabel lblKevinScore = new JLabel("Kevin Score:");
		lblKevinScore.setBounds(20, 414, 85, 20);
		getContentPane().add(lblKevinScore);
		
		textField_3 = new JTextField();
		textField_3.setText("15");
		textField_3.setColumns(10);
		textField_3.setBounds(97, 320, 86, 20);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("20");
		textField_4.setColumns(10);
		textField_4.setBounds(97, 351, 86, 20);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("25");
		textField_5.setColumns(10);
		textField_5.setBounds(97, 383, 86, 20);
		getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText("30");
		textField_6.setColumns(10);
		textField_6.setBounds(97, 414, 86, 20);
		getContentPane().add(textField_6);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(321, 270, 89, 23);
		getContentPane().add(btnNewButton);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setFont(new Font("Elephant", Font.BOLD, 12));
		horizontalBox.setBounds(218, 105, 200, 72);
		getContentPane().add(horizontalBox);
	}
}
