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

public class ManagerGameJFramev2 extends JFrame{
	private JTextField textField;
	private JTextField txtEric;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtOwn;
	private JTextField txtUnlock;
	public ManagerGameJFramev2() {
		setTitle("Your Game");
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Restart");
		btnNewButton.setBounds(539, 317, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Unlock");
		btnNewButton_1.setBounds(539, 370, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setBounds(539, 419, 89, 23);
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
		
		txtEric = new JTextField();
		txtEric.setText("Manager");
		txtEric.setBounds(279, 23, 86, 20);
		getContentPane().add(txtEric);
		txtEric.setColumns(10);
		
		JButton btnS = new JButton("s");
		btnS.setBounds(37, 89, 89, 23);
		getContentPane().add(btnS);
		
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
		
		JLabel lblPeterScore = new JLabel("Peter Score:");
		lblPeterScore.setBounds(10, 238, 85, 20);
		getContentPane().add(lblPeterScore);
		
		JLabel lblEricScore = new JLabel("Laren Score:");
		lblEricScore.setBounds(10, 269, 85, 20);
		getContentPane().add(lblEricScore);
		
		JLabel lblSunziScore = new JLabel("Sunzi Score:");
		lblSunziScore.setBounds(10, 300, 85, 20);
		getContentPane().add(lblSunziScore);
		
		JLabel lblKevinScore = new JLabel("Kevin Score:");
		lblKevinScore.setBounds(10, 331, 85, 20);
		getContentPane().add(lblKevinScore);
		
		textField_2 = new JTextField();
		textField_2.setText("15");
		textField_2.setColumns(10);
		textField_2.setBounds(87, 238, 86, 20);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("25");
		textField_3.setColumns(10);
		textField_3.setBounds(87, 269, 86, 20);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("30");
		textField_4.setColumns(10);
		textField_4.setBounds(87, 300, 86, 20);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("35");
		textField_5.setColumns(10);
		textField_5.setBounds(87, 331, 86, 20);
		getContentPane().add(textField_5);
		
		JLabel lblLettersYouPick = new JLabel("Letters you pick");
		lblLettersYouPick.setBounds(41, 390, 85, 20);
		getContentPane().add(lblLettersYouPick);
		
		txtOwn = new JTextField();
		txtOwn.setText("own");
		txtOwn.setColumns(10);
		txtOwn.setBounds(142, 390, 180, 20);
		getContentPane().add(txtOwn);
		
		JButton btnNewButton_4 = new JButton("Submit");
		btnNewButton_4.setBounds(233, 429, 147, 40);
		getContentPane().add(btnNewButton_4);
		
		txtUnlock = new JTextField();
		txtUnlock.setText("lock");
		txtUnlock.setColumns(10);
		txtUnlock.setBounds(469, 23, 86, 20);
		getContentPane().add(txtUnlock);
		
		JLabel lblStatue = new JLabel("Statue:");
		lblStatue.setBounds(401, 23, 68, 20);
		getContentPane().add(lblStatue);
		
		JButton button = new JButton("left");
		button.setBounds(469, 138, 89, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("down");
		button_1.setBounds(530, 191, 89, 23);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("up");
		button_2.setBounds(530, 89, 89, 23);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("right");
		button_3.setBounds(587, 138, 89, 23);
		getContentPane().add(button_3);
		
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
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(132, 83, 198, 69);
		getContentPane().add(horizontalBox);
	}
}
