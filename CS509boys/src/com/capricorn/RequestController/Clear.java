package com.capricorn.RequestController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.capricorn.view.PracticeGame;
/**
 * Responsible for clear all the letters in the board field.
 */
public class Clear implements ActionListener{
	/**
	 * Here is a constructor for Clear in order to make a fault value.
	 * Construct Clear object to use default port number.
	 */
	PracticeGame p;
	public Clear(PracticeGame p){
		this.p=p;
	}
	/** 
	 * Override the the actionPerformed, so under the conditions that
	 *  Firstly nothing exists so we set null
	 *  Secondly else if there can be got something like letters we set it to 0;
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (p.txtOwn.getText().length() != 0) {
			p.txtOwn.setText(null);
		}
		p.textField.setText("0");
		p.sum = 0;
		//loop to set the button true
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				p.btnArray[i][j].setEnabled(true);;
			}
	}
		 p.list=new ArrayList<String>();	
	}
}

