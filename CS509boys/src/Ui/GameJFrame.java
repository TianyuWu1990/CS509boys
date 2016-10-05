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

public class GameJFrame extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	public GameJFrame() {
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Restart");
		btnNewButton.setBounds(492, 37, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Lock");
		btnNewButton_1.setBounds(492, 104, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setBounds(492, 172, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(73, 23, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Score:");
		lblNewLabel.setBounds(20, 23, 55, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Identity:");
		lblNewLabel_1.setBounds(211, 23, 68, 20);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(279, 23, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JTextArea txtrGameHere = new JTextArea();
		txtrGameHere.setText("Game here");
		txtrGameHere.setBounds(20, 76, 432, 361);
		getContentPane().add(txtrGameHere);
	}
}
