package com.capricorn.controllerReponse;

import xml.Message;

import static org.junit.Assert.assertTrue;

import com.capricorn.RequestController.CreateGameRequest;
import com.capricorn.ResponseController.LockGameResponse;
import com.capricorn.ResponseController.SampleClientMessageHandler;
import com.capricorn.entity.Model;
import com.capricorn.mockServer.MockServer;
import com.capricorn.view.Application;
import com.capricorn.view.MultiGame;

import junit.framework.TestCase;
public class TestLockGameResponse extends TestCase {
	/**
	 * @author yli14, Chen Li, Bowen Sun
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
		LockGameResponse lck=new LockGameResponse(app,model);
		boolean succe=lck.process(m);
		assertTrue(succe);
			
		
		/**this is the test for connect response process part 2*/
		String xml2= "<?xml version=\"1.0\" encoding=\"UTF-8\"?><response id=\"someMessageID\" success=\"true\">"
		    + "<connectResponse id=\"game1\">"
		    +"</connectResponse></response>";
		xml2 =String.format(xml2);
		Message n = new Message(xml2);
		
SampleClientMessageHandler handler = new SampleClientMessageHandler(app);
		
		
		handler.registerHandler(lck);
	
		assertTrue(model.getGame().isLocked());	
		assertTrue(lck.process(n));
	}
}
