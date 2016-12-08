package com.capricorn.entity;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * Create a player.
 */
public class Player {
	
	/** The name. */
	String name;
	
	/** The score. */
	long score;
    
    /** The position. */
    String	position;
    
    /** The is manager. */
    boolean isManager;
    
    /** The word score. */
    long wordScore;

/**
 * Gets the word score.
 *
 * @return the word score
 */
public long getWordScore() {
		return wordScore;
	}
	
	/**
	 * Sets the word score.
	 *
	 * @param wordScore the new word score
	 */
	public void setWordScore(long wordScore) {
		this.wordScore = wordScore;
	}

/**
 * Checks if is manager.
 *
 * @return true, if is manager
 */
public boolean isManager() {
		return isManager;
	}
	
	/**
	 * Sets the manager.
	 *
	 * @param isManager the new manager
	 */
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

/**
 * Instantiates a new player.
 *
 * @param name the name
 * @param score the score
 * @param position the position
 */
public Player(String name, long score, String position) {
		super();
		this.name = name;
		this.score = score;
		this.position = position;
	}

/**
 * Instantiates a new player.
 */
public Player(){
}



/**
 * Gets the position.
 *
 * @return the position
 */
public String getPosition() {
		return position;
	}
	
	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	//	board;
//	List PlayerInformation;
/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	//	List<Player> PlayerInformations;
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public long getScore() {
		return score;
	}

/**
 * Sets the name.
 *
 * @param name the new name
 */
public void setName(String name) {
		this.name = name;
	}
	//	public List getPlayerInformation() {
//		return PlayerInformation;
//	}
//	public List<Player> getPlayerInformations() {
//		return PlayerInformations;
/**
	 * Sets the score.
	 *
	 * @param score the new score
	 */
	//	}
	public void setScore(long score) {
		this.score = score;
	}


}
