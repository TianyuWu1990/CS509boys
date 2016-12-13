package com.capricorn.entity;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
/**
 * @author yli14, Tianyu Wu
 * This is for test 'SetBoardPositionList' in entity 'Board'
 */
public class TestSetBoardPositionList extends TestCase{
	
	Board board = new Board();
	/** Test the entity 'Board'.*/
	public void testsetBoardPositionList(){

		List<String> tbp = board.setBoardPositionList("2,3");
		List<String> result = new ArrayList<String>();
		result.add("2,3");

		assertTrue(tbp.contains("5,6"));
		
		
	}

}
