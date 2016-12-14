package com.capricorn.controllerReponse;

import xml.Message;
import com.capricorn.ResponseController.ResetGameResponse;
import com.capricorn.ResponseController.SampleClientMessageHandler;
import com.capricorn.entity.Model;
import com.capricorn.mockServer.MockServer;
import com.capricorn.view.Application;
import com.capricorn.view.MultiGame;

import junit.framework.TestCase;
/**
 * @author yli14, Bowen Sun, Chen Li
 * For test "ResetGameResponse" in controller.
 */
public class TestResetGameResponse extends TestCase {
	
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
		ResetGameResponse rgr=new ResetGameResponse(app,model);
		boolean succe=rgr.process(m);
		assertTrue(succe);
		assertEquals(model.getPlayer().getScore(),0);	
		
		/**this is the test for connect response process part 2*/
		String xml2= "<?xml version=\"1.0\" encoding=\"UTF-8\"?><response id=\"someMessageID\" success=\"true\">"
		    + "<connectResponse id=\"game1\">"
		    +"</connectResponse></response>";
		xml2 =String.format(xml2);
		Message n = new Message(xml2);
		
SampleClientMessageHandler handler = new SampleClientMessageHandler(app);
		
		
		handler.registerHandler(rgr);
		assertEquals(model.getPlayer().getScore(),0);	
		assertTrue(rgr.process(n));
			
	}
}
