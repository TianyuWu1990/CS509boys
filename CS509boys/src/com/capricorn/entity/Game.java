package com.capricorn.entity;



import java.util.HashMap;

public class Game {
	String gameId;
	Player player;
	private String managingUser;
	HashMap<String,Long> playersInformation; 
	private boolean isLocked;
	

	
	public Game() {
		gameId = "";
		managingUser = null;
		isLocked = false;
		playersInformation = new HashMap<String, Long>();;
	}
	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		gameId = gameId;
	}
	public HashMap<String,Long> getPlayersInformation(){
		
		
		return playersInformation;
		
	}
	public void addPlayersInformation(String name,Long score ) {
		playersInformation.put(name, score);
		
	}
}
