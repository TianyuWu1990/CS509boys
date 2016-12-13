package com.capricorn.entity;

import junit.framework.TestCase;
/**
 * @author yli14, Tianyu Wu
 * This is for test entity 'Player'.
 */
public class TestPlayer extends TestCase{
	/** Test the entity 'Player'.*/
	public void testPlayer(){
			Player pl=new Player();		
			pl.setManager(true);
			pl.setName("lee");
			pl.setScore(100);
			pl.setPosition("2,3");
			assertTrue(pl.isManager());
			assertEquals(pl.getName(),"lee");
			assertEquals(pl.getScore(),100);
			assertEquals(pl.getPosition(),"2,3");
			
			Player p2=new Player("Yu",20,"3,1");
			assertEquals(p2.getName(),"Yu");
			assertEquals(p2.getPosition(),"3,1");
			assertEquals(p2.getScore(),20);
			p2.setWordScore(1440);
			assertEquals(p2.getWordScore(),1440);
			
			
			
		}

}
