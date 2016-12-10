package com.capricorn.controller;

import com.capricorn.RequestController.LockGameRequest;
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
import com.capricorn.view.MultiGame;

import junit.framework.TestCase;
import xml.Message;

public class TestLockGameRequestandResponse extends TestCase {

	
	public void testLockGameProcess(){
		if (!Message.configure("wordsweeper.xsd")) {
			System.exit(0);
		}
		
		// select dedicated server with '-server' options
		String host = "cs509.frankgh.com";
		
		// Initialize the client app1lication and its corresponding model1
		Model model =Model.getInstance();
		
		Application app =Application.getInstance(model);
       app.setMg(new MultiGame(model, app));
		// try to connect to the server. Once connected, messages are going to be processed by 
		// SampleClientMessageHandler. For now we just continue on with the initialization because
		// no message is actually sent by the connect method.
		ServerAccess sa = new ServerAccess(host, 11425);
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
		
		System.out.println("Connected to " + host);

		app.setServerAccess(sa);
		
		// send an introductory connect request now that we have created (but not made visible!)
		// the GUI
		String xmlString = Message.requestHeader() + "<connectRequest/></request>";
		Message m = new Message (xmlString);
		sa.sendRequest(m);
		model.getGame().setGameId("fortest");
		model.getGame().setLocked(false);
		LockGameRequest req = new LockGameRequest(model,app);
		req.process();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String r = app.getXmlb().getMessageInfo().getText();
		
		assertTrue(r.contains("lockGameRequest"));
		assertEquals(model.getGame().isLocked,true);
		
	}
}
