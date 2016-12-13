package com.capricorn.controllerRequest;

import java.util.ArrayList;

import junit.framework.TestCase;
import xml.Message;

import com.capricorn.RequestController.FindWordRequest;
import com.capricorn.entity.Cell;
import com.capricorn.entity.Model;
import com.capricorn.mockServer.MockServer;
import com.capricorn.view.Application;
/**
	 * @author yli14
	 * This is for test 'FindWordRequest' in controller
	 */
public class TestFindWordRequest extends TestCase{
	
	Model model = new Model();
	Application app = new Application(model);
	MockServer ms = new MockServer("localhost");
	
	/**
		 * Test Process() method in 'FindWordRequest'
		 */
	public void testprocess() throws Exception{
		
		if (!Message.configure("wordsweeper.xsd")) { 
			fail ("unable to configure protocol"); 
		}
		app.setServerAccess(ms);
		FindWordRequest req = new FindWordRequest(model, app);
		model.getPlayer().setName("yu");
		model.getGame().setGameId("fortest");
		
		Cell ce1 = new Cell();
		ArrayList<Cell> Chosencells= new ArrayList<Cell>();
		Chosencells.add(ce1);
		model.getBoard().setChosenCells(Chosencells);
		model.getBoard().getWord().setContent("abc");
		
		req.process();
		ArrayList<Message> al = new ArrayList<Message>();
		al = ms.getAndClearMessages();
		assertEquals(al.get(0).contents.getFirstChild().getLocalName(),"findWordRequest");
		assertEquals(al.get(0).contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue(),model.getGame().getGameId());
		assertEquals(al.get(0).contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue(),model.getPlayer().getName());
	}
}
