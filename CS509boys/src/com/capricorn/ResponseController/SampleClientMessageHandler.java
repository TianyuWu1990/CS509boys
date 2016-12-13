package com.capricorn.ResponseController;
import com.capricorn.view.Application;

import xml.Message;

/**
 * Sample implementation of a protocol handler to respond to messages received from the server.
 * You should follow this template when designing YOUR message handler.
 * 
 * Note: This one does nothing more than dump the XML message into the client window. Nothing that special.
 * @author Chen Li, Tianyu Wu, Dongshegn
 */
public class SampleClientMessageHandler implements IMessageHandler {
	Application app;	
	ControllerChain chain = new EmptyHandler();	
	/**
	 * Register new controller chain as occurring before existing chain.
	 */
	public void registerHandler(ControllerChain handler) {
		handler.next = chain;
		chain = handler;
	}
	/** Construct SampleClientMessageHandler(Application app) object to use default port number.*/
	public SampleClientMessageHandler(Application app) {		this.app = app;
	}
	
	/**
	 * Process to do with the response message.
	 *
	 * @param response the response
	 */
	@Override
	public void process(Message response) {
		chain.process(response);
	}
	
	
	

}