package com.capricorn.ResponseController;
import com.capricorn.client.IMessageHandler;

import xml.Message;

/**
 * Sample implementation of a protocol handler to respond to messages received from the server.
 * You should follow this template when designing YOUR message handler.
 */
public class SampleClientMessageHandler implements IMessageHandler {

	@Override
	public void process(Message response) {

		System.out.println("Received:" + response);
	}

}
