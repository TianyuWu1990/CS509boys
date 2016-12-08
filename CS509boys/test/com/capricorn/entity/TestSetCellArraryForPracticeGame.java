package com.capricorn.entity;

import java.util.ArrayList;
/**
 *Test for all elements in entity
 */
import java.util.List;

import junit.framework.TestCase;

public class TestSetCellArraryForPracticeGame extends TestCase {
				
		public void testsetcellArrayForPractice(){
			Board board = new Board();
			Board board1 = new Board();
		
			board.setcellArrayForPractice();
			board1.setcellArrayForPractice();

			//Two Array of cells should be different because we generate them randomly.
			assertTrue(board.cells!=board1.cells);
			
			
		}
}
