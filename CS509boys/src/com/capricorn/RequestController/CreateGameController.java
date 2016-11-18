package com.capricorn.RequestController;


import com.capricorn.model.Model;
import com.capricorn.view.Application;

import xml.Message;



public class CreateGameController{

    Application app;
    Model model;

	public CreateGameController(Application app,Model model) {
		this.app = app;
	}


public void process() {
		
		String xmlString;
		if(this.app.getPassword() == null){
			xmlString = Message.requestHeader() + String.format("<createGameRequest name='%s'/></request>", this.app.getPlayName());		
		}else{
			xmlString = Message.requestHeader() + String.format("<createGameRequest name='%s' password='%s'/></request>", this.app.getPlayName(), this.app.getPassword());
		}		
		Message m = new Message (xmlString);
		app.getServerAccess().sendRequest(m);
		
	}

}
