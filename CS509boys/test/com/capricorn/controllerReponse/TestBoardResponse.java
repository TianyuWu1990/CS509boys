package com.capricorn.controllerReponse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.capricorn.ResponseController.BoardResponse;
import com.capricorn.ResponseController.SampleClientMessageHandler;
import com.capricorn.entity.Board;
import com.capricorn.entity.Game;
import com.capricorn.entity.Model;
import com.capricorn.entity.Player;
import com.capricorn.mockServer.MockServer;
import com.capricorn.view.Application;
import com.capricorn.view.MultiGame;

import xml.Message;

/**
 * This is responsible for testing "Board Response" Controller
 * @author Bowen Sun, Chen Li
 */
public class TestBoardResponse {


	Model model = new Model();
	Application app = new Application(model);
	MockServer mockServer = new MockServer("localhost");
	/**
	 * Test Process() method in 'Board Response' in controller.
     * This is responsible for testing the process of "Board Response" Controller
     * the situation is that the list is more than 1
	 */
	@Test
	public void TestBoardResponse1(){
		app.setMg(new MultiGame(model, app));
		/**this is the setting for the test*/
		// FIRST thing to do is register the protocol being used.
		if (!Message.configure("wordsweeper.xsd")) {
			fail("unable to configure protocol");
		}
		app.setServerAccess(mockServer);
	
		
		
		String name="player";
		int col=2, row=1;
		String bonus = "3,3";
		String gameId= "jiaosd8asojd";
		String managingUser =name;
		String board = "A,B,A,B,A,B,B,B,C,B,C,D,B,A,B,R";
		String boardm= "ABABABBBCBCDBABR";
		String pos=col+ "," + row;
		int score =100;
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><response id=\"someMessageID\" success=\"true\">"
				+ "<boardResponse bonus=\"%s\" gameId=\"%s\" managingUser=\"%s\">"
				+ "<player board=\"%s\" name=\"%s\" position=\"%s\" score=\"%s\"/>"
				+ "</boardResponse></response>";
		xml = String.format(xml, bonus,gameId,managingUser,board,name,pos,score);
		
		model.updateModel("u76jfhd", "jack", "hmac", 2, 4, "A,B,C,D,F,E,E,G,H,I,J,K,L,M,N,O", 55,
				"3,5");
		
		
		Message m = new Message(xml);
		BoardResponse br=new BoardResponse(app,model);
		br.process(m);
		
		
		Board b = model.getBoard();
		
		assertEquals(b.getGlobalStartingCol(), col);
		assertEquals(b.getGlobalStartingRow(), row);
		assertEquals(b.getBoardInfo(), boardm);
		assertEquals(b.getBonusCell(), bonus);
		
		

		Game game = model.getGame();
		assertEquals(game.getManagingUser(),"player");
		assertEquals(game.getGameId(),"jiaosd8asojd");
		
		Game g=model.getGame();
		assertEquals(g.getManagingUser(), name);

		Player p=model.getPlayer();
		assertEquals(p.getName(), name);
		assertEquals(p.getScore(), score);
		assertTrue(p.isManager());
		br.process(m);
		
		/**this is the test for connect response process part 2*/
		String xml2= "<?xml version=\"1.0\" encoding=\"UTF-8\"?><response id=\"someMessageID\" success=\"true\">"
		    + "<connectResponse id=\"game1\">"
		    +"</connectResponse></response>";
		xml2 =String.format(xml2);
		Message n = new Message(xml2);
		
SampleClientMessageHandler handler = new SampleClientMessageHandler(app);
		
		
		handler.registerHandler(br);
		assertTrue(br.process(n));
		
	}
	
	
}
