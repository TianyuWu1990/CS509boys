package com.capricorn.entity;
/**As defined, the size of the board is should be 4-letters'-long and 4-letters'-wide.
  *Applying cell to generate a 4*4 board with 16 letters in it.
  */
public class Board {
public Cell letterArray[][] = new Cell[4][4];
/**SetLetter method to fill in the cell with different word*/
public void setcellArray(){
	for(int i=0;i<4;i++){
		for(int j=0;j<4;j++){
			letterArray[i][j] = new Cell();
			letterArray[i][j].setLetter();
		}
	}
}
public void updateBoard(){
	
}
}
