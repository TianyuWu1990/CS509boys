package com.capricorn.model;

import com.capricorn.entity.Board;
import com.capricorn.entity.Game;
import com.capricorn.entity.Player;
/**The model part contains everything on the board except for the request and response
 * The information including the model, the game, the game board, the player
 * If we define a model M, M need to cover all the things following  
 */
public class Model {
	static Model model=null;              //define a default null to model
	public Game game=new Game();
	public Board board=new Board();
	public Player player = new Player();
	public Game getGame(){
		
		return game;
	}
	public Model(){
		
//       board.setcellArrayForPractice();
	}
	public static Model getInstance() {
		if (model == null) {
			model = new Model();
		}
		
		return model;
	}
	
	/**get the board method **/
	public Board getBoard() {
		return board;
	}
	
	/**get the player method**/
	public Player getPlayer(){
		return player;
	}
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
	public void resetGame(){
		getPlayer().setScore(0);
		getBoard().clearChosenCells();
		
	}

	
	

}