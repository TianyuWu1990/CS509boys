package com.capricorn.controller;


import xml.Message;

public class ConnectResponseController {
	
	
	public ConnectResponseController() {
		super();

	}
	
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("connectResponse")) {
			
		}
		
		
		return true;
	}

}
