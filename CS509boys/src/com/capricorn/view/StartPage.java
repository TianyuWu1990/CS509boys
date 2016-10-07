package com.capricorn.view;

import java.awt.EventQueue;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;

public class StartPage extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public StartPage() {
		setTitle("WordSweeper");
		getContentPane().setLayout(null);

		JButton btnStart = new JButton("Create a game");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ManagerGame manager = new ManagerGame();
				manager.setSize(620, 500); // set ManagerGame size
				manager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				manager.setVisible(true);
			}
		});
		btnStart.setBounds(65, 37, 137, 23);
		getContentPane().add(btnStart);

		JButton btnStop = new JButton("Join a game");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GuestGame guest = new GuestGame();
				guest.setSize(620, 500); // set ManagerGame size
				guest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				guest.setVisible(true);
			}
		});
		btnStop.setBounds(65, 128, 149, 23);
		getContentPane().add(btnStop);

		JButton btnNewButton_1 = new JButton("Practice mode");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PracticeGame practice = new PracticeGame();
				practice.setSize(600, 300); // set practicegame size
				practice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				practice.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(65, 215, 117, 29);
		getContentPane().add(btnNewButton_1);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // exit game
			}
		});
		btnExit.setBounds(370, 215, 117, 29);
		getContentPane().add(btnExit);

		textField = new JTextField();
		textField.setBounds(226, 33, 134, 28);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblOptionalPassword = new JLabel("Game ID");
		lblOptionalPassword.setBounds(389, 39, 61, 16);
		getContentPane().add(lblOptionalPassword);

		textField_1 = new JTextField();
		textField_1.setBounds(226, 124, 134, 28);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblEnterGameId = new JLabel("Enter game ID");
		lblEnterGameId.setBounds(389, 130, 98, 16);
		getContentPane().add(lblEnterGameId);

		textField_2 = new JTextField();
		textField_2.setBounds(226, 152, 134, 28);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel lblPassword = new JLabel("Password ( Optional )");
		lblPassword.setBounds(389, 158, 137, 16);
		getContentPane().add(lblPassword);

		textField_3 = new JTextField();
		textField_3.setBounds(226, 63, 134, 28);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);

		JLabel lblPasswordOptional = new JLabel("Password ( Optional )");
		lblPasswordOptional.setBounds(389, 69, 137, 16);
		getContentPane().add(lblPasswordOptional);
	}
}
