package com.capricorn.entity;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * Create a player who play the game.
 * @author Chen Li, Dongsheng Wang, Yu Li, Tianyu Wu, Bowen Sun
 */
public class Player {
	
	/** The name. */
	private String name;
	
	/** The score. */
	private long score;
    
    /** The position. */
    private String	position;
    
    /** The is manager. */
    private boolean isManager;
    
    /** The word score. */
    private long wordScore;

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

/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	
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

/**
	 * Sets the score.
	 *
	 * @param score the new score
	 */
	
	public void setScore(long score) {
		this.score = score;
	}


}
