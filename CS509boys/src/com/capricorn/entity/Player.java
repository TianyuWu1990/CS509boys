package com.capricorn.entity;

import java.util.List;

public class Player {
	String name;
	long score;
//	position;
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
