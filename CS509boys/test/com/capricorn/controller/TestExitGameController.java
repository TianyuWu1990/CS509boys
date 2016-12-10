package com.capricorn.controller;

import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

import org.junit.Test;

import com.capricorn.RequestController.CreateGameRequest;
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
import com.capricorn.entity.Model;
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

			app.setServerAccess(sa);

			String xmlString = Message.requestHeader() + "<connectRequest/></request>";
			Message m = new Message (xmlString);
			sa.sendRequest(m);

			String player = "player123";
			String gameid = "1111";
			model.getPlayer().setName(player);
			model.getGame().setGameId(gameid);
			CreateGameRequest cr=new CreateGameRequest(app, model);
			cr.process();
			Thread.sleep(300);
			
			
			ExitGameRequest exitreq = new ExitGameRequest(model,app);
			exitreq.process();
			Thread.sleep(300);
			
			String r = app.getXmlb().getMessageInfo().getText();
			System.out.println(r);

			assertTrue(r.contains("exitGameRequest"));
			assertTrue(r.contains("exitGameResponse"));
						
			
			}
		

}
