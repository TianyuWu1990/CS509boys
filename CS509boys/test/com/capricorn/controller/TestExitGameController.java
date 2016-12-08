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

		
		public void testRegister() throws Exception {
			UIManager.setLookAndFeel(new MetalLookAndFeel());

			if (!Message.configure("wordsweeper.xsd")) {
				System.exit(0);
			}
			
			// select dedicated server with '-server' options
			String host = "cs509.frankgh.com";

			Model model =Model.getInstance();
			
			Application app =Application.getInstance(model);

			ServerAccess sa = new ServerAccess(host, 11425);

			app.setServerAccess(sa);

			String xmlString = Message.requestHeader() + "<connectRequest/></request>";
			Message m = new Message (xmlString);
			sa.sendRequest(m);

			String player = "player123";
			String gameid = "1111";
			model.getPlayer().setName(player);
			model.getGame().setGameId(gameid);
			
			
			
			ExitGameRequest exitreq = new ExitGameRequest(model,app);
			exitreq.process();
			
			String r = app.getXmlb().getMessageInfo().getText();

			assertTrue(r.contains("exitGameRequest"));
						
			
			}
		

}
