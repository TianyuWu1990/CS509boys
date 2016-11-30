package com.capricorn.RequestController;

import xml.Message;

import java.awt.event.ActionEvent;

import com.capricorn.model.Model;
import com.capricorn.view.Application;

public class LockGameRequest {
	Model model;
	Application app;
	public LockGameRequest(Model model,Application app){
		this.model = model;
		this.app = app;
		
	}

	
	public void process(){
		model.getGame().setLocked(true);
		String xmlString = Message.requestHeader() + String.format("<lockGameRequest gameId='%s'/></request>", model.getGame().getGameId());		

		Message m = new Message (xmlString);
		//System.out.println(app);
		System.out.println(m.toString());
		app.getServerAccess().sendRequest(m);
		app.getXmlb().getMessageInfo().append(m.toString()+"\n");
	}
	
}
