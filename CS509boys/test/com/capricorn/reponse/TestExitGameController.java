package com.capricorn.reponse;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.capricorn.ResponseController.ExitGameResponse;
import com.capricorn.entity.Model;
import com.capricorn.mockServer.MockServer;
import com.capricorn.view.Application;

import xml.Message;



public class TestExitGameController {
	/**@author Ruochen Shi; 
	 * This is responsible for testing "Exit Game" Controller*/

	Model model=new Model();
	Application app=new Application(model);
	MockServer mockServer=new MockServer("localhost");
	
	
	
	
		/**this is the setting for the test*/
		// FIRST thing to do is register the protocol being used.
		
	

	@Test
	public void TestExitGameProcess(){
		
	
		if (!Message.configure("wordsweeper.xsd")) {
			fail ("unable to configure protocol");
		}
		app.setVisible(true);
		app.setServerAccess(mockServer);
		
		
		String name="Player";
		String id="Exitgame";
		model.getPlayer().setName(name);
		model.getGame().setGameId(id);
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><response id=\"someMessageID\" success=\"true\">"
				+ "<exitGameResponse gameId=\"%s\">"
				+ "</exitGameResponse></response>";
		
		xml= String.format(xml,id);
		System.out.println(xml);
		Message m = new Message(xml);
		ExitGameResponse egrc=new ExitGameResponse(app,model);
		assertTrue(egrc.process(m));
	}

}