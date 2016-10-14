package com.capricorn.entity;

public class Board {
public Cell letterArray[][] = new Cell[4][4];

public void setcellArray(){
	for(int i=0;i<4;i++){
		for(int j=0;j<4;j++){
			letterArray[i][j] = new Cell();
			letterArray[i][j].setLetter();
		}
	}
}
}
