package com.capricorn.entity;
import com.capricorn.model.Model;
import junit.framework.TestCase;

public class ModelTest extends TestCase {
	Model m= new Model();
	
	public void modelTest(){
		
		m.updateModel("a", "jack", "Name", 2, 0,
				"Applicationintes", 23, "1,2");
	
		assertEquals(m.getGame().gameId,"a");
		assertEquals(m.getGame().getManagingUser(),"jack");
		assertEquals(m.getPlayer().getScore(),23);
		assertEquals(m.getPlayer().getName(),"Name");
		assertEquals(m.getBoard().getWord().getContent(),"Applicationines");
		assertEquals(m.getBoard().getBonusCell(),"1,2");
		assertEquals(m.getBoard().getGlobalStartingCol(),2);
		assertEquals(m.getBoard().getGlobalStartingRow(),0);	
		
		
	}

}
