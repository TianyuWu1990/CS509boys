package com.capricorn.entity;
/**Basic entity word with no more description
 *Two attributes content(a,b,c,d......) and score  
 */
public class Word {
	private String content;
    private long score;
    private String wordSelectedTime;
    
    
/**Construct Word object to use default port number.*/
	public Word(){
		this.score = 0;
		this.content = "";
		
		
	}
   public Word(String word, long wordScore, String time) {
	   this.content=word;
	   this.score=wordScore;
	   this.wordSelectedTime=time;
	// TODO Auto-generated constructor stub
}
	public String getWordSelectedTime() {
	return wordSelectedTime;
}
public void setWordSelectedTime(String wordSelectedTime) {
	this.wordSelectedTime = wordSelectedTime;
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
	
	public long getScore() {
		return score;
	}
}
