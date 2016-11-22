package com.capricorn.ResponseController;

import xml.Message;

import com.capricorn.RequestController.ControllerChain;
import com.capricorn.model.Model;
import com.capricorn.view.Application;

public class ConnectResponse extends ControllerChain {
	
	public Application app;
	public Model model;
	private boolean flag;
	
	public ConnectResponse(Application a, Model m) {
		super();
		this.app = a;
		this.model = m;
		this.flag = false;
	}
	
	@Override
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("connectResponse")) {
			return next.process(response);
		}
		
//		app.getResponseArea().append(response.toString() + "\n");

		if (this.flag == true) {
			app.getManagerg().refreshBoard();
			
		}
		this.flag = true;

		return true;
	}
}
