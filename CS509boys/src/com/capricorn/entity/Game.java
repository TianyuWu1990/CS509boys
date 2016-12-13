package com.capricorn.entity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Game including all the attributes.
 * @author Chen Li, Dongsheng Wang, Yu Li, Tianyu Wu, Bowen Sun
 */
public class Game {
	
	/** The game id. */
	private String gameId;

	/** The managing user. */
	private String managingUser;
	
	/** The players information. */
	private List<Player> playersInformation; 
	
	/** The is locked. */
	private boolean isLocked;
	
	/** The players location. */
	private List<String> playersLocation;
	
	/** The selected word list. */
	private List<Word> selectedWordList;
	

	
	/**
	 * Gets the selected word.
	 *
	 * @return the selected word
	 */
	public List<Word> getSelectedWord() {
		
		return selectedWordList;
	}
	
	/**
	 * Sets the selected word.
	 *
	 * @param selectedWord the new selected word
	 */
	public void setSelectedWord(List<Word> selectedWord) {
		this.selectedWordList = selectedWord;
	}
	
	/**
	 * Instantiates a new game.
	 */
	public Game() {
		gameId = "";
		managingUser = "";
		isLocked = false;
		playersInformation = new LinkedList<Player>();
		selectedWordList=new ArrayList<Word>();
		playersLocation=new ArrayList<String>();
	}
	
	/**
	 * Gets the game id.
	 *
	 * @return the game id
	 */
	public String getGameId() {
		return gameId;
	}

	/**
	 * Gets the managing user.
	 *
	 * @return the managing user
	 */
	public String getManagingUser() {
		return managingUser;
	}
	
	/**
	 * Sets the managing user.
	 *
	 * @param managingUser the new managing user
	 */
	public void setManagingUser(String managingUser) {
		this.managingUser = managingUser;
	}
	
	/**
	 * Checks if is locked.
	 *
	 * @return true, if is locked
	 */
	public boolean isLocked() {
		return isLocked;
	}
	
	/**
	 * Sets the locked.
	 *
	 * @param isLocked the new locked
	 */
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	
	/**
	 * Sets the game id.
	 *
	 * @param gameId the new game id
	 */
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	
	/**
	 * Gets the players information.
	 *
	 * @return the players information
	 */
	public List<Player> getPlayersInformation(){
		
		
		return playersInformation;
		
	}
	
	/**
	 * Sets the players information.
	 *
	 * @param playersInformation the new players information
	 */
	public void setPlayersInformation(List<Player> playersInformation) {
		this.playersInformation=playersInformation;
		
	}
	
	/**
	 * Gets the players list by score.
	 *
	 * @return the players list by score
	 */
	@SuppressWarnings("unchecked")
	public List<Player> getPlayersListByScore(){
		Comparator<Object> comparator =new Comparator<Object>(){
			@Override
			public int compare(Object o1,Object o2){
	           if(o1 instanceof Player&& o2 instanceof Player){
	        	   Player p1=(Player) o1;
	        	   Player p2=(Player) o2;
	        	   return -( p1.getScore()-p2.getScore()>0?1: (p1.getScore()==p2.getScore()?0:-1));
	        	   }
	           return 0;
	           }
		
			
		};
		Collections.sort(this.playersInformation, comparator);   
		return playersInformation;
		
	}
	
	/**
	 * Clear players information.
	 */
	public void clearPlayersInformation() {
		playersInformation.clear();
		
	}
	
	/**
	 * Gets the playerslocation.
	 *
	 * @return the playerslocation
	 */
	public List<String> getPlayerslocation() {
		return playersLocation;
	}
	
	
}

