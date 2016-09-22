package Ui;
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
import java.awt.Font;

public class ManagerGameJFramev2Exit extends JFrame{
	private JTextField textField;
	private JTextField txtEric;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtOwn;
	private JTextField txtUnlock;
	public ManagerGameJFramev2Exit() {
		setTitle("Your Game");
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Restart");
		btnNewButton.setBounds(489, 285, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("lock");
		btnNewButton_1.setBounds(489, 338, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setBounds(489, 387, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setText("15");
		textField.setBounds(87, 23, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Your Score:");
		lblNewLabel.setBounds(10, 23, 85, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Identity:");
		lblNewLabel_1.setBounds(211, 23, 68, 20);
		getContentPane().add(lblNewLabel_1);
		
		txtEric = new JTextField();
		txtEric.setText("Manager");
		txtEric.setBounds(279, 23, 86, 20);
		getContentPane().add(txtEric);
		txtEric.setColumns(10);
		
		JLabel lblPeterScore = new JLabel("Peter Score:");
		lblPeterScore.setBounds(10, 245, 85, 20);
		getContentPane().add(lblPeterScore);
		
		JLabel lblSunziScore = new JLabel("Bob Score:");
		lblSunziScore.setBounds(10, 276, 85, 20);
		getContentPane().add(lblSunziScore);
		
		JLabel lblKevinScore = new JLabel("Kevin Score:");
		lblKevinScore.setBounds(10, 307, 85, 20);
		getContentPane().add(lblKevinScore);
		
		textField_2 = new JTextField();
		textField_2.setText("20");
		textField_2.setColumns(10);
		textField_2.setBounds(87, 245, 86, 20);
		getContentPane().add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setText("30");
		textField_4.setColumns(10);
		textField_4.setBounds(87, 276, 86, 20);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("35");
		textField_5.setColumns(10);
		textField_5.setBounds(87, 307, 86, 20);
		getContentPane().add(textField_5);
		
		JLabel lblLettersYouPick = new JLabel("Letters you pick");
		lblLettersYouPick.setBounds(41, 390, 85, 20);
		getContentPane().add(lblLettersYouPick);
		
		txtOwn = new JTextField();
		txtOwn.setText("loan");
		txtOwn.setColumns(10);
		txtOwn.setBounds(142, 390, 180, 20);
		getContentPane().add(txtOwn);
		
		JButton btnNewButton_4 = new JButton("Submit");
		btnNewButton_4.setBounds(233, 429, 147, 40);
		getContentPane().add(btnNewButton_4);
		
		txtUnlock = new JTextField();
		txtUnlock.setText("Unlock");
		txtUnlock.setColumns(10);
		txtUnlock.setBounds(469, 23, 86, 20);
		getContentPane().add(txtUnlock);
		
		JLabel lblStatue = new JLabel("Statue:");
		lblStatue.setBounds(401, 23, 68, 20);
		getContentPane().add(lblStatue);
		
		JButton button = new JButton("y");
		button.setBounds(323, 194, 89, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("a");
		button_1.setBounds(224, 194, 89, 23);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("d");
		button_2.setBounds(224, 160, 89, 23);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("r");
		button_3.setBounds(121, 160, 89, 23);
		getContentPane().add(button_3);
		
		JButton button_4 = new JButton("d");
		button_4.setBounds(121, 194, 89, 23);
		getContentPane().add(button_4);
		
		JButton button_5 = new JButton("o");
		button_5.setBounds(323, 160, 89, 23);
		getContentPane().add(button_5);
		
		JButton button_6 = new JButton("w");
		button_6.setBounds(22, 194, 89, 23);
		getContentPane().add(button_6);
		
		JButton button_7 = new JButton("o");
		button_7.setBounds(22, 160, 89, 23);
		getContentPane().add(button_7);
		
		JButton button_8 = new JButton("l");
		button_8.setBounds(22, 115, 89, 23);
		getContentPane().add(button_8);
		
		JButton button_9 = new JButton("o");
		button_9.setBounds(121, 115, 89, 23);
		getContentPane().add(button_9);
		
		JButton button_10 = new JButton("a");
		button_10.setBounds(224, 115, 89, 23);
		getContentPane().add(button_10);
		
		JButton button_11 = new JButton("n");
		button_11.setBounds(323, 115, 89, 23);
		getContentPane().add(button_11);
		
		JButton button_12 = new JButton("a");
		button_12.setBounds(323, 81, 89, 23);
		getContentPane().add(button_12);
		
		JButton button_13 = new JButton("w");
		button_13.setBounds(121, 81, 89, 23);
		getContentPane().add(button_13);
		
		JButton button_14 = new JButton("a");
		button_14.setBounds(22, 81, 89, 23);
		getContentPane().add(button_14);
		
		JButton btnB = new JButton("b");
		btnB.setBounds(224, 81, 89, 23);
		getContentPane().add(btnB);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(211, 73, 211, 73);
		getContentPane().add(horizontalBox);
		
		JButton button_15 = new JButton("left");
		button_15.setBounds(450, 130, 89, 23);
		getContentPane().add(button_15);
		
		JButton button_16 = new JButton("down");
		button_16.setBounds(511, 183, 89, 23);
		getContentPane().add(button_16);
		
		JButton button_17 = new JButton("up");
		button_17.setBounds(511, 81, 89, 23);
		getContentPane().add(button_17);
		
		JButton button_18 = new JButton("right");
		button_18.setBounds(568, 130, 89, 23);
		getContentPane().add(button_18);
	}
}
