package com.capricorn.RequestController;

import xml.Message;

import java.awt.event.ActionEvent;

import com.capricorn.entity.Model;
import com.capricorn.view.Application;
/** Lock game controller is designed to sending the server with the message to lock the game.
 *  The game is existed, but players can not manage or play the game.
 *  @author Chen Li, Tianyu Wu
 */
public class LockGameRequest {
	Model model;
	Application app;
	public LockGameRequest(Model model,Application app){
		this.model = model;
		this.app = app;
		
	}

	/** Process to formating the lock game request.*/
	public void process(){
		model.getGame().setLocked(true);
		String xmlString = Message.requestHeader() + String.format("<lockGameRequest gameId='%s'/></request>", model.getGame().getGameId());		
		Message m = new Message (xmlString);
		app.getServerAccess().sendRequest(m);
		app.getXmlb().getMessageInfo().append(m.toString()+"\n");
	}
	
}
