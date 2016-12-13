package com.capricorn.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.capricorn.view.PracticeGame;
import com.capricorn.entity.Model;
import com.capricorn.view.Application;
// TODO: Auto-generated Javadoc
/**
 * This is the enter to the practice game.
 * If the client want to be familiar with the game before the true competition.
 * Here is a good place for the player to have fun and practice.
 * This function do not need to connect to sever, so no request and response will generate
 * or receive.
 * @author Chen Li, Dongsheng Wang, Yu Li, Tianyu Wu, Bowen Sun
 */
public class StartPractice implements ActionListener{
	
	/** The st */
	Application st;
	
	/** The m. */
	Model m;
	
	/**
	 *  Construct StartPractice object to use default port data.
	 *
	 * @param p is the Application
	 * @param m is the Model
	 */
	public StartPractice(Application p,Model m){
		this.st=p;
		this.m=m;
	}
	
	/**
	 * Dispose the default board at the beginning and connect to the game board.
	 *
	 * @param e is the ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		m.getBoard().setcellArrayForPractice();
		st.dispose();
	
		PracticeGame practice = new PracticeGame(m);
		
		
		practice.setSize(600, 300); 
		practice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		practice.setVisible(true);
		}
	}