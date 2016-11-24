package com.capricorn.RequestController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.capricorn.view.MultiGame;

public class ClickButton_multiGame implements ActionListener {
	MultiGame mg;
	/** Define the defalut p for PracticeGame
	 *Construct ClickLetter object to use default port number. 
	 */
public ClickButton_multiGame(MultiGame mg){
		this.mg=mg;
	}
	
	/**Define the function actionPerformed is used after clicking  */
	@Override
public void actionPerformed(ActionEvent a) {
		/**
		 * first part is aim to make the button dark after clicking 
		 * avoid reclicking the button again
		 */
		
		JButton button = (JButton) a.getSource();
		int index = mg.getAllCellsbtns().indexOf(button);  
		if(mg.isBonusCell(index)){
			button.setBackground(Color.CYAN);
		}
		else{
		button.setBackground(Color.red);
		}
		
		if(mg.getChosenbtns().contains(button)){
		mg.message.setText("This Letter has been chosen!");
//		mg.message.setForeground(Color.red);
        
        return;
        }
		mg.message.setText("");
		
		mg.getChosenbtns().add(button);
		
        mg.getModel().getBoard().addToChosenCellsByIndex(index);
		for (int i = 0; i < 16; i++) {
			
			
if ((index%4!=0&&(index+1)%4!=0)&&(1==Math.abs(index-i)||4==Math.abs(index-i)||3==Math.abs(index-i)||5==Math.abs(index-i))
		||((index%4==0)&&((1==-index+i)||4==Math.abs(index-i)||3==index-i||5==-index+i))
		||(((index+1)%4==0)&&((1==index-i)||4==Math.abs(index-i)||5==index-i||3==-index+i))
		||(mg.getChosenbtns().contains(mg.getAllCellsbtns().get(i))))
	
		{
		mg.getAllCellsbtns().get(i).setEnabled(true);
		
		}
		else{
				mg.getAllCellsbtns().get(i).setEnabled(false);
				
				
				
				}
		
				
			}
	
        /**After clicking, get the value on the button and then sent to the 'txtOwn'*/
		String val = mg.textField_word.getText();
		int points = 0;
		mg.sum += Integer.parseInt(button.getToolTipText());
		mg.textField_word.setText(val + button.getText());
		
		if(mg.textField_word.getText().length() >= 3){
			points = mg.sum*10*((int)Math.pow(2, mg.textField_word.getText().length()));
		}else{
			points = Integer.parseInt(mg.textField_escore.getText()) + Integer.parseInt(button.getToolTipText());
		}
		mg.textField_escore.setText(String.valueOf(points));
		
		

	}
	
	
	
	}


