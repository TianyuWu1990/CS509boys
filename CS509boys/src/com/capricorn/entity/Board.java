package com.capricorn.entity;


import java.util.ArrayList;

import com.capricorn.entity.Coordinate;
import com.capricorn.entity.Word;

/**As defined, the size of the board is should be 4-letters'-long and 4-letters'-wide.
  *Applying cell to generate a 4*4 board with 16 letters in it.
  */
public class Board {
public Cell cells[][] = new Cell[4][4];
private ArrayList<Cell> chosenCells;
private Word word;

/**SetLetter method to fill in the cell with different word*/
public void setcellArrayForPractice(){
	for(int i=0;i<4;i++){
		for(int j=0;j<4;j++){
			cells[i][j] = new Cell();
			cells[i][j].setLetterForPractice();
		}
	}
}

public Board(){
	
	chosenCells = new ArrayList<Cell>();
	word = new Word();
	
	for(int i = 1; i < 5 ; i++){
		for(int j = 1; j < 5; j++){
			
		    Coordinate localCoordinate=new Coordinate(i,j);
		    Coordinate globalCoordinate=new Coordinate(i,j);
			Cell cell = new Cell();
			cell.setLocalCoordinate(localCoordinate);
			cell.setGlobalCoordinate(globalCoordinate);
			
			this.cells[i-1][j-1]=cell;
		}
	}
}
public void updateBoard(){
	
}
}

