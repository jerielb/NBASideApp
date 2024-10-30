package com.jerielb.NBASideApp.model;

import com.jerielb.NBASideApp.model.enums.FranchiseAcr;
import org.springframework.stereotype.Component;

@Component
public class Franchise {
	// variables
	private long franchiseId;
	private FranchiseAcr acronym;
	private String teamCity;
	private String teamName;
	private FranchiseAcr active;
	
	// constructor
	public Franchise() {}
	
	// getters & setters
	public long getFranchiseId() {
		return franchiseId;
	}
	
	public void setFranchiseId(long franchiseId) {
		this.franchiseId = franchiseId;
	}
	
	public FranchiseAcr getAcronym() {
		return acronym;
	}
	
	public void setAcronym(FranchiseAcr acronym) {
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
	
	public FranchiseAcr getActive() {
		return active;
	}
	
	public void setActive(FranchiseAcr active) {
		this.active = active;
	}
	
	
}
