package com.capricorn.entity;
import junit.framework.TestCase;
/**
 * @author yli14, Tianyu Wu
 * This is for test 'Word' in entities
 */
public class TestWord extends TestCase{
	/** Test the entity 'Word'.*/
	public void testWord(){
		Word word1=new Word("word", 500, "11.23");
		assertEquals(word1.getContent(),"word");
		assertEquals(word1.getScore(),500);
		assertEquals(word1.getWordSelectedTime(),"11.23");
		Word word2=new Word();
		word2.setScore(50);
		word2.setWordSelectedTime("12.23");
		word2.setContent("wet");
		assertEquals(word2.getContent(),"wet");
		assertEquals(word2.getScore(),50);
		assertEquals(word2.getWordSelectedTime(),"12.23");
		
		
	}

}
