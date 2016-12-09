package com.capricorn.RequestController;
import com.capricorn.entity.Model;
import com.capricorn.view.Application;

import xml.Message;
/** Exit game request and back to the application view.
 *  @author Chen Li, Tianyu Wu
 */
public class ExitGameRequest {
	Model model;
	Application app;
	public ExitGameRequest(Model model,Application app){
		this.model = model;
		this.app = app;
		
	}
	/** Process to send the exit request to the server.*/
	public void process(){
		String xmlString = Message.requestHeader() + String.format("<exitGameRequest name='%s' gameId='%s'/></request>", 
				model.getPlayer().getName(),
				model.getGame().getGameId());		

		Message m = new Message (xmlString);	
		app.getServerAccess().sendRequest(m);
		app.getXmlb().getMessageInfo().append(m.toString()+"\n");
	}
	
}