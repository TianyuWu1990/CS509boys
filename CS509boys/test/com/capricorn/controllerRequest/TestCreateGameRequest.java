package com.capricorn.controllerRequest;

import java.util.ArrayList;
import xml.Message;
import com.capricorn.RequestController.CreateGameRequest;
import com.capricorn.entity.Model;
import com.capricorn.mockServer.MockServer;
import com.capricorn.view.Application;
import junit.framework.TestCase;

public class TestCreateGameRequest extends TestCase{
/**
 * @author yli14
 * This is for test 'CreateGameRequest' in controller
 */
	Model model = new Model();
	Application app = new Application(model);
	MockServer ms = new MockServer("localhost");
	
	
	public void testprocess() throws Exception{
		/**
		 * Test Process() method in 'CreateGameRequest'
		 */
		
		if (!Message.configure("wordsweeper.xsd")) { 
			fail ("unable to configure protocol"); 
		}
		app.setServerAccess(ms);
		CreateGameRequest req = new CreateGameRequest(app, model);
		app.setPlayerName("lee");
		
		req.process();
		ArrayList<Message> al = new ArrayList<Message>();
		al = ms.getAndClearMessages();
		
		assertEquals(al.get(0).contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue(),app.getPlayerName());
		
		app.setPlayerName("yu");
		app.setPassWord("test");
		req.process();
		al = ms.getAndClearMessages();
		assertEquals(al.get(0).contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue(),app.getPlayerName());
		assertEquals(al.get(0).contents.getFirstChild().getAttributes().getNamedItem("password").getNodeValue(),app.getPassword());
		
}
}
