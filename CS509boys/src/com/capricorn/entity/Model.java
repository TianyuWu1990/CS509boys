package com.capricorn.entity;

/**
 * The model part contains everything on the board except for the request and response
 * The information including the model, the game, the game board, the player
 * If we define a model M, M need to cover all the things following.
 *  @author Chen Li
 */
public class Model {
	
	/** The model. */
	static Model model=null;              
	
	/** The game. */
	private Game game=new Game();
	
	/** The board. */
	private Board board=new Board();
	
	/** The player. */
	private Player player = new Player();
	
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
		this.game.setGameId(gameID);       
		this.player.setName(playerName);   
		this.player.setScore(score);       
		this.game.setManagingUser(managingUser);
		 
		if (managingUser.equals(this.player.getName())) {
			this.player.setManager(true);
		}
		this.board.updateBoard(newStartingCol, newStaringRow, boardInfo);
		this.board.setRequestColChange(0);
		this.board.setRequestRowChange(0);
		this.board.setBonusCell(bonusCell);
		
	}
	
	/**
	 * Reset game.
	 */
	public void resetGame(){
		getPlayer().setScore(0);
		getBoard().clearChosenCells();
		
	}

	
	

}