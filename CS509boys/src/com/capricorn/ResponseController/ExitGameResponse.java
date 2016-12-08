package com.capricorn.ResponseController;

import xml.Message;

import com.capricorn.model.Model;
import com.capricorn.view.Application;

public class ExitGameResponse extends ControllerChain{
	public Application app;
	public Model model;
	
	public ExitGameResponse(Application a, Model m) {
		super();
		this.app = a;
		this.model = m;
	}
	
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
