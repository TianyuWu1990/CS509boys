package com.capricorn.RequestController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.capricorn.model.Model;
import com.capricorn.view.Application;
import com.capricorn.view.MultiGame;

public class Lock implements ActionListener{
	Application app;
	Model m;
/**Here is a constructor for Exit in order to make a fault value.
	 * Construct Exit object to use default port number.*/
	public Lock(Application app,Model m){
		this.app=app;
		this.m=m;
	}
/**Dispose the interface and shut down the software.*/
	@Override
	public void actionPerformed(ActionEvent e) {
		m.getGame().isLocked = true;
		JButton button = (JButton) e.getSource();
		button.setEnabled(false);
		LockGameRequest lgr = new LockGameRequest(m, app);
		System.out.println(lgr);
		
	}
}
