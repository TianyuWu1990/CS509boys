package com.capricorn.client;

import com.capricorn.view.StartPage;

import com.capricorn.controller.ControllerChain;
import com.capricorn.controller.EmptyHandler;

import xml.Message;

/**
 * Sample implementation of a protocol handler to respond to messages received from the server.
 * You should follow this template when designing YOUR message handler.
 */
public class SampleClientMessageHandler implements IMessageHandler {
	
	StartPage app;
	
	// by default is the empty handler...
	ControllerChain chain = new EmptyHandler();
	
	/**
	 * Register new controller chain as occuring before existing chain.
	 */
	public void registerHandler(ControllerChain handler) {
		handler.next = chain;
		chain = handler;
	}
	
	public SampleClientMessageHandler(StartPage app) {
		this.app = app;
		
	}
	
	
	@Override
	public void process(Message response) {
		chain.process(response);
	}
	

}
