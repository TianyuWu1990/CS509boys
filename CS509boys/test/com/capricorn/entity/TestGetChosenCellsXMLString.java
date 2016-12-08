package com.capricorn.entity;

import junit.framework.TestCase;

public class TestGetChosenCellsXMLString extends TestCase{
	
	Board board = new Board();

	public void testgetChosenCellsXMLString(){
		// Test get ChosenCells in XMLString form
		Cell a = new Cell();
		Cell b = new Cell();
		Coordinate co= new Coordinate(3,4);
		Coordinate co1 = new Coordinate(2,3);
		a.setLetter("a");
		b.setLetter("QU");
		a.setGlobalCoordinate(co);
		b.setGlobalCoordinate(co1);
		board.getChosenCells().add(a);
		board.getChosenCells().add(b);
		board.setChosenCells(board.getChosenCells());
		String result=board.getChosenCellsXMLString();
		

		assertEquals(result,"<cell position='3,4' letter='a'/><cell position='2,3' letter='QU'/>");
		//Test set and get for coordinate col and row.
		co.setCol(2);
		co.setRow(2);
		co1.setCol(3);
		co1.setRow(3);
		assertTrue(co.getCol()==2&&co.getRow()==2&&co1.getCol()==3&&co1.getRow()==3);
		
		
	}

}
