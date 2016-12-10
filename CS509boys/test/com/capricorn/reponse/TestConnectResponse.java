package com.capricorn.reponse;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capricorn.ResponseController.ConnectResponseController;
import com.capricorn.entity.Model;
import com.capricorn.mockServer.MockServer;
import com.capricorn.view.Application;

import xml.Message;

public class TestConnectResponse {

	Model model = new Model();
	Application app = new Application(model);
	MockServer mockServer = new MockServer("localhost");
	
	@Test
	public void TestConnectRespnse1(){
		if (!Message.configure("wordsweeper.xsd")) {
			fail("unable to configure protocol");
		}
		app.setServerAccess(mockServer);
		
		
		
			/**this is the test for connect response process*/
			String xml= "<?xml version=\"1.0\" encoding=\"UTF-8\"?><response id=\"someMessageID\" success=\"true\">"
			    + "<connectResponse id=\"game1\">"
			    +"</connectResponse></response>";
			xml =String.format(xml);
			Message m = new Message(xml);
			ConnectResponseController crc=new ConnectResponseController(app,model);
			assertTrue(crc.process(m));
		
		
	}
}
