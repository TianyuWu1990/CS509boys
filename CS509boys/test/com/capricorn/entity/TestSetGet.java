package com.capricorn.entity;

import junit.framework.TestCase;
/** set and get test
 *  @author yli14, Tianyu Wu
 */
public class TestSetGet extends TestCase{
	
	Board board = new Board();
	/** Test set and get of bounusCell and RequestColchange function*/
	public void testSetandget(){
		board.setBonusCell("A");
		assertTrue(board.getBonusCell()=="A");
		board.setRequestColChange(3);
		assertTrue(board.getRequestColChange()==3);
		board.setRequestRowChange(4);
		assertTrue(board.getRequestRowChange()==4);
	}

}
