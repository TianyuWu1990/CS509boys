package com.capricorn.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import com.capricorn.view.PracticeGame;

public class ClickLetter implements ActionListener{
	PracticeGame p;
	public ClickLetter(PracticeGame p){
		this.p=p;
	}

	@Override
public void actionPerformed(ActionEvent a) {
		
		JButton button = (JButton) a.getSource();
		int x=button.getBounds().x;
		int y=button.getBounds().y;
		int indx=(x-30)/100;
		int indy=(y-80)/40;
		String coor=indx+""+indy+"";
		p.list.add(coor);
        for (int i = 0; i < 4; i++) {
			
			for (int j = 0; j < 4; j++) {
				if (((indx-1==i&&indy-1==j)||(indx-1==i&&indy==j)||(indx-1==i&&indy+1==j)||(indx==i&&indy-1==j)||
						(indx==i&&indy+1==j)||(indx+1==i&&indy-1==j)||(indx+1==i&&indy==j)||(indx+1==i&&indy+1==j))&&(!p.list.contains(i+""+j+""))){
				p.btnArray[i][j].setEnabled(true);}
				else{
					p.btnArray[i][j].setEnabled(false);
				}
				
			}
	}
		
		String val = p.txtOwn.getText();
		int points = 0;
		p.txtOwn.setText(val + button.getText());
		if(p.txtOwn.getText().length() >= 3){
			points = Integer.parseInt(p.textField.getText()) + Integer.parseInt(button.getToolTipText())*10*((int)Math.pow(2, val.length()));
		}else{
			points = Integer.parseInt(p.textField.getText()) + Integer.parseInt(button.getToolTipText());
		}
		p.textField.setText(String.valueOf(points));
		button.setEnabled(false);
		

	}
	}
