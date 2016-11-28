package com.capricorn.entity;




import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Game {
	String gameId;

	private String managingUser;
	List<Player> playersInformation; 
	public boolean isLocked;
	List<String> playersLocation;
	

	
	public Game() {
		gameId = "";
		managingUser = "";
		isLocked = false;
		playersInformation = new LinkedList<Player>();
	}
	public String getGameId() {
		return gameId;
	}

	public String getManagingUser() {
		return managingUser;
	}
	public void setManagingUser(String managingUser) {
		this.managingUser = managingUser;
	}
	public boolean isLocked() {
		return isLocked;
	}
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	public List<Player> getPlayersInformation(){
		
		
		return playersInformation;
		
	}
	public void setPlayersInformation(List<Player> playersInformation) {
		this.playersInformation=playersInformation;
		
	}
	@SuppressWarnings("unchecked")
	public List<Player> getPlayersListByScore(){
		Comparator<Object> comparator =new Comparator<Object>(){
			@Override
			public int compare(Object o1,Object o2){
	           if(o1 instanceof Player&& o2 instanceof Player){
	        	   Player p1=(Player) o1;
	        	   Player p2=(Player) o2;
	        	   return -( p1.getScore()-p2.getScore()>0?1: (p1.getScore()==p2.getScore()?0:-1));
	        	   }
	           return 0;
	           }
		
			
		};
		Collections.sort(this.playersInformation, comparator);   
		return playersInformation;
		
	}
	public void clearPlayersInformation() {
		playersInformation.clear();
		
	}
	public List<String> getPlayerslocation() {
		return playersLocation;
	}
	public void setPlayerslocation(List<String> playerslocation) {
		this.playersLocation = playerslocation;
	}
	
	
	
	
	
}

