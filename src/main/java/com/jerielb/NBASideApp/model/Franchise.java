package com.jerielb.NBASideApp.model;

import org.springframework.stereotype.Component;

@Component
public class Franchise {
	// variables
	private long franchiseId;
	private String acronym;
	private String teamCity;
	private String teamName;
	private String active;
	
	// constructor
	public Franchise() {}
	
	// getters & setters
	public long getFranchiseId() {
		return franchiseId;
	}
	
	public void setFranchiseId(long franchiseId) {
		this.franchiseId = franchiseId;
	}
	
	public String getAcronym() {
		return acronym;
	}
	
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	
	public String getTeamCity() {
		return teamCity;
	}
	
	public void setTeamCity(String teamCity) {
		this.teamCity = teamCity;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public String getActive() {
		return active;
	}
	
	public void setActive(String active) {
		this.active = active;
	}
	
	
}
