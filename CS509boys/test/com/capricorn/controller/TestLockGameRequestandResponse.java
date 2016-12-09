package com.capricorn.controller;

import xml.Message;
import com.capricorn.RequestController.LockGameRequest;
import com.capricorn.client.ServerAccess;
import com.capricorn.model.Model;
import com.capricorn.view.Application;
import junit.framework.TestCase;

public class TestLockGameRequestandResponse extends TestCase {

	
	public void testLockGameProcess(){
		if (!Message.configure("wordsweeper.xsd")) {
			System.exit(0);
		}
		
		// select dedicated server with '-server' options
		String host = "cs509.frankgh.com";
		
		// Initialize the client app1lication and its corresponding model1
		Model model1 =Model.getInstance();
		
		Application app1 =Application.getInstance(model1);

		// try to connect to the server. Once connected, messages are going to be processed by 
		// SampleClientMessageHandler. For now we just continue on with the initialization because
		// no message is actually sent by the connect method.
		ServerAccess sa = new ServerAccess(host, 11425);
		
		System.out.println("Connected to " + host);

		app1.setServerAccess(sa);
		app1.setVisible(true);
		// send an introductory connect request now that we have created (but not made visible!)
		// the GUI
		String xmlString = Message.requestHeader() + "<connectRequest/></request>";
		Message m = new Message (xmlString);
		sa.sendRequest(m);
		model1.getGame().setGameId("fortest");
		model1.getGame().setLocked(false);
		LockGameRequest req = new LockGameRequest(model1,app1);
		req.process();
		String r = app1.getXmlb().getMessageInfo().getText();
		assertTrue(r.contains("lockGameRequest"));
		assertEquals(model1.getGame().isLocked,true);
		
	}
}
