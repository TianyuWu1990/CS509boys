package com.capricorn.reponse;

import xml.Message;

import com.capricorn.RequestController.CreateGameRequest;
import com.capricorn.ResponseController.LockGameResponse;
import com.capricorn.entity.Model;
import com.capricorn.mockServer.MockServer;
import com.capricorn.view.Application;
import com.capricorn.view.MultiGame;

import junit.framework.TestCase;
public class TestLockGameResponse extends TestCase {
	/**
	 * @author yli14
	 * For test "LockGameResponse" in controller.
	 */

	Model model = new Model();
	Application app = new Application(model);
	MockServer mockServer = new MockServer("localhost");
	


	public void testprocess() throws Exception{
		/**Test the process() method of "LockGameResponse" in controller*/
		if (!Message.configure("wordsweeper.xsd")) {
			fail("unable to configure protocol");
		}
		app.setServerAccess(mockServer);
		MultiGame mg = new MultiGame(model, app);
		app.setMg(mg);
		model.getGame().setGameId("fortest");
		model.getGame().setLocked(false);
		
	
		String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?><response id=\"someMessageID\" success=\"true\">"
				+ "<lockGameResponse gameId=\"%s\"/></response>";
		xml=String.format(xml,model.getGame().getGameId());
		Message m = new Message(xml);
		boolean succe=new LockGameResponse(app,model).process(m);
		assertTrue(succe);
		assertTrue(model.getGame().isLocked());	
			
	}
}
