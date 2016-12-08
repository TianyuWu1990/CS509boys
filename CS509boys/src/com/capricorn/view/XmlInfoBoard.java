package com.capricorn.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class XmlInfoBoard extends JFrame {
/**
 * A interface which can monitoring the request and response between client and server.
 */
	private JPanel contentPane;
	private JTextArea messageInfo;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public XmlInfoBoard() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("       Request and Response Information");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(82, 16, 327, 37);
		contentPane.add(lblNewLabel);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 69, 397, 203);
		contentPane.add(scrollPane);
		messageInfo = new JTextArea();
		scrollPane.setViewportView(messageInfo);
	}

	public JTextArea getMessageInfo() {
		return messageInfo;
	}

	public void setMessageInfo(JTextArea messageInfo) {
		this.messageInfo = messageInfo;
	}
}
