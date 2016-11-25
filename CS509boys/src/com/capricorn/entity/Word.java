package com.capricorn.entity;
/**Basic entity word with no more description
 *Two attributes content(a,b,c,d......) and score  
 */
public class Word {
	private String content;
    private int score;
    
/**Construct Word object to use default port number.*/
	public Word(){
		this.score = 0;
		this.content = "";
		
	}
   //get and set
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
