package com.capricorn.boundary;
import com.capricorn.entity.Model;
import com.capricorn.view.Application;
import com.capricorn.view.MultiGame;
import com.capricorn.view.PracticeGame;
import junit.framework.TestCase;

public class TestPracticeGame extends TestCase {
	public void testprocess() throws Exception{
		Model model = new Model();
		Application app = new Application(model);
		PracticeGame prac = new PracticeGame(model);
		prac.setVisible(true);
		assertTrue(prac.isVisible());

		}
    
}
