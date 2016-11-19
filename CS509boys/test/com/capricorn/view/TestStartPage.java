package com.capricorn.view;

import com.capricorn.entity.Player;
import com.capricorn.model.Model;

public class TestStartPage {
/**main function the start the single game*/
	public static void main(String[] args) {
		//Model m = new Model();
		// TODO Auto-generated method stub
		Player p1=new Player();
		p1.setName("zhangsan");
		p1.setScore(90);
		Player p2=new Player();
		p2.setName("lisi");
		p2.setScore(78);
		Player p3=new Player();
		p3.setName("wangwu");
		p3.setScore(96);
		Model model=new Model();
		model.getGame().addPlayersInformation(p1);
		model.getGame().addPlayersInformation(p2);
		model.getGame().addPlayersInformation(p3);
		
		Application app=new Application(model);
		app.setVisible(true);
		
}
}
