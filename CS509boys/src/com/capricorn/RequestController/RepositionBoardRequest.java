package com.capricorn.RequestController;

import xml.Message;

import com.capricorn.entity.Model;
import com.capricorn.view.Application;
/** Reposition game board means to change the game filed position in the server and back with a new game board.
 *  @author Chen Li, Tianyu Wu, Yu Li
 */

public class RepositionBoardRequest {
	Model model;
	Application app;
	Integer []change;
	
	/**
	 * Instantiates a new reposition board request.
	 *
	 * @param model the model
	 * @param app the Application
	 * @param change the change
	 */
	public RepositionBoardRequest(Model model,Application app,Integer[] change){
		this.model = model;
		this.app = app;
		this.change = change;
		
	}
	/** Process to formating the reposition request and send to the server.*/
	public void process(){
		
	String xmlString = Message.requestHeader() + String.format("<repositionBoardRequest name='%s' gameId='%s'", 
			model.getPlayer().getName(), model.getGame().getGameId())  
			+" rowChange='"+ change[0]
			+"' colChange='" + change[1] + "'/></request>";

Message m = new Message (xmlString);
app.getServerAccess().sendRequest(m);
app.getXmlb().getMessageInfo().append(m.toString()+"\n");
}
}
