package com.capricorn.entity;

import junit.framework.TestCase;
/**
 * @author yli14
 * This is for test entity 'Model'.
 */
public class TestModel extends TestCase{
	/**Test the 'Model'*/
	public void testModel(){
			Model model=new Model();	
			model.updateModel("g123", "chen", "lee", 1, 2, "a,b,c,d,f,g,t,r,e,u,i,s,g,f,d,r" ,500, "3,1");
			
			assertEquals(model.getGame().getGameId(),"g123");
			assertEquals(model.getGame().getManagingUser(),"chen");
			assertEquals(model.getPlayer().getName(),"lee");
			assertEquals(model.getBoard().getGlobalStartingCol(),1);
			assertEquals(model.getBoard().getGlobalStartingRow(),2);
			assertEquals(model.getBoard().getBoardInfo(),"abcdfgtreuisgfdr");
			assertEquals(model.getPlayer().getScore(),500);
			assertEquals(model.getBoard().getBonusCell(),"3,1");
			model.resetGame();
			assertEquals(model.getPlayer().getScore(),0);
			assertEquals(model.getBoard().getChosenCellsLetters(),"");
			Model model2=Model.getInstance();
			Model model3=Model.getInstance();
			assertEquals(model2,model3);
			
			
			
			
		}
	

}
