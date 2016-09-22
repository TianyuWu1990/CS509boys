package com.java.Ui;
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
public class PractiseModel extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtOwn;
	public PractiseModel() {
		setTitle("PratiseModel");
		getContentPane().setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setBounds(482, 130, 95, 38);
		getContentPane().add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setText("20");
		textField.setBounds(87, 23, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Your Score:");
		lblNewLabel.setBounds(10, 23, 85, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Identity:");
		lblNewLabel_1.setBounds(211, 23, 68, 20);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(279, 23, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("a");
		btnNewButton_3.setBounds(31, 89, 89, 23);
		getContentPane().add(btnNewButton_3);
		
		JButton btnS = new JButton("s");
		btnS.setBounds(130, 89, 89, 23);
		getContentPane().add(btnS);
		
		JButton btnK = new JButton("k");
		btnK.setBounds(233, 89, 89, 23);
		getContentPane().add(btnK);
		
		JButton btnO = new JButton("o");
		btnO.setBounds(332, 89, 89, 23);
		getContentPane().add(btnO);
		
		JButton btnL = new JButton("l");
		btnL.setBounds(31, 123, 89, 23);
		getContentPane().add(btnL);
		
		JButton btnL_2 = new JButton("l");
		btnL_2.setBounds(130, 123, 89, 23);
		getContentPane().add(btnL_2);
		
		JButton btnO_3 = new JButton("o");
		btnO_3.setBounds(233, 123, 89, 23);
		getContentPane().add(btnO_3);
		
		JButton btnW = new JButton("w");
		btnW.setBounds(332, 123, 89, 23);
		getContentPane().add(btnW);
		
		JButton btnL_1 = new JButton("l");
		btnL_1.setBounds(31, 157, 89, 23);
		getContentPane().add(btnL_1);
		
		JButton btnO_2 = new JButton("o");
		btnO_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnO_2.setBounds(130, 157, 89, 23);
		getContentPane().add(btnO_2);
		
		JButton btnA = new JButton("a");
		btnA.setBounds(233, 157, 89, 23);
		getContentPane().add(btnA);
		
		JButton btnN = new JButton("n");
		btnN.setBounds(332, 157, 89, 23);
		getContentPane().add(btnN);
		
		JButton btnY = new JButton("y");
		btnY.setBounds(31, 191, 89, 23);
		getContentPane().add(btnY);
		
		JButton btnE = new JButton("e");
		btnE.setBounds(130, 191, 89, 23);
		getContentPane().add(btnE);
		
		JButton btnS_1 = new JButton("s");
		btnS_1.setBounds(233, 191, 89, 23);
		getContentPane().add(btnS_1);
		
		JButton btnO_1 = new JButton("o");
		btnO_1.setBounds(332, 191, 89, 23);
		getContentPane().add(btnO_1);
		
		JLabel lblLettersYouPick = new JLabel("Letters you pick");
		lblLettersYouPick.setBounds(31, 265, 85, 20);
		getContentPane().add(lblLettersYouPick);
		
		txtOwn = new JTextField();
		txtOwn.setText("own");
		txtOwn.setColumns(10);
		txtOwn.setBounds(130, 265, 180, 20);
		getContentPane().add(txtOwn);
		
		JButton btnNewButton_4 = new JButton("Submit");
		btnNewButton_4.setBounds(130, 314, 147, 40);
		getContentPane().add(btnNewButton_4);
	}
}
