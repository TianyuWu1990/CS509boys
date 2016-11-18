package com.capricorn.RequestController;


import com.capricorn.model.Model;
import com.capricorn.view.Application;

import xml.Message;


public class JoinGameController {

	Application app;
	Model model;

	public JoinGameController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void process() {
		
		String xmlString;
		if(this.app.getPassword() == null){
			xmlString = Message.requestHeader() + String.format("<joinGameRequest gameId='%s' name='%s'/></request>", 
																	app.getGameNumber(), 
																	app.getName());
			
		}else{
			xmlString = Message.requestHeader() + String.format("<joinGameRequest gameId='%s' name='%s password='%s'/></request>", 
																	app.getGameNumber(), 
																	app.getName(),
																	app.getPassword());		
		}		
		Message m = new Message (xmlString);
		
		app.getServerAccess().sendRequest(m);
	}
}