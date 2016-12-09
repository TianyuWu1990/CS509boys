package com.capricorn.ResponseController;

import xml.Message;

import com.capricorn.entity.Model;
import com.capricorn.view.Application;
/** Controller is designed to process the message and find the ResetGameResponse response. 
 *  @author Chen Li, Tianyu Wu
 */
public class ResetGameResponse extends ControllerChain{
	public Application app;
	public Model model;
	/** Construct ResetGameResponse object to use default port number.*/
	public ResetGameResponse(Application a, Model m) {
		super();
		this.app = a;
		this.model = m;
	}
	/** Find the resetGameResponse from the message class and reset the the game.*/
	@Override
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("resetGameResponse")) {
			return next.process(response);
		}
        model.resetGame();
		app.getManagerg().refreshBoard();
		app.getXmlb().getMessageInfo().append(response.toString()+"\n");
		return true;
	}
}
