package com.capricorn.ResponseController;

import xml.Message;

import com.capricorn.model.Model;
import com.capricorn.view.Application;

public class ResetGameResponse extends ControllerChain{
	public Application app;
	public Model model;
	
	public ResetGameResponse(Application a, Model m) {
		super();
		this.app = a;
		this.model = m;
	}
	
	@Override
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("resetGameResponse")) {
			return next.process(response);
		}
		
		
		//need to rewrite in model,empty function right now
//		model.updateModel();
        model.resetGame();
		app.getManagerg().refreshBoard();
		app.getXmlb().getMessageInfo().append(response.toString()+"\n");


		return true;
	}
}
