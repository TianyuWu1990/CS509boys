package com.capricorn.controllerReponse;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capricorn.ResponseController.ConnectResponseController;
import com.capricorn.ResponseController.ExitGameResponse;
import com.capricorn.ResponseController.SampleClientMessageHandler;
import com.capricorn.entity.Model;
import com.capricorn.mockServer.MockServer;
import com.capricorn.view.Application;

import xml.Message;

public class TestConnectResponse {
/** Test for the 'Connect response' in the controller
 *  @author Bowen Sun, Chen Li
 */
	Model model = new Model();
	Application app = new Application(model);
	MockServer mockServer = new MockServer("localhost");
	/**test the process in the 'Connect response' controller*/
	@Test
	public void TestConnectRespnse1(){
		if (!Message.configure("wordsweeper.xsd")) {
			fail("unable to configure protocol");
		}
		app.setServerAccess(mockServer);
		
		
		String id="Exitgame";
	
		
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><response id=\"someMessageID\" success=\"true\">"
				+ "<exitGameResponse gameId=\"%s\">"
				+ "</exitGameResponse></response>";
		
		xml= String.format(xml,id);
		System.out.println(xml);
		Message m = new Message(xml);
		
		
		
			/**this is the test for connect response process*/
			String xml2= "<?xml version=\"1.0\" encoding=\"UTF-8\"?><response id=\"someMessageID\" success=\"true\">"
			    + "<connectResponse id=\"game1\">"
			    +"</connectResponse></response>";
			xml2 =String.format(xml2);
			Message n = new Message(xml2);
			ConnectResponseController crc=new ConnectResponseController(app,model);
			
			
			SampleClientMessageHandler handler = new SampleClientMessageHandler(app);
			
			
			handler.registerHandler(crc);
			assertTrue(crc.process(n));
			assertTrue(crc.process(m));
		
	}
}
