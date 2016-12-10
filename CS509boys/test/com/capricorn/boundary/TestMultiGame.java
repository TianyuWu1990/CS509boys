package com.capricorn.boundary;

import com.capricorn.entity.Model;
import com.capricorn.view.Application;
import com.capricorn.view.MultiGame;

import junit.framework.TestCase;

public class TestMultiGame extends TestCase{
	
	public void testprocess() throws Exception{
		Model model = new Model();
		Application app = new Application(model);
		MultiGame mult = new MultiGame(model, app);
		mult.setVisible(true);
		assertTrue(mult.isVisible());

		}

}
