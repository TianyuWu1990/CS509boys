package com.java.Property;

import java.math.BigDecimal;

public class ServerState {
	private String activeGame;
	private Integer PlayerMembershi;
	private BigDecimal scores;
	public String getActiveGame() {
		return activeGame;
	}
	public void setActiveGame(String activeGame) {
		this.activeGame = activeGame;
	}
	public Integer getPlayerMembershi() {
		return PlayerMembershi;
	}
	public void setPlayerMembershi(Integer playerMembershi) {
		PlayerMembershi = playerMembershi;
	}
	public BigDecimal getScores() {
		return scores;
	}
	public void setScores(BigDecimal scores) {
		this.scores = scores;
	}
	
}
