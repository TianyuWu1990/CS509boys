package com.capricorn.boundary;

import javax.swing.JButton;
import javax.swing.JTextField;

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
	
	
	app.create_id_text.setText("game123");
	app.name_id_text.setText("lee");
	app.btnPractice.doClick();
	app.setStartGame(true);
	app.btnPractice.doClick();
	app.btnJoin.doClick();
	app.btnStart.doClick();
	
	
	assertFalse(app.notHasPlayerName());
	assertFalse(app.notHasPlayerNameAndGameId());
	
	
	
	
	
	
	
	}
}

