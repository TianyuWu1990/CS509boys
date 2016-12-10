package com.capricorn.controller;


import com.capricorn.RequestController.CreateGameRequest;

import com.capricorn.RequestController.JoinGameRequest;
import com.capricorn.RequestController.ResetGameRequest;
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

public class TestResetGameRequestandResponse extends TestCase {
	
	
		

	
	
public void testprocess() throws Exception{
	
	// If requested by ClientLauncher (pass in '-server' as argument).
			
			/**
			 * Note that to simplify the coding of this command-client, it declares that it can throw an Exception,
			 * which is typically the failed connection to a server.
			 */

				
				// FIRST thing to do is register the protocol being used. There will be a single class protocol
				// that will be defined and which everyone will use. For now, demonstrate with skeleton protocol.
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
				

	String player = "player";
	String gameid = "gameid";
	
	model.getPlayer().setName(player);
	model.getPlayer().setScore(100);
	model.getGame().setGameId(gameid);
	
	
	app.playerName="lee";

	app.setMg(new MultiGame(model, app));
//	JoinGameRequest jgr=new JoinGameRequest(model,app);
	CreateGameRequest create = new CreateGameRequest(app,model);
	create.process();
	String r = app.getXmlb().getMessageInfo().getText();
	

	assertTrue(r.contains("createGameRequest"));
	Thread.sleep(500);
	String  s= app.getXmlb().getMessageInfo().getText();
	assertTrue(s.contains("boardResponse"));
	assertEquals(model.getPlayer().getName(),"lee");
	assertEquals(model.getGame().getManagingUser(),"lee");

	app.setMg(new MultiGame(model, app));
	JoinGameRequest jgr=new JoinGameRequest(model,app);
	jgr.process();
	Thread.sleep(300);;

	ResetGameRequest req = new ResetGameRequest(model,app);
	req.process();

	Thread.sleep(300);
	String ss = app.getXmlb().getMessageInfo().getText();
	System.out.println(ss);

	
	Thread.sleep(300);
	
	//?problem tested

	assertEquals(model.getPlayer().getScore(),0);
	assertTrue(ss.contains("resetGameRequest"));
	assertTrue(ss.contains("boardResponse"));
//	assertEquals(model.getPlayer().getScore(),0);
//	System.out.println(r);
//	 m = clientResponseHandler.responses.remove(0); 
//	<?xml version="1.0" encoding="UTF-8"?><request id="05eb8cd7-bdea-41c9-8195-aa48bf5696df" version="1.0"><resetGameRequest gameId="gameid"/></request>
//	ResetGameResponse res = new ResetGameResponse(app,model);
	
//	res.process(r);
	
	

	
	
	
}

}
