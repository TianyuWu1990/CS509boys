package com.capricorn.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.capricorn.entity.Board;
import com.capricorn.entity.Model;
import com.capricorn.view.PracticeGame;
/**
 * When occur to some conflict condition like no word can be find 
 * or want to have a better beginning for the game.
 * Reset function right now is used to solve problems by the administer
 * <p>
 * The whole process is rebuild the data letter randomly and resends to the board
 * Same like clear function, not only will reset clear everything, but also renew the board   
 */
/**Actionlistener relate to Rest also attached with Constructor 
  *@author Chen Li, Dongsheng Wang, Yu Li, Tianyu Wu, Bowen Sun
  */
public class Reset_practiceGame implements ActionListener{
	PracticeGame p;
	Model m;
	public Reset_practiceGame(PracticeGame p,Model m){
		this.p=p;
		this.m=m;
	}

/**
 * ActionListener when the reset button push and the following happen.
 *
 * @param e is the ActionEvent
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (p.txtOwn.getText().length() != 0) {
			p.txtOwn.setText(null);
		}
		p.textField.setText("0");
		p.sum = 0;
		m.getBoard().setcellArrayForPractice();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {						
			p.btnArray[i][j].setText(m.getBoard().getCells()[i][j].getLetter()); 
			p.btnArray[i][j].setToolTipText(m.getBoard().getCells()[i][j].getPoints());	
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
