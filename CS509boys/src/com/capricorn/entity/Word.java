package com.capricorn.entity;

// TODO: Auto-generated Javadoc
/**
 * Basic entity word with no more description Two attributes
 * content and score
 * @author Chen Li, Dongsheng Wang, Yu Li, Tianyu Wu, Bowen Sun
 */
public class Word {

	/** The content. */
	private String content;

	/** The score. */
	private long score;

	/** The word selected time. */
	private String wordSelectedTime;

	/** Construct Word object to use default port number. */
	public Word() {
		this.score = 0;
		this.content = "";

	}

	/**
	 * Instantiates a new word.
	 *
	 * @param word
	 *            the word
	 * @param wordScore
	 *            the word score
	 * @param time
	 *            the time
	 */
	public Word(String word, long wordScore, String time) {
		this.content = word;
		this.score = wordScore;
		this.wordSelectedTime = time;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the word selected time.
	 *
	 * @return the word selected time
	 */
	public String getWordSelectedTime() {
		return wordSelectedTime;
	}

	/**
	 * Sets the word selected time.
	 *
	 * @param wordSelectedTime
	 *            the new word selected time
	 */
	public void setWordSelectedTime(String wordSelectedTime) {
		this.wordSelectedTime = wordSelectedTime;
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content.
	 *
	 * @param content
	 *            the new content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Sets the score.
	 *
	 * @param score
	 *            the new score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public long getScore() {
		return score;
	}
}
