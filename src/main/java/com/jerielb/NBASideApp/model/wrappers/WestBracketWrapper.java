package com.jerielb.NBASideApp.model.wrappers;

import com.jerielb.NBASideApp.model.enums.WestFranchise;

import java.util.List;

public class WestBracketWrapper {
	// variables
	private WestFranchise firstTeam;
	private WestFranchise secondTeam;
	private WestFranchise thirdTeam;
	private WestFranchise fourthTeam;
	private WestFranchise fifthTeam;
	private WestFranchise sixthTeam;
	private WestFranchise seventhTeam;
	private WestFranchise eighthTeam;
	
	// constructor
	public WestBracketWrapper(int amount, List<WestFranchise> teams) {
		// TODO: conf. finals - 2 teams; conf. semis - 4 teams; conf. quarters - 8 teams;
		firstTeam = teams.get(0);
		secondTeam = teams.get(1);
		thirdTeam = teams.get(2);
		fourthTeam = teams.get(3);
		fifthTeam = teams.get(4);
		sixthTeam = teams.get(5);
		seventhTeam = teams.get(6);
		eighthTeam = teams.get(7);
	}
	
	public WestFranchise getFirstTeam() {
		return firstTeam;
	}
	
	public void setFirstTeam(WestFranchise firstTeam) {
		this.firstTeam = firstTeam;
	}
	
	public WestFranchise getSecondTeam() {
		return secondTeam;
	}
	
	public void setSecondTeam(WestFranchise secondTeam) {
		this.secondTeam = secondTeam;
	}
	
	public WestFranchise getThirdTeam() {
		return thirdTeam;
	}
	
	public void setThirdTeam(WestFranchise thirdTeam) {
		this.thirdTeam = thirdTeam;
	}
	
	public WestFranchise getFourthTeam() {
		return fourthTeam;
	}
	
	public void setFourthTeam(WestFranchise fourthTeam) {
		this.fourthTeam = fourthTeam;
	}
	
	public WestFranchise getFifthTeam() {
		return fifthTeam;
	}
	
	public void setFifthTeam(WestFranchise fifthTeam) {
		this.fifthTeam = fifthTeam;
	}
	
	public WestFranchise getSixthTeam() {
		return sixthTeam;
	}
	
	public void setSixthTeam(WestFranchise sixthTeam) {
		this.sixthTeam = sixthTeam;
	}
	
	public WestFranchise getSeventhTeam() {
		return seventhTeam;
	}
	
	public void setSeventhTeam(WestFranchise seventhTeam) {
		this.seventhTeam = seventhTeam;
	}
	
	public WestFranchise getEighthTeam() {
		return eighthTeam;
	}
	
	public void setEighthTeam(WestFranchise eighthTeam) {
		this.eighthTeam = eighthTeam;
	}
}
