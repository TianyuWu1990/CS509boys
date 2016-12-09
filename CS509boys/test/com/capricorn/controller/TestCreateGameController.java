package com.capricorn.controller;

import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

import com.capricorn.RequestController.CreateGameRequest;
import com.capricorn.RequestController.ExitGameRequest;
import com.capricorn.client.ServerAccess;
import com.capricorn.entity.Model;
import com.capricorn.view.Application;

import junit.framework.TestCase;
import xml.Message;

public class TestCreateGameController extends TestCase{
	
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
		model.getPlayer().setName(player);

		CreateGameRequest create = new CreateGameRequest(app,model);
		create.process();
		
		String r = app.getXmlb().getMessageInfo().getText();

		assertTrue(r.contains("createGameRequest"));

		
		}

}
