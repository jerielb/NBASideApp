package com.jerielb.NBASideApp.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Team {
	// variables
	private long teamId;
	private String teamName;
	private String overall;
	
	private String insideScoring;
	private String midRangeScoring;
	private String threePointScoring;
	
	private String playmaking;
	private String rebounding;
	
	private String interiorDefense;
	private String perimeterDefense;
	
	private List<Player> roster = new ArrayList<>();
	
	// constructor
	public Team() {}
	
	// functions
	public void addPlayer(Player player) {
		if (roster.isEmpty()) {
			setTeamName("Team " + player.getFullName());
		}
		roster.add(player);
	}
	
	// getters & setters
	public long getTeamId() {
		return teamId;
	}
	
	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public String getOverall() {
		return overall;
	}
	
	public void setOverall(String overall) {
		this.overall = overall;
	}
	
	public String getInsideScoring() {
		return insideScoring;
	}
	
	public void setInsideScoring(String insideScoring) {
		this.insideScoring = insideScoring;
	}
	
	public String getMidRangeScoring() {
		return midRangeScoring;
	}
	
	public void setMidRangeScoring(String midRangeScoring) {
		this.midRangeScoring = midRangeScoring;
	}
	
	public String getThreePointScoring() {
		return threePointScoring;
	}
	
	public void setThreePointScoring(String threePointScoring) {
		this.threePointScoring = threePointScoring;
	}
	
	public String getPlaymaking() {
		return playmaking;
	}
	
	public void setPlaymaking(String playmaking) {
		this.playmaking = playmaking;
	}
	
	public String getRebounding() {
		return rebounding;
	}
	
	public void setRebounding(String rebounding) {
		this.rebounding = rebounding;
	}
	
	public List<Player> getRoster() {
		return roster;
	}
	
	public void setRoster(List<Player> roster) {
		this.roster = roster;
	}
	
	public String getInteriorDefense() {
		return interiorDefense;
	}
	
	public void setInteriorDefense(String interiorDefense) {
		this.interiorDefense = interiorDefense;
	}
	
	public String getPerimeterDefense() {
		return perimeterDefense;
	}
	
	public void setPerimeterDefense(String perimeterDefense) {
		this.perimeterDefense = perimeterDefense;
	}
}
