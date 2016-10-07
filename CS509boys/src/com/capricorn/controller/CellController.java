package com.capricorn.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.capricorn.view.StartPage;

public class CellController implements ActionListener {
	JFrame frame;
	
	public CellController(JFrame frame){
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				StartPage page = new StartPage();
				page.setSize(600, 300); // set StartPage size
				page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				page.setVisible(true);
			}
		});
	}
	
	JButton btnNewButton_2 = new JButton("Exit Practice");
	
	//btnNewButton_2.setBounds(462, 14, 111, 38);
	//getContentPane().add(btnNewButton_2);

}
