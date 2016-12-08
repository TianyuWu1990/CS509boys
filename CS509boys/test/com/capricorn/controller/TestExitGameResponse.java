package com.capricorn.controller;

import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

import com.capricorn.RequestController.ExitGameRequest;
import com.capricorn.ResponseController.ExitGameResponse;
import com.capricorn.client.ServerAccess;
import com.capricorn.model.Model;
import com.capricorn.view.Application;

import junit.framework.TestCase;
import xml.Message;

public class TestExitGameResponse extends TestCase {
	Model model = new Model();
	Application app = new Application(model);
	ServerAccess sa=new ServerAccess("localhost");
	
	public void set()
	{
		// FIRST thing to do is register the protocol being used.
		if (!Message.configure("wordsweeper.xsd")) {
			fail ("unable to configure protocol");
		}
		app.setVisible(true);
		app.setServerAccess(sa);
	}




		public void TestExitGameProcess() {
			
			
			
			String player = "player";
			String gameid = "gameid";
			model.getPlayer().setName(player);
			model.getGame().setGameId(gameid);
			
			
			
			ExitGameRequest exitreq = new ExitGameRequest(model,app);
			exitreq.process();
			
			String r = app.getXmlb().getMessageInfo().getText();
			
			System.out.println(r);
			//assertEquals(1,1);

	}
		

}
