package com.capricorn.reponse;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.capricorn.ResponseController.ExitGameResponse;
import com.capricorn.ResponseController.JoinGameResponse;
import com.capricorn.entity.Model;
import com.capricorn.mockServer.MockServer;
import com.capricorn.view.Application;

import xml.Message;



public class TestJoinGameResponse {
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
		app.setServerAccess(mockServer);
		
		
		
		String id="JoinGame";
		
		model.getGame().setGameId(id);
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><response id=\"someMessageID\" success=\"true\">"
				+ "<joinGameResponse gameId=\"%s\">"
				+ "</joinGameResponse></response>";
		
		xml= String.format(xml,id);
		System.out.println(xml);
		Message m = new Message(xml);
		JoinGameResponse join=new JoinGameResponse(app,model);
		assertTrue(join.process(m));
		
	}

}