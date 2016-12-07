package com.capricorn.model;

import com.capricorn.entity.Board;
import com.capricorn.entity.Game;
import com.capricorn.entity.Player;
// TODO: Auto-generated Javadoc

/**
 * The model part contains everything on the board except for the request and response
 * The information including the model, the game, the game board, the player
 * If we define a model M, M need to cover all the things following.
 */
public class Model {
	
	/** The model. */
	static Model model=null;              //define a default null to model
	
	/** The game. */
	public Game game=new Game();
	
	/** The board. */
	public Board board=new Board();
	
	/** The player. */
	public Player player = new Player();
	
	/**
	 * Gets the game.
	 *
	 * @return the game
	 */
	public Game getGame(){
		
		return game;
	}
	
	/**
	 * Instantiates a new model.
	 */
	public Model(){
		
//       board.setcellArrayForPractice();
	}
	
	/**
	 * Gets the single instance of Model.
	 *
	 * @return single instance of Model
	 */
	public static Model getInstance() {
		if (model == null) {
			model = new Model();
		}
		
		return model;
	}
	
	/**
	 * get the board method *.
	 *
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}
	
	/**
	 * get the player method*.
	 *
	 * @return the player
	 */
	public Player getPlayer(){
		return player;
	}
	
	/**
	 * Update model.
	 *
	 * @param gameID the game ID
	 * @param managingUser the managing user
	 * @param playerName the player name
	 * @param newStartingCol the new starting col
	 * @param newStaringRow the new staring row
	 * @param boardInfo the board info
	 * @param score the score
	 * @param bonusCell the bonus cell
	 */
	public void updateModel(String gameID, String managingUser, String playerName, int newStartingCol, int newStaringRow,
			String boardInfo, long score, String bonusCell) {
		this.game.setGameId(gameID);       //entity.game.setGameId
		this.player.setName(playerName);   //entity.player.setName
		this.player.setScore(score);       //entity.player.setScore
		this.game.setManagingUser(managingUser);
		//figure out if the people is the manager or not 
		if (managingUser.equals(this.player.getName())) {
			this.player.setManager(true);
		}
		this.board.updateBoard(newStartingCol, newStaringRow, boardInfo);//a method in the entity.board
		this.board.setRequestColChange(0);//??????????????????????????
		this.board.setRequestRowChange(0);//??????????????????????????
		this.board.setBonusCell(bonusCell);//use the setBonusCell method 
		
	}
	
	/**
	 * Reset game.
	 */
	public void resetGame(){
		getPlayer().setScore(0);
		getBoard().clearChosenCells();
		
	}

	
	

}