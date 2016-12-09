package com.capricorn.ResponseController;



import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import xml.Message;

import com.capricorn.entity.Word;
import com.capricorn.model.Model;
import com.capricorn.view.Application;
/** Find word response tell the word submitted is legal or not.
 *  @author Chen Li, Tianyu Wu
 */
public class FindWordResponse extends ControllerChain{
	public Application app;
	public Model model;
	/** Construct FindWordResponse object to use default port number.*/
	public FindWordResponse(Application a, Model m) {
		super();
		this.app = a;
		this.model = m;
	}
	/** Process to dealing with the message from the server and realize find word function. */
	@Override
	public boolean process(Message response) {
		
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("findWordResponse")) {
			return next.process(response);
		}
			
		Node boardResponse = response.contents.getFirstChild();
		NamedNodeMap map = boardResponse.getAttributes();	
		String score = map.getNamedItem("score").getNodeValue();
		model.getBoard().getWord().setScore(Integer.valueOf(score));
		app.getManagerg().refreshBoard();
		app.getXmlb().getMessageInfo().append(response.toString()+"\n");
		return true;
	}
}
