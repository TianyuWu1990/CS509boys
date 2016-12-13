package com.capricorn.entity;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**As defined, the size of the board should be 4-letters'-long and 4-letters'-wide.
  *Applying cell to generate a 4*4 board with 16 letters.
  *The Board entity is the most important entity in the program as the board 
  *contains huge amount of methods to balance the request and response. 
  *Also, the need to relate other entities makes this more complex. 
  *Board the also a brief introduction to the practice game and multiple player game,
  *which has to set all the details clearly.
  *@author Dongsheng Wang, Chen Li, Yu Li, Tianyu Wu, Bowen Sun
  */
public class Board {

/** The cells. */
private Cell cells[][] = new Cell[4][4];

/** The chosen cells. */
private ArrayList<Cell> chosenCells;

/** The word. */
private Word word=new Word();

/** The global starting col. */
private int     globalStartingCol;

/** The global starting row. */
private int     globalStartingRow;

/** The request color change. */
private Integer requestColChange;

/** The request row change. */
private Integer requestRowChange;

/** The bonus cell. */
private String  bonusCell;

/** The overlap times. */
private int[] overlapTimes=new int[16];


/**
 * Gets the overlap times.
 *
 * @return the overlap times
 */
public int[] getOverlapTimes() {
	return overlapTimes;
}


/**
 * Gets the bonus cell.
 *
 * @return the bonus cell
 */
public String getBonusCell() {
	return bonusCell;
}

/**
 * Sets the bonus cell.
 *
 * @param bonusCell the new bonus cell
 */
public void setBonusCell(String bonusCell) {
	this.bonusCell = bonusCell;
}

/**
 * Gets the request color change.
 *
 * @return the request color change
 */
public Integer getRequestColChange() {
	return requestColChange;
}

/**
 * Sets the request color change.
 *
 * @param requestColChange the new request color change
 */
public void setRequestColChange(Integer requestColChange) {
	this.requestColChange = requestColChange;
}

/**
 * Gets the request row change.
 *
 * @return the request row change
 */
public Integer getRequestRowChange() {
	return requestRowChange;
}

/**
 * Sets the request row change.
 *
 * @param requestRowChange the new request row change
 */
public void setRequestRowChange(Integer requestRowChange) {
	this.requestRowChange = requestRowChange;
}

/**
 * SetLetter method to fill in the cell with different words.
 */
public void setcellArrayForPractice(){
	for(int i=0;i<4;i++){
		for(int j=0;j<4;j++){
			cells[i][j] = new Cell();
			cells[i][j].setLetterForPractice();
		}
	}
}

/**
 * Method is used to reset the overlapTimes matrix to 0.
 */
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

/**
 * update board method to reposition the game area.
 *
 * @param newStartingCol the new starting color
 * @param newStaringRow the new staring row
 * @param NewBoardInfo the new board information
 */
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

/**
 * Renew the letters in the game.
 *
 * @param cellsLetters the cells letters
 */
private void updateBoardByAllLetters(String cellsLetters){
	
	String[] cellInforList = cellsLetters.split(",");
	
	for(int i = 0; i < 16; i++){
		int row=i/4;
		int col=i%4;
		
			cells[row][col].setLetter(cellInforList[i]);
	}
}


/**
 * Gets the board information.
 *
 * @return the board information
 */
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

/**
 * Gets the chosen cells.
 *
 * @return the chosen cells
 */
public ArrayList<Cell> getChosenCells() {
	return chosenCells;
}

/**
 * Sets the chosen cells.
 *
 * @param chosenCells the new chosen cells
 */
public void setChosenCells(ArrayList<Cell> chosenCells) {
	this.chosenCells = chosenCells;
}

/**
 * Gets the word.
 *
 * @return the word
 */
public Word getWord() {
	return word;
}

/**
 * Sets the word.
 *
 * @param word the new word
 */
public void setWord(Word word) {
	this.word = word;
}

/**
 * Gets the global starting color.
 *
 * @return the global starting color
 */
public int getGlobalStartingCol() {
	return globalStartingCol;
}

/**
 * Sets the global starting color.
 *
 * @param globalStartingCol the new global starting color
 */
public void setGlobalStartingCol(int globalStartingCol) {
	this.globalStartingCol = globalStartingCol;
}

/**
 * Gets the global starting row.
 *
 * @return the global starting row
 */
public int getGlobalStartingRow() {
	return globalStartingRow;
}

/**
 * Sets the global starting row.
 *
 * @param globalStartingRow the new global starting row
 */
public void setGlobalStartingRow(int globalStartingRow) {
	this.globalStartingRow = globalStartingRow;
}

/**
 * Gets the cells.
 *
 * @return the cells
 */
public Cell[][] getCells() {
	return cells;
}

/**
 * Gets the chosen cells XML string.
 *
 * @return the chosen cells XML string
 */
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
	

/**
 * Adds the to chosen cells by index.
 *
 * @param ChosenCellIndex the chosen cell index
 */
public void addToChosenCellsByIndex(int ChosenCellIndex){
		int row=ChosenCellIndex/4;
		int col=ChosenCellIndex%4;
		chosenCells.add(cells[row][col]);
		cells[row][col].setSelected(true);
		word.setContent(getChosenCellsLetters());
		

}

/**
 * Gets the chosen cells letters.
 *
 * @return the chosen cells letters
 */
public String getChosenCellsLetters(){
	String chosenLetters = "";
	for(Cell cell : chosenCells)
			chosenLetters += cell.getLetter(); 
	return chosenLetters;
}

/**
 * Clear chosen cells.
 */
public void clearChosenCells(){
	for(Cell cell : chosenCells){
		cell.setSelected(false);
	}
	chosenCells.removeAll(chosenCells);
}

/**
 * Identify the method to position the board.
 *
 * @param plocation the plocation
 * @return the list
 */
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



}





	

