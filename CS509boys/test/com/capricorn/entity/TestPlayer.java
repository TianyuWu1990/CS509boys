package com.capricorn.entity;

import junit.framework.TestCase;

public class TestPlayer extends TestCase{
	
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
			
		}

}
