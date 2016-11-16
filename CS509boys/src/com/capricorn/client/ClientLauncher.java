package com.capricorn.client;
import java.util.Scanner;

import javax.swing.JFrame;

import com.capricorn.view.StartPage;

import client.ServerAccess;


import com.capricorn.controller.CreateGameController;
import xml.Message;

import com.capricorn.controller.ConnectResponseController;
import com.capricorn.model.Model;

/** Launch command-line Client to show minimal access needs. */
public class ClientLauncher {
	
	// If requested by ClientLauncher (pass in '-server' as argument).
	public static final String serverHost = "72.249.186.243";

	/**
	 * Note that to simplify the coding of this command-client, it declares that it can throw an Exception,
	 * which is typically the failed connection to a server.
	 */
	public static void main(String[] args) throws Exception {
		// FIRST thing to do is register the protocol being used. 
		// There will be a single class protocol, we have set it as wordsweeper
		if (!Message.configure("wordsweeper.xsd")) {
			System.exit(0);
		}
		
		// select dedicated server with '-server' options
		String host = "localhost";
		
		if (args.length > 0 && args[0].equals("-server")) {
			host = serverHost;
		}
		
		//initiate model
		Model model=new Model();
		StartPage page = new StartPage(model);
		
		// set up the chain of responsibility
		SampleClientMessageHandler handler = new SampleClientMessageHandler(page);
		handler.registerHandler(new BoardResponseController(page, model));
		handler.registerHandler(new ConnectResponseController(page, model));
		handler.registerHandler(new CreateGameController(page,model));		// new added
		
				
		// try to connect to the server. Once connected, messages are going to be processed by 
		// SampleClientMessageHandler. For now we just continue on with the initialization because
		// no message is actually sent by the connect method.
		ServerAccess sa = new ServerAccess(host, 11425);
		if (!sa.connect(handler)) {
			System.out.println("Unable to connect to server (" + host + "). Exiting.");
			System.exit(0);
		}
		System.out.println("Connected to " + host);
		
		// Should we on the client ever need to communicate with the server, we need this ServerAccess
		// object.
		page.setServerAccess(sa);
		
		// send an introductory connect request now that we have created (but not made visible!)
		// the GUI
		String xmlString = Message.requestHeader() + "<connectRequest/></request>";	//"<request id='l23kjlkasjldksljad'><connectRequest/></request>"
		Message m = new Message (xmlString);	
		sa.sendRequest(m);
		
		page.setVisible(true);
		

		
		// await response. If we don't stop ServerAccess manually, there will be a background thread
		// the continually runs and the program will never terminate. 
		// This problem is not as noticeable in GUI-based clients.
		System.err.println("Press Return to terminate client.");
		Scanner sc = new Scanner (System.in);
		sc.nextLine();
		
		System.out.println("Client disconnected.");
		sa.disconnect();
	} 
}
