package com.capricorn.RequestController;

import xml.Message;

import com.capricorn.entity.Model;
import com.capricorn.view.Application;
/** Send a join game request to the server.
 *  @author Chen Li, Tianyu Wu, Yu Li
 */
public class JoinGameRequest {
	
		Model model;
		Application app;
		public JoinGameRequest(Model model,Application app){
			this.model = model;
			this.app = app;
			
		}
		/** Process to build the join game request and send to the server if the server is connected.*/
		public void process(){
			String xmlString;
			if(this.app.getPassword().length() == 0){
				xmlString = Message.requestHeader() + String.format("<joinGameRequest gameId='%s' name='%s'/></request>", 
																		app.getGameNumber(), 
																		app.getPlayerName());
				
			}else{
				xmlString = Message.requestHeader() + String.format("<joinGameRequest gameId='%s' name='%s' password='%s'/></request>", 
																		app.getGameNumber(), 
																		app.getPlayerName(),
																		app.getPassword());		
			}		
			
			
			Message m = new Message (xmlString);
			app.getServerAccess().sendRequest(m);
			app.getXmlb().getMessageInfo().append(m.toString()+"\n");
		}
		
	
}
