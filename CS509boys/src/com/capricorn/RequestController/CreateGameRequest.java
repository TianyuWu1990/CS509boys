package com.capricorn.RequestController;


import com.capricorn.model.Model;
import com.capricorn.view.Application;

import xml.Message;



// TODO: Auto-generated Javadoc
/**
 * The Class CreateGameRequest.
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
 * Process.
 */
public void process() {
		
		String xmlString;
		if(this.app.getPassword() == null){
			xmlString = Message.requestHeader() + String.format("<createGameRequest name='%s'/></request>", this.app.getPlayName());		
		}else{
			xmlString = Message.requestHeader() + String.format("<createGameRequest name='%s' password='%s'/></request>", this.app.getPlayName(), this.app.getPassword());
		}		
		Message m = new Message (xmlString);
		//System.out.println(app.getServerAccess());
		app.getServerAccess().sendRequest(m);
		app.getXmlb().getMessageInfo().append(m.toString()+"\n");
		
	}

}
