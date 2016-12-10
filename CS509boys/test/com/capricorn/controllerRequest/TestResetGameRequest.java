package com.capricorn.controllerRequest;

import java.util.ArrayList;

import xml.Message;

import com.capricorn.RequestController.ResetGameRequest;
import com.capricorn.entity.Model;
import com.capricorn.mockServer.*;
import com.capricorn.view.Application;

import junit.framework.TestCase;

public class TestResetGameRequest extends TestCase {
	/**
	 * @author yli14
	 * This is for test 'ResetGameRequest' in controller
	 */
	Model model = new Model();
	Application app = new Application(model);
	MockServer ms = new MockServer("localhost");
			
	
	public void testprocess() throws Exception{
		/**
		 * Test Process() method in 'ResetGameRequest'
		 */
		if (!Message.configure("wordsweeper.xsd")) { 
			fail ("unable to configure protocol"); 
		}
		app.setServerAccess(ms);
		ResetGameRequest req = new ResetGameRequest(model, app);
		model.getGame().setGameId("forTest");
	
		req.process();
	
		ArrayList<Message> al = new ArrayList<Message>();
		al = ms.getAndClearMessages();
		assertEquals(al.get(0).contents.getFirstChild().getLocalName(),"resetGameRequest");
		assertEquals(al.get(0).contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue(),model.getGame().getGameId());
	
	
	
	
	
	}
}
