package com.capricorn.controller;

import xml.Message;

import com.capricorn.RequestController.JoinGameRequest;
import com.capricorn.client.ServerAccess;
import com.capricorn.entity.Model;
import com.capricorn.view.Application;

import junit.framework.TestCase;

public class TestJoinGameandResponse extends TestCase {
	public void testprocess() throws Exception{
	if (!Message.configure("wordsweeper.xsd")) {
		System.exit(0);
	}
	
	// select dedicated server with '-server' options
	String host = "cs509.frankgh.com";
	
	// Initialize the client application and its corresponding model
	Model model =Model.getInstance();
	
	Application app =Application.getInstance(model);

	// try to connect to the server. Once connected, messages are going to be processed by 
	// SampleClientMessageHandler. For now we just continue on with the initialization because
	// no message is actually sent by the connect method.
	ServerAccess sa = new ServerAccess(host, 11425);
	
	System.out.println("Connected to " + host);

	app.setServerAccess(sa);
	// send an introductory connect request now that we have created (but not made visible!)
	// the GUI
	String xmlString = Message.requestHeader() + "<connectRequest/></request>";
	Message m = new Message (xmlString);
	sa.sendRequest(m);
	
	
	// at this point, we need to make app visible, otherwise we would terminate application
	app.setVisible(true);
	
	
	app.setGameNumber("123");
	JoinGameRequest req = new JoinGameRequest(model,app);
	req.process();
	String r = app.getXmlb().getMessageInfo().getText();
	assertTrue(r.contains("joinGameRequest"));
	System.out.println(r);
	}
}
