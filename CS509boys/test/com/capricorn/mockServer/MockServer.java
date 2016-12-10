package com.capricorn.mockServer;



import java.util.ArrayList;
import java.util.Hashtable;

import com.capricorn.ResponseController.IMessageHandler;
import com.capricorn.client.ServerAccess;

import xml.Message;


/**
 * Mock Server Access replaces the entire functionality of the ServerAccess
 * class and provides a "simulation of it". 
 * <p>
 * One cardinal rule regarding constructors is that the method should do as little
 * as possible; this is often violated in GUI programming. However, when it is the
 * case, note that this object states it offers the behavior but completely does
 * things without actually communicating to a server.
 * <p>
 * Use the {@link #getAndClearMessages()} and {@link #getAndClearWaitingMessages()}
 * methods to retrieve the requests that were "processed" by this mock server.
 * 
 * @author heineman
 */
public class MockServer extends ServerAccess {

	/** Sent messages. */
	ArrayList<Message> sentMessages = new ArrayList<Message>();
	
	/** Special message requests to be process. */
	Hashtable<String, Message> waiting = new Hashtable<String,Message>();
	
	public MockServer(String host) {
		super(host);
	}

	public MockServer(String host, int port) {
		super(host, port);
	}
	
	/** To simulate connect, just grab onto callback handler object. */
	@Override
	public boolean connect(final IMessageHandler handler) {
		return true;
	}
	
	/** To simulate disconnect, clear out. */
	@Override	
	public void disconnect() {
		
	}
	
	/** Mock server is true to its name. */
	public String getHost() {
		return "mockServer";
	}
	
	/** Requests are held onto so they can be inspected later. */
	public synchronized boolean sendRequest(Message r) {
		sentMessages.add(r);
		return true;
	}
	
	
	
	
	/** Get and clear sent Messages. */
	public ArrayList<Message> getAndClearMessages() {
		ArrayList<Message> al = sentMessages;
		sentMessages = new ArrayList<Message>();
		return al;
	}

	
	
}