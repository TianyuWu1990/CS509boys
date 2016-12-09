package com.capricorn.controller;

import java.util.ArrayList;

import xml.Message;

import com.capricorn.RequestController.FindWordRequest;
import com.capricorn.client.ServerAccess;
import com.capricorn.entity.Cell;
import com.capricorn.model.Model;
import com.capricorn.view.Application;

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
				

		String playername = "playername";
		String gameid = "gameid";
		model.getPlayer().setName(playername);
		model.getBoard().getWord().setContent("fortest");
		model.getGame().setGameId(gameid);
		FindWordRequest req = new FindWordRequest(model,app);
		
		ArrayList<Cell> chosenCells = new ArrayList<Cell>();
		chosenCells.add(new Cell());
		model.getBoard().setChosenCells(chosenCells);
		req.process();
		String r = app.getXmlb().getMessageInfo().getText();
		//problem here
		assertTrue(r.contains("findWordRequest"));
		
		System.out.println(r);
	}
}
