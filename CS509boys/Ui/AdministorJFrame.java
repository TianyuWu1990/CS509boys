package com.java.Ui;

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

import com.java.Property.*;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
public class AdministorJFrame extends JFrame {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	public AdministorJFrame() {
		setTitle("Administor");
		getContentPane().setLayout(null);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(586, 75, 89, 23);
		getContentPane().add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.setBounds(586, 147, 89, 23);
		getContentPane().add(btnStop);
		
		JButton btnNewButton = new JButton("board details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(296, 447, 121, 60);
		getContentPane().add(btnNewButton);
		
		table = new JTable();
		table.setBounds(74, 79, 466, 319);
		getContentPane().add(table);
		
		JLabel lblServerid = new JLabel("ManagerID:");
		lblServerid.setBounds(74, 30, 78, 23);
		getContentPane().add(lblServerid);
		
		textField = new JTextField();
		textField.setBounds(142, 31, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblServerid_1 = new JLabel("ServerID:");
		lblServerid_1.setBounds(268, 34, 78, 19);
		getContentPane().add(lblServerid_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(331, 31, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}

