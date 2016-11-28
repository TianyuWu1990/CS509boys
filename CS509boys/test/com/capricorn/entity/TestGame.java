package com.capricorn.entity;

import junit.framework.TestCase;

public class TestGame extends TestCase {
	
	Game game = new Game();
	Player p1 = new Player();
	Player p2 = new Player();
	
	public void testprocess(){
		p1.setName("lee");
		p1.setScore(25);
		p2.setName("son");
		p2.setScore(55);
		game.setGameId("g1");
		assertTrue(game.getGameId()=="g1");
		game.playersInformation.add(p1);
		game.playersInformation.add(p2);
		game.setLocked(true);
		
		assertTrue(game.isLocked());
		game.setManagingUser(p1.getName());
		assertTrue(game.getManagingUser()=="lee");
		
		
	
//		game.playersInformation=<>
		game.setPlayersInformation(game.playersInformation);
//		game.getPlayersInformation();
		assertEquals(game.getPlayersInformation().size(),2);
		game.getPlayersListByScore();
		
		p1.setScore(55);
		assertTrue(game.playersInformation.get(0).name=="son");
		
		assertEquals(game.playersInformation.get(0).getScore(),game.playersInformation.get(1).getScore());
		game.clearPlayersInformation();
		assertEquals(game.getPlayersInformation().size(),0);
		
		
	}
	
}
