package com.capricorn.RequestController;


import com.capricorn.entity.Model;
import com.capricorn.view.Application;

import xml.Message;



// TODO: Auto-generated Javadoc
/**
 * Send a create game request to the server and wait for the request.
 * @author Chen Li, Tianyu Wu, Yu Li
 */
public class CreateGameRequest{

    /** The app. */
    Application app;
    
    /** The model. */
    Model model;

	/**
	 * Instantiates a new creates the game request.
	 *
	 * @param app the app
	 * @param model the model
	 */
	public CreateGameRequest(Application app,Model model) {
		this.app = app;
		
		
	}


/**
 * Process to send the create game request with two different condition, with the password and without the password.
 */
public void process() {
		
		String xmlString;
		if(this.app.getPassword().length()==0){
			xmlString = Message.requestHeader() + String.format("<createGameRequest name='%s'/></request>", this.app.getPlayerName());		
		}else{
			xmlString = Message.requestHeader() + String.format("<createGameRequest name='%s' password='%s'/></request>", this.app.getPlayerName(), this.app.getPassword());
		}		
		Message m = new Message (xmlString);
		app.getServerAccess().sendRequest(m);
		app.getXmlb().getMessageInfo().append(m.toString()+"\n");
		
	}

}