package com.capricorn.ResponseController;
import javax.swing.JOptionPane;


import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import com.capricorn.model.Model;
import com.capricorn.view.Application;

import xml.Message;
/**Join game request.*/
public class JoinGameResponse extends ControllerChain{
	

	
		public Application app;
		public Model model;
		
		public JoinGameResponse(Application a, Model m) {
			super();
			this.app = a;
			this.model = m;
		}
		/** Process the join game request*/
		@Override
		public boolean process(Message response) {
			
			String type = response.contents.getFirstChild().getLocalName();
			if (!type.equals ("joinGameResponse")) {
				return next.process(response);
			}
			app.setStartGame(false);
			
			
			Node joinGameResponse = response.contents.getFirstChild();
			NamedNodeMap map = joinGameResponse.getAttributes();
			app.getXmlb().getMessageInfo().append(response.toString()+"\n");
			return true;
		}
}
