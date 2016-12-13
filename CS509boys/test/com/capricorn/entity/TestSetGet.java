package com.capricorn.entity;

import junit.framework.TestCase;
/** set and get test
 *  @author Yu Li
 */
public class TestSetGet extends TestCase{
	
	Board board = new Board();
	/** Test set and get*/
	public void testSetandget(){
		board.setBonusCell("A");
		assertTrue(board.getBonusCell()=="A");
		board.setRequestColChange(3);
		assertTrue(board.getRequestColChange()==3);
		board.setRequestRowChange(4);
		assertTrue(board.getRequestRowChange()==4);
	}

}
