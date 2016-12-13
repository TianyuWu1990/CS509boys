package com.capricorn.boundary;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import com.capricorn.entity.Model;
import com.capricorn.entity.Word;
import com.capricorn.mockServer.MockServer;
import com.capricorn.view.Application;
import com.capricorn.view.MultiGame;

import junit.framework.TestCase;
import xml.Message;
/**Test the 'MultiGame'*/
public class TestMultiGame extends TestCase{
	/**Test the function process() in the multigame*/
	public void testMultiGame() throws Exception{
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
		mult.btnLock.doClick();
		model.getBoard().setBonusCell("3,1");
		
		for(JButton jbn:mult.getAllCellsbtns()){
			jbn.doClick();
		}
		mult.button_submit.doClick();
		mult.setVisible(true);
		assertTrue(mult.isVisible());

		}
	public void testMultiGame2() throws Exception{
		MockServer mockServer = new MockServer("localhost");
		Model model = new Model();
		Application app = new Application(model);
		if (!Message.configure("wordsweeper.xsd")) {
			fail("unable to configure protocol");
		}
		app.setServerAccess(mockServer);
		model.updateModel("da", "das", "das", 1, 2 ,"A,G,H,Y,U,I,O,I,J,I,K,I,H,N,J,M", 100,"3,1"
				);
		model.getPlayer().setManager(true);
		MultiGame mult = new MultiGame(model, app);
		mult.btnLock.doClick();
		mult.button_reset.doClick();
		List<Word> list=new ArrayList<Word>();
		list.add(new Word("tree",500 ,"10.31"));
        model.getGame().setSelectedWord(list);
        model.getBoard().getWord().setScore(500);
		mult.button_submit.doClick();
		
		model.getBoard().setBonusCell("3,1");
		
		for(JButton jbn:mult.getAllCellsbtns()){
			jbn.doClick();
		}
		mult.button_submit.doClick();
		mult.setVisible(true);
		assertTrue(mult.isVisible());
		
	}

}
