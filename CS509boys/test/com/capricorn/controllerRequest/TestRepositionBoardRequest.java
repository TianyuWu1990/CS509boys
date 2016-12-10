package com.capricorn.controllerRequest;

import java.util.ArrayList;
import junit.framework.TestCase;
import xml.Message;
import com.capricorn.RequestController.RepositionBoardRequest;
import com.capricorn.entity.Model;
import com.capricorn.mockServer.MockServer;
import com.capricorn.view.Application;

public class TestRepositionBoardRequest extends TestCase{
	/**
	 * @author yli14
	 * This is for test 'RepositionBoardRequest' in controller
	 */
	Model model = new Model();
	Application app = new Application(model);
	MockServer ms = new MockServer("localhost");
	Integer []change = {1,1};
	
	public void testprocess() throws Exception{
		/**
		 * Test Process() method in 'RepositionBoardRequest'
		 */
		if (!Message.configure("wordsweeper.xsd")) { 
			fail ("unable to configure protocol"); 
		}
		app.setServerAccess(ms);
		RepositionBoardRequest req = new RepositionBoardRequest(model, app, change);
		model.getPlayer().setName("yu");
		model.getGame().setGameId("fortest");
		
		req.process();
		ArrayList<Message> al = new ArrayList<Message>();
		al = ms.getAndClearMessages();
		assertEquals(al.get(0).contents.getFirstChild().getLocalName(),"repositionBoardRequest");
		assertEquals(al.get(0).contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue(),model.getGame().getGameId());
		assertEquals(al.get(0).contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue(),model.getPlayer().getName());
	}
}
