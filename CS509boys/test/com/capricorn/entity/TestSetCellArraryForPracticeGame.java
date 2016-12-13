package com.capricorn.entity;

import java.util.ArrayList;
/**
 *Test for all elements in entity
 */
import java.util.List;

import junit.framework.TestCase;
/**
 * @author yli14, Tianyu Wu
 * This is for test 'SetCellArraryForPracticeGame' in entity 'PracticeGame'
 */
public class TestSetCellArraryForPracticeGame extends TestCase {
		/** Test the 'SetCellArraryForPracticeGame'. */
		public void testsetcellArrayForPractice(){
			Board board = new Board();
			Board board1 = new Board();
		
			board.setcellArrayForPractice();
			board1.setcellArrayForPractice();

			assertTrue(board.getCells()!=board1.getCells());
			
			
		}
}
