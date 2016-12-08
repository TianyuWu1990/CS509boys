package com.capricorn.controller;

import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

import xml.Message;
import junit.framework.TestCase;

import com.capricorn.RequestController.ExitGameRequest;
import com.capricorn.RequestController.ResetGameRequest;
import com.capricorn.ResponseController.*;
import com.capricorn.client.ServerAccess;
import com.capricorn.model.Model;
import com.capricorn.view.Application;

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
				// send an introductory connect request now that we have created (but not made visible!)
				// the GUI
				String xmlString = Message.requestHeader() + "<connectRequest/></request>";
				Message m = new Message (xmlString);
				sa.sendRequest(m);
				
				
				// at this point, we need to make app visible, otherwise we would terminate application
				app.setVisible(true);

	String player = "player";
	String gameid = "gameid";
	
	model.getPlayer().setName(player);
	model.getPlayer().setScore(100);
	model.getGame().setGameId(gameid);
	
	
	
	
	
	ResetGameRequest req = new ResetGameRequest(model,app);
	req.process();
	String r = app.getXmlb().getMessageInfo().getText();
	assertTrue(r.contains("resetGameRequest"));
	System.out.println(r);
//	 m = clientResponseHandler.responses.remove(0); 
//	<?xml version="1.0" encoding="UTF-8"?><request id="05eb8cd7-bdea-41c9-8195-aa48bf5696df" version="1.0"><resetGameRequest gameId="gameid"/></request>
//	ResetGameResponse res = new ResetGameResponse(app,model);
	
//	res.process(r);
	
	

	
	
	
}

}
