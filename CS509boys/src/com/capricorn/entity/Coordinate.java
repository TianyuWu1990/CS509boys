package com.capricorn.entity;


// TODO: Auto-generated Javadoc
/**
 * The Class Coordinate.
 *@author Chen Li, Yu Li, Tianyu Wu, Bowen Sun
 */
public class Coordinate {

/** The col. */
int col;

/** The row. */
int row;

/**
 * Instantiates a new coordinate.
 */
public Coordinate(){
	this.col=0;
	this.row=0;
}


public Coordinate(int col,int row){
/**
 * Instantiates a new coordinate.
 *
 * @param col the col
 * @param row the row
 */
	this.col=col;
	this.row=row;
}

/**
 * Gets the col.
 *
 * @return the col
 */
public int getCol() {
	return col;
}

/**
 * Sets the col.
 *
 * @param col the new col
 */
public void setCol(int col) {
	this.col = col;
}

/**
 * Gets the row.
 *
 * @return the row
 */
public int getRow() {
	return row;
}

/**
 * Sets the row.
 *
 * @param row the new row
 */
public void setRow(int row) {
	this.row = row;
}
}
