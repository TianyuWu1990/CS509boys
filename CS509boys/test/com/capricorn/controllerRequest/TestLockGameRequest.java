package com.capricorn.controllerRequest;

import java.util.ArrayList;
import junit.framework.TestCase;
import xml.Message;
import com.capricorn.RequestController.LockGameRequest;
import com.capricorn.entity.Model;
import com.capricorn.mockServer.MockServer;
import com.capricorn.view.Application;
/**
	 * @author yli14
	 * This is for test 'LockGameRequest' in controller
	 */
public class TestLockGameRequest extends TestCase{
	
	Model model = new Model();
	Application app = new Application(model);
	MockServer ms = new MockServer("localhost");
	
	/**
		 * Test Process() method in 'LockGameRequest'
		 */
	public void testprocess() throws Exception{
		
		if (!Message.configure("wordsweeper.xsd")) { 
			fail ("unable to configure protocol"); 
		}
		app.setServerAccess(ms);
		LockGameRequest req = new LockGameRequest(model, app);
		model.getPlayer().setName("lee");
		model.getGame().setGameId("fortest");
		
		req.process();
		ArrayList<Message> al = new ArrayList<Message>();
		al = ms.getAndClearMessages();
		assertEquals(al.get(0).contents.getFirstChild().getLocalName(),"lockGameRequest");
		assertEquals(al.get(0).contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue(),model.getGame().getGameId());
	}
}
