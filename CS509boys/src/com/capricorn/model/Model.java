package com.capricorn.model;

import com.capricorn.entity.Board;



public class Model {
	static Model model=null;
	public Board board=new Board();
	public Model(){
		
		board.setcellArray();
	}
	public static Model getInstance() {
		if (model == null) {
			model = new Model();
		}
		
		return model;
	}
	public Board getBoard() {
		return board;
	}
	
	

}