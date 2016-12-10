package com.capricorn.reponse;

import xml.Message;
import com.capricorn.ResponseController.ResetGameResponse;
import com.capricorn.entity.Model;
import com.capricorn.mockServer.MockServer;
import com.capricorn.view.Application;
import com.capricorn.view.MultiGame;

import junit.framework.TestCase;

public class TestResetGameResponse extends TestCase {
	/**
	 * @author yli14
	 * For test "ResetGameResponse" in controller.
	 */
	Model model = new Model();
	Application app = new Application(model);
	MockServer mockServer = new MockServer("localhost");
	


	public void testprocess() throws Exception{
		/**Test the process() method of "ResetGameResponse" in controller*/
		if (!Message.configure("wordsweeper.xsd")) {
			fail("unable to configure protocol");
		}
		app.setServerAccess(mockServer);
		MultiGame mg = new MultiGame(model, app);
		app.setMg(mg);
		model.getGame().setGameId("fortest");
		model.getPlayer().setScore(100);
		
	
		String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?><response id=\"someMessageID\" success=\"true\">"
				+ "<resetGameResponse gameId=\"%s\"/></response>";
		xml=String.format(xml,model.getGame().getGameId());
		Message m = new Message(xml);
		boolean succe=new ResetGameResponse(app,model).process(m);
		assertTrue(succe);
		assertEquals(model.getPlayer().getScore(),0);	
			
	}
}
