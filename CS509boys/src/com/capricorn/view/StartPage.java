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

import com.capricorn.controller.StartPractice;
import com.capricorn.entity.Board;
import com.capricorn.model.Model;

import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;

public class StartPage extends JFrame {
	private JTextField create_id_text;
	private JTextField join_id_text;
	private JTextField join_pass_text;
	private JTextField create_pass_text;
	static Model model;

	public StartPage(Model m) {
		if (m!=null){
          this.model=m;}
		setSize(600, 300);
		setTitle("WordSweeper");
		getContentPane().setLayout(null);

		JButton btnStart = new JButton("Create a game");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ManagerGame manager = new ManagerGame();
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
//		m=new Model();
		StartPractice StartPracticeControl= new StartPractice(this,model);
		
		btnNewButton_1.addActionListener(StartPracticeControl);
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

		create_id_text = new JTextField();
		create_id_text.setBounds(226, 33, 134, 28);
		getContentPane().add(create_id_text);
		create_id_text.setColumns(10);

		JLabel lblOptionalPassword = new JLabel("Game ID");
		lblOptionalPassword.setBounds(389, 39, 61, 16);
		getContentPane().add(lblOptionalPassword);

		join_id_text = new JTextField();
		join_id_text.setBounds(226, 124, 134, 28);
		getContentPane().add(join_id_text);
		join_id_text.setColumns(10);

		JLabel lblEnterGameId = new JLabel("Enter game ID");
		lblEnterGameId.setBounds(389, 130, 98, 16);
		getContentPane().add(lblEnterGameId);

		join_pass_text = new JTextField();
		join_pass_text.setBounds(226, 152, 134, 28);
		getContentPane().add(join_pass_text);
		join_pass_text.setColumns(10);

		JLabel lblPassword = new JLabel("Password ( Optional )");
		lblPassword.setBounds(389, 158, 137, 16);
		getContentPane().add(lblPassword);

		create_pass_text = new JTextField();
		create_pass_text.setBounds(226, 63, 134, 28);
		getContentPane().add(create_pass_text);
		create_pass_text.setColumns(10);

		JLabel lblPasswordOptional = new JLabel("Password ( Optional )");
		lblPasswordOptional.setBounds(389, 69, 137, 16);
		getContentPane().add(lblPasswordOptional);
	}
}
