package com.capricorn.entity;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class TestSetBoardPositionList extends TestCase{
	
	Board board = new Board();
	
	public void testsetBoardPositionList(){

		List<String> tbp = board.setBoardPositionList("2,3");
		List<String> result = new ArrayList<String>();
		result.add("2,3");

		assertTrue(tbp.contains("5,6"));
		
		
	}

}
