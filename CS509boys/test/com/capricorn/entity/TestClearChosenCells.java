package com.capricorn.entity;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestClearChosenCells extends TestCase {
	
	Board board = new Board();
	
	public void testclearChosenCells(){
		String a = ("A,a,c,e,g,w,d,l,a,d,A,b,c,e,f,w");
		ArrayList<Cell> ce = new ArrayList<Cell>();
		board.updateBoard(0,0,a);
		board.addToChosenCellsByIndex(4);
		board.clearChosenCells();
		assertEquals(board.getChosenCells(),ce);
		assertFalse(board.cells[1][0].isSelected());
		
	}

}
