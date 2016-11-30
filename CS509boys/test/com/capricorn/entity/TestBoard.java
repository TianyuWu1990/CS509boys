package com.capricorn.entity;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class TestBoard extends TestCase {
	Board board = new Board();
	public void testSetandget(){
		board.setBonusCell("A");
		assertTrue(board.getBonusCell()=="A");
		board.setRequestColChange(3);
		assertTrue(board.getRequestColChange()==3);
		board.setRequestRowChange(4);
		assertTrue(board.getRequestRowChange()==4);
	}
	 

//	String cells[][] = new String[][]{{"A","b","c","e"},
//			{"f","w","d","l"},
//			{"a","d","A","b"},
//			{"c","e","f","w"}
//	};
//			
	
	
	
	public void testsetcellArrayForPractice(){
		board.setcellArrayForPractice();
		for(int i=0;i<board.cells.length;i++){
			for(int j=0;j<board.cells.length;j++){
				System.out.println(board.cells[i][j].getLetter());
			}
		}
		
		
	}

	public void testupdateBoard(){

		board.setGlobalStartingCol(3);
		board.setGlobalStartingRow(4);
		
		String a = ("AbcefwdladAbceaQ");
		String c = ("AbcefwdladAbceaQU");
		String b="";
		board.updateBoard(board.getGlobalStartingCol(),board.getGlobalStartingRow(),a);
		
		assertTrue(board.getGlobalStartingCol()==3&&board.getGlobalStartingRow()==4);

		for(int i=0;i<board.cells.length;i++){
			for(int j=0;j<board.cells.length;j++){
				b +=board.cells[i][j].getLetter();
				System.out.println(board.cells[i][j].getLetter());
			}
		}
		assertEquals(b,c);
		
	 
	}
	public void testgetBoardInfo(){
		//?
		
		String tbi=board.getBoardInfo();
		
		System.out.println("BoardInformation(allCellletters) are"+tbi);
	}
	public void testgetChosenCellsXMLString(){
		//?
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
		
		System.out.println("tegc is"+result);
		assertEquals(result,"<cell position='3,4' letter='a'/><cell position='2,3' letter='Q'/>");
		
		
	}
	public void testsetBoardPositionList(){
		
//		x+","+y;
		List<String> tbp = board.setBoardPositionList("2,3");
		List<String> result = new ArrayList<String>();
		result.add("2,3");
		//?
		System.out.println("tbp is");
		for(int i=0;i<=tbp.size();i++){
			System.out.println(tbp.get(i));
		}
		
		
	}
	public void testaddToChosenCellsByIndex(){
		String a = ("AbcegwdladAbceQw");
		
		board.updateBoard(3,2,a);
		//col=0;row=1
		board.addToChosenCellsByIndex(4);
		String bgg = board.getWord().getContent();
		System.out.println("a="+bgg);
		System.out.println("cells are "+board.getCells()[1][0].getLetter());
		System.out.println("chosen cells are"+board.getChosenCells().size());
		assertTrue(board.cells[1][0].isSelected);
		assertEquals(bgg,"g");
		
		
	}
	public void testclearChosenCells(){
		String a = ("AacegwdladAbcefw");
		ArrayList<Cell> ce = new ArrayList<Cell>();
		board.updateBoard(3,2,a);
		board.addToChosenCellsByIndex(4);
		board.clearChosenCells();
		System.out.println("after remove "+board.getChosenCells());
		//?
		assertEquals(board.getChosenCells(),ce);
		assertFalse(board.cells[1][0].isSelected());
		
	}
}

