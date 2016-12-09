package com.capricorn.RequestController;

import xml.Message;

import com.capricorn.model.Model;
import com.capricorn.view.Application;
/** Reset the game board with a manager player and all the player refresh with new board and scores reset to 0.
 *  @author Chen Li, Tianyu Wu
 */
public class ResetGameRequest {
	
	Model model;
	Application app;
	public ResetGameRequest(Model model,Application app){
		this.model = model;
		this.app = app;
		
	}
	/** Process to formating the xml request reseting the board and sent it to the server.*/
	public void process(){
		String xmlString = Message.requestHeader() + String.format("<resetGameRequest gameId='%s'/></request>", 
				
				model.getGame().getGameId());		

		Message m = new Message (xmlString);
		app.getServerAccess().sendRequest(m);
		app.getXmlb().getMessageInfo().append(m.toString()+"\n");
	}
	
}
