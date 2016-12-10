package com.capricorn.controller;

import xml.Message;

import com.capricorn.RequestController.JoinGameRequest;
import com.capricorn.ResponseController.BoardResponse;
import com.capricorn.ResponseController.ConnectResponseController;
import com.capricorn.ResponseController.ExitGameResponse;
import com.capricorn.ResponseController.FindWordResponse;
import com.capricorn.ResponseController.JoinGameResponse;
import com.capricorn.ResponseController.LockGameResponse;
import com.capricorn.ResponseController.ResetGameResponse;
import com.capricorn.ResponseController.SampleClientMessageHandler;
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
	SampleClientMessageHandler handler = new SampleClientMessageHandler(app);
	handler.registerHandler(new BoardResponse(app, model));
	handler.registerHandler(new JoinGameResponse(app, model));
	handler.registerHandler(new ConnectResponseController(app, model));
	handler.registerHandler(new ResetGameResponse(app, model));
	handler.registerHandler(new LockGameResponse(app, model));
	handler.registerHandler(new FindWordResponse(app, model));
	handler.registerHandler(new ExitGameResponse(app, model));
	if (!sa.connect(handler)) {
		System.out.println("Unable to connect to server (" + host + "). Exiting.");
		System.exit(0);
	}
	// send an introductory connect request now that we have created (but not made visible!)
	// the GUI
	String xmlString = Message.requestHeader() + "<connectRequest/></request>";
	Message m = new Message (xmlString);
	sa.sendRequest(m);
	
	
	// at this point, we need to make app visible, otherwise we would terminate application

	
	app.setPlayerName("lee");
	app.setGameNumber("123");
	JoinGameRequest req = new JoinGameRequest(model,app);
	req.process();
	Thread.sleep(400);
	String r = app.getXmlb().getMessageInfo().getText();
	System.out.println(r);
	assertTrue(r.contains("joinGameRequest"));
	assertTrue(r.contains("joinGameResponse"));
	app.setPassWord("123");
	req.process();
	String r2 = app.getXmlb().getMessageInfo().getText();
	
	
	}
}
