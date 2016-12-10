package com.capricorn.boundary;

import com.capricorn.entity.Model;
import com.capricorn.view.Application;

import junit.framework.TestCase;

public class TestApplication extends TestCase{
		
	public void testprocess() throws Exception{
	Model model = new Model();
	Application app = new Application(model);
	assertTrue(app.notHasPlayerName());
	assertTrue(app.notHasPlayerNameAndGameId());
	
	
	
	
	
	}
}
