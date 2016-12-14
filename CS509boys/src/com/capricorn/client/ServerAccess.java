package com.capricorn.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Hashtable;

import com.capricorn.ResponseController.IClientController;
import com.capricorn.ResponseController.IMessageHandler;

import xml.Message;
import xml.Parser;

// TODO: Auto-generated Javadoc
/** 
 * Responsible for all communication to/from server.
 * <p>
 * To communicate with a remote server, construct a ServerAccess object (using 
 * the default port or one of your own specification) and invoke the 
 * {@link #connect(IMessageHandler)} method. Once connected, you can send a message
 * request to the server through the {@link #sendRequest(Message)} message. All 
 * responses to these requests from the server are processed by a 
 * {@link IMessageHandler} object. 
 */
public class ServerAccess {
	
	/** The host. */
	String host = null;            
	
	/** The server. */
	Socket server;                 
	
	/** The from buffer. */
	BufferedReader fromBuffer;    
	
	/** The to server. */
	PrintWriter toServer;          
	
	/** The server port. */
	final int serverPort;         

	/** The is active. */
	boolean isActive = false;      
	
	/** The Constant defaultPort. */
	static final int defaultPort = 21425;  

	
	
	/** The pending. */
	Hashtable<String,Tuple> pending = new Hashtable<String,Tuple>();   

	/**
	 * The Class Tuple.
	 */
	class Tuple {
		
		/** The controller. */
		IClientController  controller;
		
		/** The request. */
		Message      request;
		
		/** The id. */
		String       id;

		/**
		 * Instantiates a new tuple.
		 *
		 * @param c the c
		 * @param r the r
		 * @param i the i
		 */
		Tuple (IClientController c, Message r, String i) {
			controller = c;
			request = r;
			id = i;
		}
	}

	/**
	 *  Construct ServerAccess object to use default port number.
	 *
	 * @param host the host
	 */
	public ServerAccess(String host) {
		this(host, defaultPort);
	}
	

	/**
	 * Construct ServerAccess object using specified port number.
	 *
	 * @param host the host
	 * @param port the port
	 */
	public ServerAccess(String host, int port) {
		this.host = host;
		serverPort = port;
	}
	
	/**
	 *  
	 * Start up reader and talker threads. Returns false if unable to contact server.
	 * When server messages are received, they are handled by the given handler object.
	 *
	 * @param handler the handler
	 * @return true, if successful
	 */
	public boolean connect(final IMessageHandler handler) {
		try {
			server = new Socket (host, serverPort);
			toServer = new PrintWriter (server.getOutputStream(), true);
		} catch (Exception e) {
			System.err.println("Unable to connect to server: " + e.getMessage());
			return false;
		}

		
		isActive = true;
		new FromServer(handler).start();
		return true;
	}

	/** Request to disconnect from server (internal or external). */
	public void disconnect() {
		if (!isActive) { return; } 
		isActive = false;

		pending.clear(); 

		try {
			
			server.close();
			toServer = null;
			server = null;
		} catch (IOException e) {
			System.err.println("Unable to closer server:" + e.getMessage());
		}
	}

	/**
	 *  Send request to the server. Return success or failure
	 *
	 * @param r is the message that should be transmitted in
	 * @return true, if successful
	 */
	public synchronized boolean sendRequest(Message r) {
		if (!isActive) { return false; }

		toServer.println(r);
		
		return !toServer.checkError();
	}

	/**
	 * Send request to the server and register controller to process response
	 * only on success. Return success or failure of operation. 
	 * <p>
	 * The given IController object is going to be responsible for processing the
	 * response that comes back.
	 *
	 * @param c is the IClientController
	 * @param m is the message
	 * @return true, if successful
	 */
	public synchronized boolean sendRequest(IClientController c, Message m) {
		if (!isActive) { return false; }

		toServer.println(m);
		boolean success = !toServer.checkError();
		if (success) {
			pending.put(m.id(), new Tuple(c, m, m.id()));
		}
		return success;
	}

	/**
	 *  Useful method for extracting key information in error messages.
	 *
	 * @return the string
	 */
	public String toString () {
		return "Connected to:" + host; 
	}

	/**
	 * Thread to receive Responses back from Server. This inner class has access to attributes defined
	 * in the enclosing ServerAccess class.
	 */
	class FromServer extends Thread {
		/** Every message is handled by this message handler. */
		IMessageHandler handler;

		/**
		 * Instantiates a new from server.
		 *
		 * @param handler the handler
		 */
		FromServer(IMessageHandler handler) {
			this.handler = handler;
		}

		/* (non-Javadoc)
		 * @see java.lang.Thread#run()
		 */
		public void run() {
			try {
				fromBuffer = new BufferedReader (new InputStreamReader(server.getInputStream()));

				while (isActive) {
					Message m = Parser.extractResponse(fromBuffer);
					if (m == null) {
						disconnect();
						break;
					}

					try {
						Tuple p = pending.remove(m.id()); 
						if (p != null) {
							p.controller.process(p.request);
						} else {
							handler.process (m);
						}
					} catch (Exception e) {
						System.err.println("Error processing:" + m.toString());
						e.printStackTrace();
					}
				}

			} catch (IOException ioe) {
				ioe.printStackTrace();
				isActive = false;
			}  

			fromBuffer = null;
		}
	}

	/**
	 *  Determines whether there are any controllers waiting on a response.
	 *
	 * @return true, if is waiting
	 */
	public synchronized boolean isWaiting() {
		return (!pending.isEmpty());
	}

	/**
	 *  Utility method to return host to which ServerAccess connected.
	 *
	 * @return the host
	 */
	public String getHost() {
		return host;
	}
	


}
