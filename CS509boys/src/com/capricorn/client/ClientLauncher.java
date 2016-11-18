package com.capricorn.client;
import java.util.Scanner;

import com.capricorn.ResponseController.SampleClientMessageHandler;
import com.capricorn.model.Model;
import com.capricorn.view.Application;

import client.ServerAccess;
import xml.Message;

/** Launch command-line Client to show minimal access needs. */
public class ClientLauncher {
	
	// If requested by ClientLauncher (pass in '-server' as argument).
	public static final String serverHost = "72.249.186.243";

	/**
	 * Note that to simplify the coding of this command-client, it declares that it can throw an Exception,
	 * which is typically the failed connection to a server.
	 */
	
		// FIRST thing to do is register the protocol being used. 
		// There will be a single class protocol, we have set it as wordsweeper
		public static void main(String[] args) throws Exception {
			// FIRST thing to do is register the protocol being used. There will be a single class protocol
			// that will be defined and which everyone will use. For now, demonstrate with skeleton protocol.
			if (!Message.configure("wordsweeper.xsd")) {
				System.exit(0);
			}
			
			ServerAccess sa = new ServerAccess("localhost");
			Model model=new Model();
			Application a=new Application(model);
			sa.connect(new SampleClientMessageHandler());
			
			// send an introductory connect request 
			Message m = new Message ("<request id='l23kjlkasjldksljad'><connectRequest/></request>");
			
			sa.sendRequest(m);
			
			// await response. If we don't stop ServerAccess manually, there will be a background thread
			// the continually runs and the program will never terminate. 
			// This problem is not as noticeable in GUI-based clients.
			System.err.println("Press Return to terminate client.");
			Scanner sc = new Scanner (System.in);
			sc.nextLine();
			
			System.out.println("Client disconnected.");
			sa.disconnect();
		} 
	
		// await response. If we don't stop ServerAccess manually, there will be a background thread
		// the continually runs and the program will never terminate. 
		// This problem is not as noticeable in GUI-based clients.
//		System.err.println("Press Return to terminate client.");
//		Scanner sc = new Scanner (System.in);
//		sc.nextLine();
//		
//		System.out.println("Client disconnected.");
//		sa.disconnect();
		
	} 

