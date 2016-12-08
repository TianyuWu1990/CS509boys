package com.capricorn.entity;

import junit.framework.TestCase;

public class TestAddToChosenCellsByIndex extends TestCase{
	Board board = new Board();
	
	public void testaddToChosenCellsByIndex(){
		String a = ("A,b,c,e,g,w,d,l,a,d,A,b,c,e,b,w");
		
		board.updateBoard(0,0,a);
		board.addToChosenCellsByIndex(4);
		String bgg = board.getWord().getContent();
		System.out.println("a="+bgg);
		System.out.println("cells are "+board.getCells()[1][0].getLetter());
		System.out.println("chosen cells are"+board.getChosenCells().size());
		assertTrue(board.cells[1][0].isSelected);
		assertEquals(bgg,"g");
		
		
	}


}
