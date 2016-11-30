package com.capricorn.entity;

import java.util.ArrayList;
/**
 *Test for all elements in entity
 */
import java.util.List;

import junit.framework.TestCase;

public class TestBoard extends TestCase {
	Board board = new Board();
	Board board1 = new Board();
			
	public void testsetcellArrayForPractice(){
		board.setcellArrayForPractice();
		board1.setcellArrayForPractice();

		//Two Array of cells should be different because we generate them randomly.
		assertTrue(board.cells!=board1.cells);
		
		
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
		//Test Get BoardInfo
		
		String tbi=board.getBoardInfo();
		
		System.out.println("BoardInformation(allCellletters) are"+tbi);
	}
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
	public void testsetBoardPositionList(){
		
//		x+","+y;
		List<String> tbp = board.setBoardPositionList("2,3");
		List<String> result = new ArrayList<String>();
		result.add("2,3");
		
//		System.out.println("tbp is");
//		for(int i=0;i<tbp.size();i++){
//			System.out.println(tbp.get(i));
//		}
		assertTrue(tbp.contains("5,6"));
		
		
	}
	public void testaddToChosenCellsByIndex(){
		String a = ("AbcegwdladAbceQw");
		
		board.updateBoard(3,2,a);
		//row=4/4=1,col=4%4=0.
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
//		System.out.println("after remove "+board.getChosenCells());
//		Result is an empty List, and change all selected cells state to unselected.
		assertEquals(board.getChosenCells(),ce);
		assertFalse(board.cells[1][0].isSelected());
		
	}
	public void testPlayer(){
		//get and set
			Player pl=new Player();		
			pl.setManager(true);
			pl.setName("lee");
			pl.setScore(100);
			pl.setPosition("2,3");
			assertTrue(pl.isManager());
			assertEquals(pl.getName(),"lee");
			assertEquals(pl.getScore(),100);
			assertEquals(pl.getPosition(),"2,3");
			
		}
	public void testGame(){
		//Test get and set.
		Game game = new Game();
		game.playersLocation=new ArrayList();
		Player p1 = new Player();
		Player p2 = new Player();
		p1.setName("lee");
		p1.setScore(65);
		p2.setName("son");
		p2.setScore(55);
		game.setGameId("g1");
		p1.setPosition("2,3");
		p2.setPosition("3,4");
		
		game.playersLocation.add(p1.getPosition());
		game.playersLocation.add(p2.getPosition());
		assertTrue(game.getPlayerslocation().contains("2,3")&&game.getPlayerslocation().contains("3,4"));
		assertTrue(game.getGameId()=="g1");
		game.playersInformation.add(p1);
		game.playersInformation.add(p2);
		//Test lock game.
		game.setLocked(true);
			
		assertTrue(game.isLocked());
		game.setManagingUser(p1.getName());
		assertTrue(game.getManagingUser()=="lee");
		game.setPlayersInformation(game.playersInformation);
		assertEquals(game.getPlayersInformation().size(),2);
		game.getPlayersListByScore();
		assertTrue(game.playersInformation.get(0).name=="lee");
		
		p1.setScore(45);
		game.getPlayersListByScore();
		//after change lee's score, his rank shoud be 2,and Son should be 1
		assertTrue(game.playersInformation.get(0).name=="son");
		
		assertTrue(game.playersInformation.get(0).getScore()>game.playersInformation.get(1).getScore());
		//clear all Players' informations
		game.clearPlayersInformation();
		assertEquals(game.getPlayersInformation().size(),0);
			
			
		}
	public void testSetandget(){
		board.setBonusCell("A");
		assertTrue(board.getBonusCell()=="A");
		board.setRequestColChange(3);
		assertTrue(board.getRequestColChange()==3);
		board.setRequestRowChange(4);
		assertTrue(board.getRequestRowChange()==4);
	}
	
	
}

