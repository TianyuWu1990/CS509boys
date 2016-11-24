package com.capricorn.ResponseController;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import com.capricorn.RequestController.ControllerChain;
import com.capricorn.model.Model;
import com.capricorn.view.Application;

import xml.Message;
public class JoinGameResponse extends ControllerChain{
	

	
		public Application app;
		public Model model;
		
		public JoinGameResponse(Application a, Model m) {
			super();
			this.app = a;
			this.model = m;
		}
		@Override
		public boolean process(Message response) {
			System.out.println(response.toString());
			String type = response.contents.getFirstChild().getLocalName();
			if (!type.equals ("joinGameResponse")) {
				return next.process(response);
			}
			System.out.println(response.toString());
			
			Node boardResponse = response.contents.getFirstChild();
			NamedNodeMap map = boardResponse.getAttributes();
			
			String gameId = map.getNamedItem("gameId").getNodeValue();
			model.getGame().setGameId(gameId);
			
			app.getManagerg().refreshBoard();
			
			return true;
		}
}
