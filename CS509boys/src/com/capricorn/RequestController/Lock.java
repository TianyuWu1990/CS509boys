//package com.capricorn.RequestController;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//
//import com.capricorn.model.Model;
//import com.capricorn.view.Application;
//import com.capricorn.view.MultiGame;
//
//public class Lock implements ActionListener{
//	Application app;
//	Model m;
//
//	public Lock(Application app,Model m){
//		this.app=app;
//		this.m=m;
//	}
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		new LockGameRequest(m, app).process();
//		JButton button = (JButton) e.getSource();
//		button.setEnabled(false);
//		
//		
//	}
//}
