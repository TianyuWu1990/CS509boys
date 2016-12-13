package com.capricorn.ResponseController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.capricorn.entity.Board;
import com.capricorn.entity.Model;
import com.capricorn.entity.Player;
import com.capricorn.view.Application;

import xml.Message;
/** From the server, after receiving the board message response which contains all the information we need in the board, the refresh the board.
 *  Whatever a request is, the response must contains a response about the board. 
 *  Each action contributes to refresh process. 
 *  @author Chen Li, Tianyu Wu
 */
public class BoardResponse extends ControllerChain{
	public Application app;
	public Model model;
	private boolean flag;
	/** Construct Boardresponse object to use default port number.*/
	public BoardResponse(Application a, Model m) {
		super();
		this.app = a;
		this.model = m;
		this.flag = false;
	}
	
	/**
	 *  Process to find out the corresponding titles in the xml files and refresh the board information.
	 *
	 * @param response the response
	 * @return true, if successful
	 */
	@Override
	public boolean process(Message response) {
		
		
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("boardResponse")) {
			return next.process(response);
		}
		app.setStartGame(true);
		
		
		
		Node boardResponse = response.contents.getFirstChild();
		NamedNodeMap map = boardResponse.getAttributes();
		
		String gameId = map.getNamedItem("gameId").getNodeValue();
		String managingUser = map.getNamedItem("managingUser").getNodeValue();
		String bonusCell=map.getNamedItem("bonus").getNodeValue();
		
		NodeList list = boardResponse.getChildNodes();		
		
		List<Player> allPlayersInfo =  new LinkedList<Player>();
		List<String> ownLocationList=new ArrayList<String>();
		
		
		
		for (int i = 0; i < list.getLength(); i++) {
			Node n = list.item(i);
			String pname = n.getAttributes().getNamedItem("name").getNodeValue();
			String pscore = n.getAttributes().getNamedItem("score").getNodeValue();
			String boardInfo = n.getAttributes().getNamedItem("board").getNodeValue();
			String plocation = n.getAttributes().getNamedItem("position").getNodeValue();
			char[] corRowArray = plocation.toCharArray();
			int globalStartingCol = Integer.valueOf(String.valueOf(corRowArray[0]));
			int globalStaringRow = Integer.valueOf(String.valueOf(corRowArray[corRowArray.length - 1]));
			Long score = Long.valueOf(pscore);
			Player player=new Player(pname,score,plocation);
			allPlayersInfo.add(player);
			if (this.flag == false){
				
				
				model.updateModel(gameId, managingUser, pname, globalStartingCol, globalStaringRow, boardInfo, score,bonusCell
						);
				ownLocationList=Board.setBoardPositionList(plocation);
				
			}
			else if (pname.equals(this.model.getPlayer().getName())){
				
				model.updateModel(gameId, managingUser, pname, globalStartingCol, globalStaringRow, boardInfo, score,bonusCell
					);
				ownLocationList=Board.setBoardPositionList(plocation);
			}
			
		}	
		model.getBoard().resetoverlapTimes();
		model.getGame().setPlayersInformation(allPlayersInfo);
		
		for(Player player:allPlayersInfo){
			String plocation=player.getPosition();
			List<String> positionList=Board.setBoardPositionList(plocation);
			for (String owncoordinate:ownLocationList){
				for(String othercoordinate:positionList){
       if(owncoordinate.equals(othercoordinate)){
    	   int ownx=Integer.parseInt(owncoordinate.split(",")[0]);
    	   int owny=Integer.parseInt(owncoordinate.split(",")[1]);
    	   int col=model.getBoard().getGlobalStartingCol();
    	   int row=model.getBoard().getGlobalStartingRow();
    	  int index= (owny-row)*4+(ownx-col);
    	  model.getBoard().getOverlapTimes()[index]+=1;
    	   
       }
    	   
       }
             
			}
		}
		for(int i=0;i<16;i++){
		model.getBoard().getOverlapTimes()[i]-=1;
		
		}
		
		
		
		
		if (this.flag == true) {
					
			app.getManagerg().refreshBoard();
				
		}
	
		this.flag = true;
		app.getXmlb().getMessageInfo().append(response.toString()+"\n");
		return true;
	}
}
