package com.capricorn.controller;


import com.capricorn.controller.ControllerChain;
import com.capricorn.model.Model;
import com.capricorn.view.StartPage;

import xml.Message;

public class ConnectResponseController extends ControllerChain{
	
	StartPage app;
	Model model;
	
	public ConnectResponseController(StartPage app, Model model) {
		super();
		this.app = app;
		this.model = model;
	}
	
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("connectResponse")) {
			
		}
		
		
		return true;
	}

}
