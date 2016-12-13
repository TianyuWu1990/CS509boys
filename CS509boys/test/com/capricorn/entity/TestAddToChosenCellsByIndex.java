package com.capricorn.entity;

import junit.framework.TestCase;
/**
 * @author yli14
 * This is for test 'AddToChosenCellsByIndex' in entity cell
 */

public class TestAddToChosenCellsByIndex extends TestCase{
	Board board = new Board();
	/**
      * Test addToChosenCellsByInde method in 'cell'
      */
	public void testaddToChosenCellsByIndex(){
		String a = ("A,b,c,e,g,w,d,l,a,d,A,b,c,e,b,w");
		
		board.updateBoard(0,0,a);
		board.addToChosenCellsByIndex(4);
		String bgg = board.getWord().getContent();
		assertTrue(board.getCells()[1][0].isSelected());
		assertEquals(bgg,"g");
		
		
	}


}
