package com.capricorn.client;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.capricorn.controller.ControllerChain;
import com.capricorn.model.Model;
import com.capricorn.view.StartPage;

import xml.Message;


/**
 * Tells the client whether the model is locked or not BY SOME OTHER CLIENT. This will never be returned to a client
 * to tell him that HE has the model locked (that is job of LockResponse).
 */
public class BoardResponseController extends ControllerChain {

	public StartPage app;
	public Model model;
	
	public BoardResponseController(StartPage a, Model m) {
		super();
		this.app = a;
		this.model = m;
	}
	
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("boardResponse")) {
			return next.process(response);
		}
		
		// this refers to the outer node of the Message DOM (in this case, updateResponse).
		Node boardResponse = response.contents.getFirstChild();
		NamedNodeMap map = boardResponse.getAttributes();
		
		String gameId = map.getNamedItem("gameId").getNodeValue();
		
	
		
		// at this point, you would normally start processing this...
		
		return true;
	}

}
