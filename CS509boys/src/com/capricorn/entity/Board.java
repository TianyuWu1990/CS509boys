package com.capricorn.entity;

import java.util.ArrayList;
import java.util.List;

/**As defined, the size of the board should be 4-letters'-long and 4-letters'-wide.
  *Applying cell to generate a 4*4 board with 16 letters.
  */
public class Board {
public Cell cells[][] = new Cell[4][4];
private ArrayList<Cell> chosenCells;
private Word word=new Word();
private int     globalStartingCol;
private int     globalStartingRow;
private Integer requestColChange;
private Integer requestRowChange;
private String  bonusCell;
private int[] overlapTimes=new int[16];
//private List<String> boardPositionList=new ArrayList<String>();

public int[] getOverlapTimes() {
	return overlapTimes;
}


public String getBonusCell() {
	return bonusCell;
}

public void setBonusCell(String bonusCell) {
	this.bonusCell = bonusCell;
}

public Integer getRequestColChange() {
	return requestColChange;
}

public void setRequestColChange(Integer requestColChange) {
	this.requestColChange = requestColChange;
}

public Integer getRequestRowChange() {
	return requestRowChange;
}

public void setRequestRowChange(Integer requestRowChange) {
	this.requestRowChange = requestRowChange;
}

/**SetLetter method to fill in the cell with different words*/
public void setcellArrayForPractice(){
	for(int i=0;i<4;i++){
		for(int j=0;j<4;j++){
			cells[i][j] = new Cell();
			cells[i][j].setLetterForPractice();
		}
	}
}
/**Method is used to reset the overlapTimes matrix to 0*/
public void resetoverlapTimes(){
	for(int i=0;i<16;i++)
	this.overlapTimes[i]=0;
}

/**Construct Board object to use default port number.*/
public Board(){
	globalStartingCol=1;
	globalStartingRow=1;
	chosenCells = new ArrayList<Cell>();
	word = new Word();
	
	for(int i = 1; i < 5 ; i++){
		for(int j = 1; j < 5; j++){
			
		    Coordinate localCoordinate=new Coordinate(j,i);
		    Coordinate globalCoordinate=new Coordinate(j,i);
			Cell cell = new Cell();
			cell.setLocalCoordinate(localCoordinate);
			cell.setGlobalCoordinate(globalCoordinate);
			
			this.cells[i-1][j-1]=cell;
			int index=(i-1)*4+j-1;
			overlapTimes[index]=0;
		}
	}
}

/**update board **/
public void updateBoard(int newStartingCol, int newStaringRow, String NewBoardInfo){
	this.globalStartingCol = newStartingCol;
	this.globalStartingRow = newStaringRow;
	
	for(int i=0;i<4;i++){
		for (int j=0;j<4;j++){
           int x=globalStartingCol+j;
           int y=globalStartingRow+i;
           Coordinate globalCoordinate=new Coordinate(x,y);
           cells[i][j].setGlobalCoordinate(globalCoordinate);
	}
		}
	
	

	updateBoardByAllLetters(NewBoardInfo);
}

private void updateBoardByAllLetters(String cellsLetters){
	
	String[] cellInforList = cellsLetters.split(",");
	
	for(int i = 0; i < 16; i++){
		int row=i/4;
		int col=i%4;
		
			cells[row][col].setLetter(cellInforList[i]);
	}
}


public String getBoardInfo(){
	String allCellLetters = "";
	for(int i=0;i<4;i++){
		for (int j=0;j<4;j++){
			if (cells[i][j].getLetter().equals("Qu")){
				allCellLetters+="Q";
			}
			else{
			allCellLetters+=cells[i][j].getLetter();
			}
	}
		}
	return allCellLetters;
}

public ArrayList<Cell> getChosenCells() {
	return chosenCells;
}

public void setChosenCells(ArrayList<Cell> chosenCells) {
	this.chosenCells = chosenCells;
}

public Word getWord() {
	return word;
}

public void setWord(Word word) {
	this.word = word;
}

public int getGlobalStartingCol() {
	return globalStartingCol;
}

public void setGlobalStartingCol(int globalStartingCol) {
	this.globalStartingCol = globalStartingCol;
}

public int getGlobalStartingRow() {
	return globalStartingRow;
}

public void setGlobalStartingRow(int globalStartingRow) {
	this.globalStartingRow = globalStartingRow;
}

public Cell[][] getCells() {
	return cells;
}
public String getChosenCellsXMLString(){
	String chosenCellsString = "";
	for(Cell cell:chosenCells){
			chosenCellsString += String.format("<cell position='%s,%s' letter='%s'/>", 
					String.valueOf(cell.getGlobalCoordinate().col), 
					String.valueOf(cell.getGlobalCoordinate().row), 
					cell.getLetter());			
	}
	return chosenCellsString;
		}
	

public void addToChosenCellsByIndex(int ChosenCellIndex){
		int row=ChosenCellIndex/4;
		int col=ChosenCellIndex%4;
		chosenCells.add(cells[row][col]);
		cells[row][col].setSelected(true);
		word.setContent(getChosenCellsLetters());
		

}
public String getChosenCellsLetters(){
	String chosenLetters = "";
	for(Cell cell : chosenCells)
			chosenLetters += cell.getLetter(); 
	return chosenLetters;
}
public void clearChosenCells(){
	for(Cell cell : chosenCells){
		cell.setSelected(false);
	}
	chosenCells.removeAll(chosenCells);
}
public static List<String> setBoardPositionList(String plocation){
	 int startX=Integer.parseInt(plocation.split(",")[0]);
	 int startY=Integer.parseInt(plocation.split(",")[1]);
	List<String> locationList=new ArrayList<String>();
	for(int i=0;i<4;i++){
for(int j=0;j<4;j++){
	int x=startX+j;
	int y=startY+i;
	String location=x+","+y;
	locationList.add(location);
	
	
	

}
	}
	return locationList;
	
}

//public void setOverlapTimes(String plocation,List<String> playersLocation){
//  int ownx=Integer.parseInt(plocation.split(",")[0]);
//  int owny=Integer.parseInt(plocation.split(",")[1]);
//  for(String location:playersLocation){
//	  int otherx=Integer.parseInt(location.split(",")[0]);
//	  int othery=Integer.parseInt(location.split(",")[1]);
//	  if(ownx-otherx<4&&ownx-otherx>-4&&owny-othery<4&&owny-othery>-4){
//      for(int i=othery;i<owny+4;i++){
//    	  for(int j=otherx;j<ownx+4;j++){
//    		  System.out.println("i"+i);
//    		  System.out.println("j"+j);
//    		  int index=(i-owny)*4+(j-ownx);
//    		  System.out.println(index);
//    		     this.overlapTimes[index]+=1;
//    	  }
//      }
//     
//  
//
//
//
//}
//}
//}
public static void main(String[] args) {
	
//	Board board=new Board();
//	String plocation="2,2";
//	String pl="2,3";
//	List<String> list=board.setBoardPositionList(plocation);
//	for(String str:list)
//	System.out.println(str);
	
//	String pl1="2,2";
//	List<String> playersLocation=new ArrayList<String>();
//	playersLocation.add(pl);
//	playersLocation.add(pl1);
//	
//	board.setOverlapTimes(plocation, playersLocation);
//	for(int t:board.overlapTimes){
//		System.out.println(t);
//	}
}
}





	

