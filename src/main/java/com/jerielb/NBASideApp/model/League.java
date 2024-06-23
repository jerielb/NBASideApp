package com.jerielb.NBASideApp.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class League {
	// variables
	private int leagueId;
	private String leagueName;
	private int leagueSize;
	private int rosterSize;
	
	private List<Team> teams = new ArrayList<>();
	
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
	
	public int getLeagueSize() {
		return leagueSize;
	}
	
	public void setLeagueSize(int leagueSize) {
		this.leagueSize = leagueSize;
	}
	
	public int getRosterSize() {
		return rosterSize;
	}
	
	public void setRosterSize(int rosterSize) {
		this.rosterSize = rosterSize;
	}
	
	public List<Team> getTeams() {
		return teams;
	}
	
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
}
