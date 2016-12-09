package com.capricorn.ResponseController;

import xml.Message;

import com.capricorn.entity.Model;
import com.capricorn.view.Application;
/** Exit game response from the server and quit the game if the response is legal. 
 *  @author Chen Li, Tianyu Wu
 */
public class ExitGameResponse extends ControllerChain{
	public Application app;
	public Model model;
	/** Construct ExitGameResponse object to use default port number.*/
	public ExitGameResponse(Application a, Model m) {
		super();
		this.app = a;
		this.model = m;
	}
	/** Process to finding out the exitGameResponse from the message and realize the exit game action.*/
	@Override
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("exitGameResponse")) {
			return next.process(response);
		}
      
		app.getXmlb().getMessageInfo().append(response.toString()+"\n");
		return true;
	}
}
