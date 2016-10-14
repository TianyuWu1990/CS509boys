package com.capricorn.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.capricorn.entity.Board;
import com.capricorn.model.Model;
import com.capricorn.view.PracticeGame;

public class Reset implements ActionListener{
	PracticeGame p;
	Model m;
	public Reset(PracticeGame p,Model m){
		this.p=p;
		this.m=m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (p.txtOwn.getText().length() != 0) {
			p.txtOwn.setText(null);
		}
		p.textField.setText("0");
		p.sum = 0;
		m.board.setcellArray();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {						
			p.btnArray[i][j].setText(m.board.letterArray[i][j].letter); 
			p.btnArray[i][j].setToolTipText(m.board.letterArray[i][j].points);	
			}					
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				p.btnArray[i][j].setEnabled(true);;
			}
	}
		p.list=new ArrayList<String>();	
	}
}
