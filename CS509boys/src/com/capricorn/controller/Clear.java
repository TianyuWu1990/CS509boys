package com.capricorn.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.capricorn.view.PracticeGame;
/**
 * Responsible for clear all the letters in the board field.
 */
public class Clear implements ActionListener{
	PracticeGame p;
	public Clear(PracticeGame p){
		this.p=p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (p.txtOwn.getText().length() != 0) {
			p.txtOwn.setText(null);
		}
		p.textField.setText("0");
		p.sum = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				p.btnArray[i][j].setEnabled(true);;
			}
	}
		 p.list=new ArrayList<String>();	
	}
}

