package com.capricorn.entity;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
/**
 * @author yli14
 * This is for test 'Game' in entities
 */
public class TestGame extends TestCase{
	/**
     * Test Game entity.
     */
	public void testGame(){
		Game game = new Game();
		Player p1 = new Player();
		Player p2 = new Player();
		p1.setName("lee");
		p1.setScore(65);
		p2.setName("son");
		p2.setScore(55);
		game.setGameId("g1");
		p1.setPosition("2,3");
		p2.setPosition("3,4");
		
		game.getPlayerslocation().add(p1.getPosition());
		game.getPlayerslocation().add(p2.getPosition());
		assertTrue(game.getPlayerslocation().contains("2,3")&&game.getPlayerslocation().contains("3,4"));
		assertTrue(game.getGameId()=="g1");
		game.getPlayersInformation().add(p1);
		game.getPlayersInformation().add(p2);
		game.setLocked(true);
			
		assertTrue(game.isLocked());
		game.setManagingUser(p1.getName());
		assertTrue(game.getManagingUser()=="lee");
		game.setPlayersInformation(game.getPlayersInformation());
		assertEquals(game.getPlayersInformation().size(),2);
		game.getPlayersListByScore();
		assertTrue(game.getPlayersInformation().get(0).getName()=="lee");
	
		p1.setScore(45);
		game.getPlayersListByScore();
		assertTrue(game.getPlayersInformation().get(0).getName()=="son");
		
		assertTrue(game.getPlayersInformation().get(0).getScore()>game.getPlayersInformation().get(1).getScore());
		game.clearPlayersInformation();
		assertEquals(game.getPlayersInformation().size(),0);
	    
		List<Word> a = new ArrayList<Word>();
		a.add(new Word());
		a.add(new Word());
		game.setSelectedWord(a);
		assertEquals(game.getSelectedWord(),a);
		
			
			
		}

}
