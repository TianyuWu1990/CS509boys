package com.capricorn.controller;

import java.util.ArrayList;
import xml.Message;
import com.capricorn.RequestController.JoinGameRequest;
import com.capricorn.entity.Model;
import com.capricorn.mockServer.MockServer;
import com.capricorn.view.Application;
import junit.framework.TestCase;

public class TestJoinGameRequest extends TestCase{

	Model model = new Model();
	Application app = new Application(model);
	MockServer ms = new MockServer("localhost");
			
	
	public void testprocess() throws Exception{
	
		if (!Message.configure("wordsweeper.xsd")) { 
			fail ("unable to configure protocol"); 
		}
		app.setServerAccess(ms);
		JoinGameRequest req = new JoinGameRequest(model, app);
		model.getGame().setGameId("forTest");
		app.setGameNumber("123");
		app.setPlayerName("lee");
	
		req.process();
	
		ArrayList<Message> al = new ArrayList<Message>();
		al = ms.getAndClearMessages();
		assertEquals(al.get(0).contents.getFirstChild().getLocalName(),"joinGameRequest");
		assertEquals(al.get(0).contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue(),app.getGameNumber());
		assertEquals(al.get(0).contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue(),app.getPlayerName());
	
		app.setPassWord("test");
		
		req.process();
		
		ArrayList<Message> al1 = new ArrayList<Message>();
		al1 = ms.getAndClearMessages();
		assertEquals(al1.get(0).contents.getFirstChild().getAttributes().getNamedItem("password").getNodeValue(),app.getPassword());
	
	
	
	
	
	
	}
}
