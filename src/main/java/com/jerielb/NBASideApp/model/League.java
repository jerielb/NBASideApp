package com.jerielb.NBASideApp.model;

import org.springframework.stereotype.Component;

@Component
public class League {
	// variables
	private int leagueId;
	private String leagueName;
	
	// constructor
	
	// functions
	
	// getters & setters
	public int getLeagueId() {
		return leagueId;
	}
	
	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}
	
	public String getLeagueName() {
		return leagueName;
	}
	
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	
}
