package com.capricorn.RequestController;


import com.capricorn.RequestController.ControllerChain;
import com.capricorn.model.Model;
import com.capricorn.view.Application;

import xml.Message;

public class ConnectResponseController extends ControllerChain{
	
	Application app;
	Model model;
	
	public ConnectResponseController(Application app, Model model) {
		super();
		this.app = app;
		this.model = model;
	}
	
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("connectResponse")) {
			return next.process(response);
		}
		
		
		return true;
	}

}
