package com.capricorn.entity;

import java.util.List;

public class Player {
	String name;
	long score;
    String	position;
    boolean isManager;
public boolean isManager() {
		return isManager;
	}
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
public Player(String name, long score, String position) {
		super();
		this.name = name;
		this.score = score;
		this.position = position;
	}
public Player(){
}



public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	//	board;
//	List PlayerInformation;
//	List<Player> PlayerInformations;
	public String getName() {
		return name;
	}
	public long getScore() {
		return score;
	}
public void setName(String name) {
		this.name = name;
	}
	//	public List getPlayerInformation() {
//		return PlayerInformation;
//	}
//	public List<Player> getPlayerInformations() {
//		return PlayerInformations;
//	}
	public void setScore(long score) {
		this.score = score;
	}


}
