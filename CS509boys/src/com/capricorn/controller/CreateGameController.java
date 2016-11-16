package com.capricorn.controller;


import xml.Message;
import com.capricorn.controller.ControllerChain;
import com.capricorn.model.Model;
import com.capricorn.view.StartPage;



public class CreateGameController extends ControllerChain{

	StartPage app;
	Model model;

	public CreateGameController(StartPage app, Model model) {
		this.app = app;
		this.model = model;
	}


	@Override
	public boolean process(Message response) {
		// send the request to create the game.
		String xmlString = Message.requestHeader() + "<createGameRequest name='samplePlayer'/></request>";
		Message m = new Message (xmlString);

		return app.getServerAccess().sendRequest(m);
	}
}
