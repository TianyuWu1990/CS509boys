package com.capricorn.entity;


public class Coordinate {
int col;
int row;
public Coordinate(){
	this.col=0;
	this.row=0;
}
public Coordinate(int col,int row){
	this.col=col;
	this.row=row;
}

public int getCol() {
	return col;
}
public void setCol(int col) {
	this.col = col;
}
public int getRow() {
	return row;
}
public void setRow(int row) {
	this.row = row;
}
}
