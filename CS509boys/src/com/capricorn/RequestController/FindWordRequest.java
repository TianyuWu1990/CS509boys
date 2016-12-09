package com.capricorn.RequestController;

import xml.Message;

import com.capricorn.entity.Model;
import com.capricorn.view.Application;
/** Find if the submitted word in the word library. 
 *  @author Chen Li, Tianyu Wu
 */
public class FindWordRequest {
	
	Model model;
	Application app;
	
	public FindWordRequest(Model model,Application app){
		this.model = model;
		this.app = app;
		
	}
	/** Process to get the word we choose.*/
	public void process(){
String chosenCellsInfoXMLString = model.getBoard().getChosenCellsXMLString();
		
		String xmlString = Message.requestHeader() + String.format("<findWordRequest gameId='%s' name='%s' word='%s'>",
														model.getGame().getGameId(),
														model.getPlayer().getName(), 
														model.getBoard().getWord().getContent())
										    		+chosenCellsInfoXMLString
										    		+"</findWordRequest></request>";
		
		Message m = new Message (xmlString);
		app.getServerAccess().sendRequest(m);
		app.getXmlb().getMessageInfo().append(m.toString()+"\n");
	
	}
}
