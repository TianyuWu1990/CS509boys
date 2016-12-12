package com.capricorn.boundary;
import javax.swing.JButton;

import com.capricorn.entity.Model;
import com.capricorn.view.Application;
import com.capricorn.view.MultiGame;
import com.capricorn.view.PracticeGame;
import junit.framework.TestCase;

public class TestPracticeGame extends TestCase {
	public void testprocess() throws Exception{
		Model model = new Model();
		model.getBoard().setcellArrayForPractice();
		Application app = new Application(model);
		PracticeGame prac = new PracticeGame(model);
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				prac.btnArray[i][j].doClick();
			}
			prac.btn_submit.doClick();
			prac.btnResetBoard.doClick();
			prac.btnUndo.doClick();
			prac.btn_exit.doClick();
		prac.setVisible(true);
		assertTrue(prac.isVisible());

		}
    
}
}
