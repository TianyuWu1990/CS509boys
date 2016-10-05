package com.java.Property;

import java.math.BigDecimal;

public class ServerState {
	private String activeGame;
	
	private Integer PlayerMembership;
	
	private BigDecimal scores;
	
	public String getActiveGame() {
		return activeGame;
	}
	public void setActiveGame(String activeGame) {
		this.activeGame = activeGame;
	}
	public Integer getPlayerMembership() {
		return PlayerMembership;
	}
	public void setPlayerMembership(Integer playerMembership) {
		PlayerMembership = playerMembership;
	}
	public BigDecimal getScores() {
		return scores;
	}
	public void setScores(BigDecimal scores) {
		this.scores = scores;
	}
	
}
