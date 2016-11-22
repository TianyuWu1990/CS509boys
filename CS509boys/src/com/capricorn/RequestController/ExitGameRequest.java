package com.capricorn.RequestController;
import com.capricorn.model.Model;
import com.capricorn.view.Application;

import xml.Message;
public class ExitGameRequest {
	Model model;
	Application app;
	public ExitGameRequest(Model model,Application app){
		this.model = model;
		this.app = app;
		
	}
	
	public void process(){
		String xmlString = Message.requestHeader() + String.format("<exitGameRequest name='%s' gameID='%s'/></request>", 
				model.getPlayer().getName(),
				model.getGame().getGameId());		

		Message m = new Message (xmlString);
		// Request the lock (this might not succeed).
		
		app.getServerAccess().sendRequest(m);
	}
	
}
