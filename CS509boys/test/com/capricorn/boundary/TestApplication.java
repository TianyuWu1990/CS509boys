package com.capricorn.boundary;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.capricorn.entity.Model;
import com.capricorn.mockServer.MockServer;
import com.capricorn.view.Application;

import junit.framework.TestCase;
import xml.Message;
/**Testcase for application*/
public class TestApplication extends TestCase{
		/**Test the process() in application */
	public void testApplication() throws Exception{
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
	app.btnJoin.doClick();
	app.btnStart.doClick();
	app.setStartGame(false);
	app.btnPractice.doClick();
	
	
	
	assertFalse(app.notHasPlayerName());
	assertFalse(app.notHasPlayerNameAndGameId());
	
	
	
	
	
	
	
	}
	public void testApplication2() throws Exception{
		
			MockServer mockServer = new MockServer("localhost");
			Model model = new Model();
			
			if (!Message.configure("wordsweeper.xsd")) {
				fail("unable to configure protocol");
			}
			Application app = new Application(model);
			app.setServerAccess(mockServer);
			
			
			app.create_id_text.setText("");
			app.name_id_text.setText("");
			app.setStartGame(false);
			app.btnPractice.doClick();
			app.setStartGame(true);
			app.btnPractice.doClick();
			app.btnJoin.doClick();
			app.btnStart.doClick();
			app.btnJoin.doClick();
			app.btnStart.doClick();
				
			
			assertTrue(app.notHasPlayerName());
			assertTrue(app.notHasPlayerNameAndGameId());
			
		
		
	}
	}


