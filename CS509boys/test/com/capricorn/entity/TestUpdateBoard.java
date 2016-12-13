package com.capricorn.entity;

import java.util.ArrayList;
/**
 *Test for all elements in entity
 */
import java.util.List;

import junit.framework.TestCase;
/**
 * @author yli14
 * This is for test 'UpdateBoard' in entity 'Board'.
 */
public class TestUpdateBoard extends TestCase {
	
	Board board = new Board();
	/** Test the 'UpdateBoard' funtion.*/
	public void testupdateBoard(){

		board.setGlobalStartingCol(3);
		board.setGlobalStartingRow(4);
		
		String a = ("a,b,c,e,f,w,d,l,a,d,A,b,c,e,a,w");
		String b = "";
		board.updateBoard(board.getGlobalStartingCol(),board.getGlobalStartingRow(),a);
		
		assertTrue(board.getGlobalStartingCol()==3&&board.getGlobalStartingRow()==4);

		for(int i=0;i<board.getCells().length;i++){
			for(int j=0;j<board.getCells().length;j++){
				b += board.getCells()[i][j].getLetter();
				if(b.length() < 31){
					b += ",";
				}
			}
		}
		assertEquals(b,a);
		
	 
	}
}
