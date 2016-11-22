package com.capricorn.ResponseController;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import xml.Message;

import com.capricorn.RequestController.ControllerChain;
import com.capricorn.model.Model;
import com.capricorn.view.Application;

public class BoardResponse extends ControllerChain{
	public Application app;
	public Model model;
	private boolean flag;
	
	public BoardResponse(Application a, Model m) {
		super();
		this.app = a;
		this.model = m;
		this.flag = false;
	}
	
	@Override
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("boardResponse")) {
			return next.process(response);
		}
		
		// this refers to the outer node of the Message DOM (in this case, updateResponse).
		Node boardResponse = response.contents.getFirstChild();
		NamedNodeMap map = boardResponse.getAttributes();
		
		String gameId = map.getNamedItem("gameId").getNodeValue();
		String managingUser = map.getNamedItem("managingUser").getNodeValue();
		
		NodeList list = boardResponse.getChildNodes();		
		
		Map<String, Integer> allPlayersInfo = new HashMap<>();
		Map<String, String> allPlayersPositionInfo = new HashMap<>();
		
		for (int i = 0; i < list.getLength(); i++) {
			Node n = list.item(i);
			String pname = n.getAttributes().getNamedItem("name").getNodeValue();
			String pscore = n.getAttributes().getNamedItem("score").getNodeValue();
			String boardInfo = n.getAttributes().getNamedItem("board").getNodeValue();
			String plocation = n.getAttributes().getNamedItem("position").getNodeValue();
			char[] corRowArray = plocation.toCharArray();
			Integer globalStartingCol = Integer.valueOf(String.valueOf(corRowArray[0]));
			Integer globalStaringRow = Integer.valueOf(String.valueOf(corRowArray[corRowArray.length - 1]));
			Long score = Long.valueOf(n.getAttributes().getNamedItem("score").getNodeValue());
			allPlayersInfo.put(pname, Integer.valueOf(pscore));
			allPlayersPositionInfo.put(pname, plocation);
		}	
		if (this.flag == true) {
			app.getManagerg().refreshBoard();
			
		}
		this.flag = true;


		return true;
	}
}
