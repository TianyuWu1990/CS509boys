package com.capricorn.RequestController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.capricorn.entity.Board;
import com.capricorn.model.Model;
import com.capricorn.view.PracticeGame;
import com.capricorn.view.Application;
/**Exit controller implement actionlistener.*/
public class Exit implements ActionListener{
	JFrame j;
	Model m;
/**Here is a constructor for Exit in order to make a fault value.
	 * Construct Exit object to use default port number.*/
	public Exit(JFrame j,Model m){
		this.j=j;
		this.m=m;
	}
/**Dispose the interface and shut down the software.*/
	@Override
	public void actionPerformed(ActionEvent e) {
		j.dispose();
		
		Application page = Application.getInstance(m);
		page.setSize(600, 300); // set StartPage size
		page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		page.setVisible(true);
	}
}
