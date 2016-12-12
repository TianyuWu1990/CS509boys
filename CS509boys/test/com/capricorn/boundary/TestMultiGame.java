package com.capricorn.boundary;

import static org.junit.Assert.fail;

import javax.swing.JButton;

import com.capricorn.entity.Model;
import com.capricorn.mockServer.MockServer;
import com.capricorn.view.Application;
import com.capricorn.view.MultiGame;

import junit.framework.TestCase;
import xml.Message;

public class TestMultiGame extends TestCase{
	
	public void testprocess() throws Exception{
		MockServer mockServer = new MockServer("localhost");
		Model model = new Model();
		Application app = new Application(model);
		if (!Message.configure("wordsweeper.xsd")) {
			fail("unable to configure protocol");
		}
		app.setServerAccess(mockServer);
		model.updateModel("da", "das", "dsa", 1, 2 ,"A,G,H,Y,U,I,O,I,J,I,K,I,H,N,J,M", 100,"3,1"
				);
		MultiGame mult = new MultiGame(model, app);
		mult.btnLock.doClick();
		mult.button_reset.doClick();
		mult.btn_xmlc.doClick();
		mult.btn_xmlo.doClick();
		mult.button_left.doClick();
		mult.button_up.doClick();
		mult.button_right.doClick();
		mult.button_down.doClick();
		mult.button_submit.doClick();
		mult.btnExit.doClick();;
		mult.btnClear.doClick();
		model.getBoard().setBonusCell("3,1");
		
		for(JButton jbn:mult.getAllCellsbtns()){
			jbn.doClick();
		}
		mult.setVisible(true);
		assertTrue(mult.isVisible());

		}

}
