package com.capricorn.entity;


public class Word {
	private String content;
    private int score;
    

	public Word(){
		this.score = 0;
		this.content = "";
		
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
}
