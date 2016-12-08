package com.capricorn.entity;

import junit.framework.TestCase;

public class TestSetGet extends TestCase{
	
	Board board = new Board();
	
	public void testSetandget(){
		board.setBonusCell("A");
		assertTrue(board.getBonusCell()=="A");
		board.setRequestColChange(3);
		assertTrue(board.getRequestColChange()==3);
		board.setRequestRowChange(4);
		assertTrue(board.getRequestRowChange()==4);
	}

}
