package com.capricorn.controllerReponse;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.capricorn.ResponseController.BoardResponse;
import com.capricorn.ResponseController.ConnectResponseController;
import com.capricorn.ResponseController.ExitGameResponse;
import com.capricorn.ResponseController.FindWordResponse;
import com.capricorn.ResponseController.JoinGameResponse;
import com.capricorn.ResponseController.LockGameResponse;
import com.capricorn.ResponseController.ResetGameResponse;
import com.capricorn.ResponseController.SampleClientMessageHandler;
import com.capricorn.entity.Model;
import com.capricorn.mockServer.MockServer;
import com.capricorn.view.Application;

import xml.Message;


/**@author Bowen Sun, Chen Li 
 * This is the test for 'Join Game Response' in Controller*/
public class TestJoinGameResponse {
	

	Model model=new Model();
	Application app=new Application(model);
	MockServer mockServer=new MockServer("localhost");
	
	
	
	
		
	
/** Test the process in 'Join Game Response'*/
	@Test
	public void TestExitGameProcess(){
		
		
	
		if (!Message.configure("wordsweeper.xsd")) {
			fail ("unable to configure protocol");
		}
		app.setVisible(true);
		app.setServerAccess(mockServer);
		
		
		
		String id="JoinGame";
		
		model.getGame().setGameId(id);
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><response id=\"someMessageID\" success=\"true\">"
				+ "<joinGameResponse gameId=\"%s\">"
				+ "</joinGameResponse></response>";
		
		xml= String.format(xml,id);
		Message m = new Message(xml);
		
		/**this is the test for connect response process part 2*/
		String xml2= "<?xml version=\"1.0\" encoding=\"UTF-8\"?><response id=\"someMessageID\" success=\"true\">"
		    + "<connectResponse id=\"game1\">"
		    +"</connectResponse></response>";
		xml2 =String.format(xml2);
		Message n = new Message(xml2);
		
		
		JoinGameResponse join=new JoinGameResponse(app,model);
		SampleClientMessageHandler handler = new SampleClientMessageHandler(app);
		
		
		handler.registerHandler(join);
		//handler.registerHandler(new BoardResponse(app, model));
		//handler.registerHandler(new ResetGameResponse(app, model));
		//handler.registerHandler(new LockGameResponse(app, model));
		//handler.registerHandler(new FindWordResponse(app, model));
		//handler.registerHandler(new ExitGameResponse(app, model));
		//handler.registerHandler(new ConnectResponseController(app, model));
		assertTrue(join.process(m));
		assertTrue(join.process(n));
		
	}

}