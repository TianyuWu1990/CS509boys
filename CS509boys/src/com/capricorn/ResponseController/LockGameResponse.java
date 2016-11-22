package com.capricorn.ResponseController;

import xml.Message;

import com.capricorn.RequestController.ControllerChain;
import com.capricorn.model.Model;
import com.capricorn.view.Application;

public class LockGameResponse extends ControllerChain{
	

		public Application app;
		public Model model;
		

		public LockGameResponse(Application a, Model m) {
			super();
			this.app = a;
			this.model = m;
		}
		
		@Override
		public boolean process(Message response) {
			String type = response.contents.getFirstChild().getLocalName();
			if (!type.equals ("lockGameResponse")) {
				return next.process(response);
			}
			
			
			model.getGame().setLocked(true);


			app.getManagerg().refreshBoard();

			return true;
		}

	
}
