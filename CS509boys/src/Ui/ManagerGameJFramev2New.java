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

public class ManagerGameJFramev2New extends JFrame{
	private JTextField textField;
	private JTextField txtEric;
	private JTextField textField_2;
	private JTextField txtOwn;
	private JTextField txtUnlock;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	public ManagerGameJFramev2New() {
		setTitle("Your Game");
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Restart");
		btnNewButton.setBounds(486, 285, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Lock");
		btnNewButton_1.setBounds(486, 338, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setBounds(486, 387, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setText("0");
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
		
		JLabel lblPeterScore = new JLabel("player1 Score:");
		lblPeterScore.setBounds(10, 238, 85, 20);
		getContentPane().add(lblPeterScore);
		
		textField_2 = new JTextField();
		textField_2.setText("0");
		textField_2.setColumns(10);
		textField_2.setBounds(87, 238, 86, 20);
		getContentPane().add(textField_2);
		
		JLabel lblLettersYouPick = new JLabel("Letters you pick");
		lblLettersYouPick.setBounds(41, 390, 85, 20);
		getContentPane().add(lblLettersYouPick);
		
		txtOwn = new JTextField();
		txtOwn.setColumns(10);
		txtOwn.setBounds(142, 390, 180, 20);
		getContentPane().add(txtOwn);
		
		JButton btnNewButton_4 = new JButton("Submit");
		btnNewButton_4.setBounds(233, 429, 147, 40);
		getContentPane().add(btnNewButton_4);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(229, 78, 202, 79);
		getContentPane().add(horizontalBox);
		
		JLabel lblStatues = new JLabel("Statues:");
		lblStatues.setBounds(403, 23, 68, 20);
		getContentPane().add(lblStatues);
		
		txtUnlock = new JTextField();
		txtUnlock.setText("unlock");
		txtUnlock.setColumns(10);
		txtUnlock.setBounds(471, 23, 86, 20);
		getContentPane().add(txtUnlock);
		
		JLabel lblPlayerScore = new JLabel("player2 Score:");
		lblPlayerScore.setBounds(10, 269, 85, 20);
		getContentPane().add(lblPlayerScore);
		
		textField_1 = new JTextField();
		textField_1.setText("0");
		textField_1.setColumns(10);
		textField_1.setBounds(87, 269, 86, 20);
		getContentPane().add(textField_1);
		
		JLabel lblPlayerScore_1 = new JLabel("player3 Score:");
		lblPlayerScore_1.setBounds(10, 301, 85, 20);
		getContentPane().add(lblPlayerScore_1);
		
		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.setColumns(10);
		textField_3.setBounds(87, 301, 86, 20);
		getContentPane().add(textField_3);
		
		JLabel lblPlayerScore_2 = new JLabel("player4 Score:");
		lblPlayerScore_2.setBounds(10, 332, 85, 20);
		getContentPane().add(lblPlayerScore_2);
		
		textField_4 = new JTextField();
		textField_4.setText("0");
		textField_4.setColumns(10);
		textField_4.setBounds(87, 332, 86, 20);
		getContentPane().add(textField_4);
		
		JButton button = new JButton("left");
		button.setBounds(461, 138, 89, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("down");
		button_1.setBounds(522, 191, 89, 23);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("up");
		button_2.setBounds(522, 89, 89, 23);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("right");
		button_3.setBounds(579, 138, 89, 23);
		getContentPane().add(button_3);
	}
}
