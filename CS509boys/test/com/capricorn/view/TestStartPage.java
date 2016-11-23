package com.capricorn.view;

import java.util.LinkedList;
import java.util.List;

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
		p1.setPosition("1,2");
		Player p2=new Player();
		p2.setName("lisi");
		p2.setScore(78);
		p2.setPosition("1,4");
		Player p3=new Player();
		p3.setName("wangwu");
		p3.setScore(96);
		p3.setPosition("4,5");
		Model model=new Model();
		List<Player> list=new LinkedList<Player>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		model.getGame().setPlayersInformation(list);
		
		Application app=new Application(model);
		app.setVisible(true);
		
}
}
