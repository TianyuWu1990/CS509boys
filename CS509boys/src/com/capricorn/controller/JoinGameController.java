package com.capricorn.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.capricorn.model.Model;
import com.capricorn.view.PracticeGame;
import com.capricorn.view.StartPage;

import client.ServerAccess;
import xml.Message;


public class JoinGameController extends ControllerChain{
	StartPage st;
	Model m;
	Message mssg;
	
	/**
	 * the action 
	 */
	
	public JoinGameController(StartPage p,Model m) {
		this.st=p;
		this.m=m;
	}


	/** Make the request on the server and wait for response. */
	public boolean process(Message response) {
		// send the request to create the game.
		String xmlString = Message.requestHeader() + "<joinGameRequest gameId='somePlace' name='nextOne'/></request>";
		mssg = new Message (xmlString);
		
		return st.getServerAccess().sendRequest(mssg);
		
	}

}
