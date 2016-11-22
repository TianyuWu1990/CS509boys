package com.capricorn.RequestController;

import xml.Message;

import com.capricorn.model.Model;
import com.capricorn.view.Application;

public class JoinGameRequest {
	
		Model model;
		Application app;
		public JoinGameRequest(Model model,Application app){
			this.model = model;
			this.app = app;
			
		}
		
		public void process(){
			String xmlString = Message.requestHeader() + String.format("<joinGameResponse gameID='%s'/></request>", 
					
					model.getGame().getGameId());		

			Message m = new Message (xmlString);
			
			
			app.getServerAccess().sendRequest(m);
		}
		
	
}
