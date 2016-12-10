package com.capricorn.reponse;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.capricorn.ResponseController.FindWordResponse;
import com.capricorn.entity.Model;
import com.capricorn.mockServer.MockServer;
import com.capricorn.view.Application;
import com.capricorn.view.MultiGame;

import xml.Message;

public class TestFindWordResponseController {
	/**@author Ruochen Shi; 
	 * This is responsible for testing "Find Word Response" Controller*/
	Model model = new Model();
	Application app = new Application(model);
	MockServer mockServer = new MockServer("localhost");


	

	@Test
	public void TestFindWordResponseProcess(){
		app.setMg(new MultiGame(model, app));
		
		if (!Message.configure("wordsweeper.xsd")) {
			fail("unable to configure protocol");
		}
		app.setVisible(true);
		app.setServerAccess(mockServer);
		/**this is responsible for testing the process of "Find Word Response" controller*/
		String gameID="game";
		String name="player";
		int score= 5000;
		
		String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?><response id=\"someMessageID\" success=\"true\">"
		           + "<findWordResponse gameId=\"%s\" name=\"%s\" score=\"%d\"/></response>";
		xml=String.format(xml,gameID,name,score);
		Message m = new Message(xml);
		
		model.getGame().setGameId(gameID);
		model.getPlayer().setName(name);
		model.getPlayer().setScore(0);
		
		FindWordResponse fwr=new FindWordResponse(app,model);
		assertTrue(fwr.process(m));
		fwr.process(m);
	}
}
//end of TestFindWordResponseController
