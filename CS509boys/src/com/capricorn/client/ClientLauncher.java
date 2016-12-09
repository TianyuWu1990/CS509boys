package com.capricorn.client;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

import com.capricorn.RequestController.ExitGameRequest;
import com.capricorn.ResponseController.BoardResponse;
import com.capricorn.ResponseController.ConnectResponseController;
import com.capricorn.ResponseController.ExitGameResponse;
import com.capricorn.ResponseController.FindWordResponse;
import com.capricorn.ResponseController.JoinGameResponse;
import com.capricorn.ResponseController.LockGameResponse;
import com.capricorn.ResponseController.ResetGameResponse;
import com.capricorn.ResponseController.SampleClientMessageHandler;
import com.capricorn.model.Model;
import com.capricorn.view.Application;

import xml.Message;

/** Launch command-line Client to show minimal access needs. */
public class ClientLauncher {

	
	public static final String serverHost= "cs509.frankgh.com" ;
	
	/**
	 * Note that to simplify the coding of this command-client, it declares that it can throw an Exception,
	 * which is typically the failed connection to a server.
	 */
	public static void main(String[] args) throws Exception {
		
		UIManager.setLookAndFeel(new MetalLookAndFeel());
		
		
		if (!Message.configure("wordsweeper.xsd")) {
			System.exit(0);
		}
		
		
		String host = "cs509.frankgh.com";
		if (args.length > 0 && args[0].equals("-server")) {
			host = serverHost;
		}
		
		
		Model model =Model.getInstance();
		
		Application app =Application.getInstance(model);


		
		
		SampleClientMessageHandler handler = new SampleClientMessageHandler(app);
		handler.registerHandler(new BoardResponse(app, model));
		handler.registerHandler(new JoinGameResponse(app, model));
		handler.registerHandler(new ConnectResponseController(app, model));
		handler.registerHandler(new ResetGameResponse(app, model));
		handler.registerHandler(new LockGameResponse(app, model));
		handler.registerHandler(new FindWordResponse(app, model));
		handler.registerHandler(new ExitGameResponse(app, model));

	

			
		
		ServerAccess sa = new ServerAccess(host, 11425);
		if (!sa.connect(handler)) {
			System.out.println("Unable to connect to server (" + host + "). Exiting.");
			System.exit(0);
		}
		System.out.println("Connected to " + host);

		
		
		
		app.setServerAccess(sa);
		
		String xmlString = Message.requestHeader() + "<connectRequest/></request>";
		Message m = new Message (xmlString);
		sa.sendRequest(m);
		
		
		
		app.setVisible(true);
	} 
}
