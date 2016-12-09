package com.capricorn.entity;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class TestGame extends TestCase{
	
	public void testGame(){
		//Test get and set.
		Game game = new Game();
		game.playersLocation=new ArrayList();
		Player p1 = new Player();
		Player p2 = new Player();
		p1.setName("lee");
		p1.setScore(65);
		p2.setName("son");
		p2.setScore(55);
		game.setGameId("g1");
		p1.setPosition("2,3");
		p2.setPosition("3,4");
		
		game.playersLocation.add(p1.getPosition());
		game.playersLocation.add(p2.getPosition());
		assertTrue(game.getPlayerslocation().contains("2,3")&&game.getPlayerslocation().contains("3,4"));
		assertTrue(game.getGameId()=="g1");
		game.playersInformation.add(p1);
		game.playersInformation.add(p2);
		//Test lock game.
		game.setLocked(true);
			
		assertTrue(game.isLocked());
		game.setManagingUser(p1.getName());
		assertTrue(game.getManagingUser()=="lee");
		game.setPlayersInformation(game.playersInformation);
		assertEquals(game.getPlayersInformation().size(),2);
		game.getPlayersListByScore();
		assertTrue(game.playersInformation.get(0).name=="lee");
		
		p1.setScore(45);
		game.getPlayersListByScore();
		//after change lee's score, his rank shoud be 2,and Son should be 1
		assertTrue(game.playersInformation.get(0).name=="son");
		
		assertTrue(game.playersInformation.get(0).getScore()>game.playersInformation.get(1).getScore());
		//clear all Players' informations
		game.clearPlayersInformation();
		assertEquals(game.getPlayersInformation().size(),0);
	    
		List<Word> a = new ArrayList<Word>();
		a.add(new Word());
		a.add(new Word());
		game.setSelectedWord(a);
		assertEquals(game.getSelectedWord(),a);
		
			
			
		}

}
