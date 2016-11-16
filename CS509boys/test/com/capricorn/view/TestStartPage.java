package com.capricorn.view;

import javax.swing.JFrame;

import com.capricorn.entity.Board;
import com.capricorn.model.Model;

public class TestStartPage {
/**main function the start the single game*/
	public static void main(String[] args) {
		//Model m = new Model();
		// TODO Auto-generated method stub
		Model m=new Model();
		StartPage page = new StartPage(m);
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		page.setVisible(true);
		
}
}
