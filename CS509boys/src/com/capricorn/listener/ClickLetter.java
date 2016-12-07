package com.capricorn.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.capricorn.model.Model;
import com.capricorn.view.MultiGame;
import com.capricorn.view.PracticeGame;
/**
 * In the word board, we want to realize the function that click the letter
 * and demostrate the letter in the blank 
 */
public class ClickLetter implements ActionListener{
	PracticeGame p;
	
	/**
	 *  Define the defalut p for PracticeGame
	 * Construct ClickLetter object to use default port number.
	 *
	 * @param p the p
	 */
	public ClickLetter(PracticeGame p){
		this.p=p;
	}
	/**Define the function actionPerformed is used after clicking  */
	@Override
public void actionPerformed(ActionEvent a) {
		/**
		 * first part is aim to make the button dark after clicking 
		 * avoid reclicking the button again
		 */
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
        /**After clicking, get the value on the button and then sent to the 'txtOwn'*/
		String val = p.txtOwn.getText();
		int points = 0;
		p.sum += Integer.parseInt(button.getToolTipText());
		//System.out.println(p.sum);
		p.txtOwn.setText(val + button.getText());
		
		if(p.txtOwn.getText().length() >= 3){
			points = p.sum*10*((int)Math.pow(2, p.txtOwn.getText().length()));
		}else{
			points = Integer.parseInt(p.textField.getText()) + Integer.parseInt(button.getToolTipText());
		}
		p.textField.setText(String.valueOf(points));
		button.setEnabled(false);
		

	}
	
	}
