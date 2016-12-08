package com.capricorn.ResponseController;

import xml.Message;

import com.capricorn.model.Model;
import com.capricorn.view.Application;
/** Receive and find out the lock game response from the server and realize the lock request.*/
public class LockGameResponse extends ControllerChain{
	

		public Application app;
		public Model model;
		
/** Construct LockGameResponse object to use default port number.*/
		public LockGameResponse(Application a, Model m) {
			super();
			this.app = a;
			this.model = m;
		}
		/** Process the message from the server and lock the game if the request have been sent.*/
		@Override
		public boolean process(Message response) {
			
			String type = response.contents.getFirstChild().getLocalName();
			if (!type.equals ("lockGameResponse")) {
				return next.process(response);
			}	
			model.getGame().setLocked(true);
			app.getManagerg().refreshBoard();
			app.getXmlb().getMessageInfo().append(response.toString()+"\n");
			return true;
		}

	
}
