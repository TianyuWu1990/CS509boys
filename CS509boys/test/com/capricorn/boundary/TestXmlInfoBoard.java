package com.capricorn.boundary;

import com.capricorn.entity.Model;
import com.capricorn.view.Application;
import com.capricorn.view.MultiGame;
import com.capricorn.view.XmlInfoBoard;

import junit.framework.TestCase;

public class TestXmlInfoBoard extends TestCase{
	
	public void testprocess() throws Exception{
		XmlInfoBoard xml = new XmlInfoBoard();
		xml.setVisible(true);
		assertTrue(xml.isVisible());

		}

}
