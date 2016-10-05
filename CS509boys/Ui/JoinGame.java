package com.java.Ui;
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
public class JoinGame extends JFrame{
	private JTextField textField;
	public JoinGame() {
		setTitle("Join Game");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Eric's Game");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(149, 11, 136, 39);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(63, 36, 68, 51);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(149, 53, 136, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Join");
		btnNewButton.setBounds(149, 93, 107, 34);
		getContentPane().add(btnNewButton);
	}

}
