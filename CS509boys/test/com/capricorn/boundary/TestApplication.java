package com.capricorn.boundary;

import javax.swing.JButton;

import com.capricorn.entity.Model;
import com.capricorn.mockServer.MockServer;
import com.capricorn.view.Application;

import junit.framework.TestCase;
import xml.Message;

public class TestApplication extends TestCase{
		
	public void testprocess() throws Exception{
	MockServer mockServer = new MockServer("localhost");
	Model model = new Model();
	
	if (!Message.configure("wordsweeper.xsd")) {
		fail("unable to configure protocol");
	}
	Application app = new Application(model);
	app.setServerAccess(mockServer);
	assertTrue(app.notHasPlayerName());
	assertTrue(app.notHasPlayerNameAndGameId());
	
	
	
	
	
	
	}
}

