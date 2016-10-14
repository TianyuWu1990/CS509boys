package com.capricorn.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


import com.capricorn.model.Model;
import com.capricorn.view.PracticeGame;
import com.capricorn.view.StartPage;

public class StartPractice implements ActionListener{
	StartPage st;
	Model m;
	public StartPractice(StartPage p,Model m){
		this.st=p;
		this.m=m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		st.dispose();
		
		PracticeGame practice = new PracticeGame(m);
		
		// initialized practice page
		practice.setSize(600, 300); // set practicegame size
		practice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		practice.setVisible(true);
		}
	}