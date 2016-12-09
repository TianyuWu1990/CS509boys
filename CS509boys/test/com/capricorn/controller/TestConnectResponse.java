package com.capricorn.controller;

import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

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
import xml.Message;

public class TestConnectResponse extends TestCase {
	

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
	


		String xmlString = Message.requestHeader() + "<connectRequest/></request>";
		Message m = new Message (xmlString);
		sa.sendRequest(m);
		Thread.sleep(300);
		String r = app.getXmlb().getMessageInfo().getText();
		assertTrue(r.contains("connectResponse"));


}
}
