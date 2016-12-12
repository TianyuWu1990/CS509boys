package com.capricorn.controllerReponse;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.capricorn.ResponseController.ControllerChain;
import com.capricorn.ResponseController.EmptyHandler;
import com.capricorn.ResponseController.SampleClientMessageHandler;
import com.capricorn.entity.Model;
import com.capricorn.mockServer.MockServer;
import com.capricorn.view.Application;
import com.capricorn.view.MultiGame;

import xml.Message;

public class TestAbstractClass {
	
	Model model=new Model();
Application app=new Application(model);
MockServer mockServer=new MockServer("localhost");
	
	@Test
	
	public void testConSampleMessagehandler(){
		
		//app.setMg(new MultiGame(model, app));
		/**this is the setting for the test*/
		// FIRST thing to do is register the protocol being used.
		if (!Message.configure("wordsweeper.xsd")) {
			fail("unable to configure protocol");
		}
		app.setServerAccess(mockServer);
		/**this is the test for connect response process part 2*/
		String xml2= "<?xml version=\"1.0\" encoding=\"UTF-8\"?><response id=\"someMessageID\" success=\"true\">"
		    + "<connectResponse id=\"game1\">"
		    +"</connectResponse></response>";
		xml2 =String.format(xml2);
		Message n = new Message(xml2);
		SampleClientMessageHandler s =new SampleClientMessageHandler(app);
		s.process(n);
		
		
		
			}
	
}
