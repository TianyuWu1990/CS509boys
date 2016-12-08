package com.capricorn.controller;

import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

import org.junit.Test;

import com.capricorn.RequestController.ExitGameRequest;
import com.capricorn.ResponseController.BoardResponse;
import com.capricorn.ResponseController.ConnectResponseController;
import com.capricorn.ResponseController.ExitGameResponse;
import com.capricorn.ResponseController.FindWordResponse;
import com.capricorn.ResponseController.JoinGameResponse;
import com.capricorn.ResponseController.LockGameResponse;
import com.capricorn.ResponseController.ResetGameResponse;
import com.capricorn.ResponseController.SampleClientMessageHandler;
import com.capricorn.client.ServerAccess;
import com.capricorn.model.Model;
import com.capricorn.view.Application;

import junit.framework.TestCase;
import xml.*;

public class TestExitGameController extends TestCase {
//	String host = "cs509.frankgh.com";
//	ServerAccess sa = new ServerAccess(host, 11425);
//	
	
	
//	public void set()
//	{
//		// FIRST thing to do is register the protocol being used.
//		if (!Message.configure("wordsweeper.xsd")) {
//			fail ("unable to configure protocol");
//		}
//		app.setVisible(true);
//		app.setServerAccess(sa);
//	}



		
		public void TestExitGameProcess() {
			
			
			
			

	}
		
		public void testRegister() throws Exception {
			UIManager.setLookAndFeel(new MetalLookAndFeel());
			
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

//			ServerAccess serverAccess = new ServerAccess("cs509.frankgh.com");

				
			// try to connect to the server. Once connected, messages are going to be processed by 
			// SampleClientMessageHandler. For now we just continue on with the initialization because
			// no message is actually sent by the connect method.
			ServerAccess sa = new ServerAccess(host, 11425);
			//System.out.println("Connected to " + host);
//			7b3l9duv86ed5mat9vfronf5s9
			
			
			// Should we on the client ever need to communicate with the server, we need this ServerAccess
			// object.
			app.setServerAccess(sa);
			// send an introductory connect request now that we have created (but not made visible!)
			// the GUI
			String xmlString = Message.requestHeader() + "<connectRequest/></request>";
			Message m = new Message (xmlString);
			sa.sendRequest(m);
			
			
			// at this point, we need to make app visible, otherwise we would terminate application
			//app.setVisible(true);
		
			String player = "player";
			String gameid = "1111";
			model.getPlayer().setName(player);
			model.getGame().setGameId(gameid);
			
			
			
			ExitGameRequest exitreq = new ExitGameRequest(model,app);
			exitreq.process();
			
			String r = app.getXmlb().getMessageInfo().getText();
			
			System.out.println(r);
			
			
			}
		

}
