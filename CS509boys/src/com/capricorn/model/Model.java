package com.capricorn.model;

import com.capricorn.entity.Board;
import com.capricorn.entity.Game;
import com.capricorn.entity.Player;



public class Model {
	static Model model=null;
	public Game game=new Game();
	public Board board=new Board();
	public Player player = new Player();
	public Game getGame(){
		
		return game;
	}
	public Model(){
		
       board.setcellArrayForPractice();
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
	public Player getPlayer(){
		return player;
	}
	public void updateModel(){
		
	}
	
	

}