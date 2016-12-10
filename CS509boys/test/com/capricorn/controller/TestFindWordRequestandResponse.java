package com.capricorn.controller;

import java.util.ArrayList;

import xml.Message;

import com.capricorn.RequestController.FindWordRequest;
import com.capricorn.ResponseController.BoardResponse;
import com.capricorn.ResponseController.ConnectResponseController;
import com.capricorn.ResponseController.ExitGameResponse;
import com.capricorn.ResponseController.FindWordResponse;
import com.capricorn.ResponseController.JoinGameResponse;
import com.capricorn.ResponseController.LockGameResponse;
import com.capricorn.ResponseController.ResetGameResponse;
import com.capricorn.ResponseController.SampleClientMessageHandler;
import com.capricorn.client.ServerAccess;
import com.capricorn.entity.Cell;
import com.capricorn.entity.Coordinate;
import com.capricorn.entity.Model;
import com.capricorn.view.Application;
import com.capricorn.view.MultiGame;

import junit.framework.TestCase;

public class TestFindWordRequestandResponse extends TestCase {
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
					
					
					// at this point, we need to make app visible, otherwise we would terminate application
					app.setVisible(true);
				

		String playername = "playername";
		String gameid = "gameid";
		model.getPlayer().setName(playername);
		model.getBoard().getWord().setContent("fortest");
		model.getGame().setGameId(gameid);
		FindWordRequest req = new FindWordRequest(model,app);
		
		ArrayList<Cell> chosenCells = new ArrayList<Cell>();
		Cell c1=new Cell();
		Cell c2=new Cell();
		Cell c3=new Cell();
		c1.setLetter("a");
		c1.setGlobalCoordinate(new Coordinate(2,1));
		c2.setLetter("d");
		c2.setGlobalCoordinate(new Coordinate(3,1));
		c3.setLetter("d");
		c3.setGlobalCoordinate(new Coordinate(4,1));
		
		chosenCells.add(c1);
		chosenCells.add(c2);
		chosenCells.add(c3);
		model.getBoard().setChosenCells(chosenCells);
		req.process();
		Thread.sleep(300);
		String r = app.getXmlb().getMessageInfo().getText();
		//problem here
		assertTrue(r.contains("findWordRequest"));
		assertTrue(r.contains("findWordResponse"));
		
		
		System.out.println(r);
	}
}
