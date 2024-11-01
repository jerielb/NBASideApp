package com.jerielb.NBASideApp.model.wrappers;

import com.jerielb.NBASideApp.model.enums.EastFranchise;

import java.util.List;

public class EastBracketWrapper {
	// variables
	private EastFranchise firstTeam;
	private EastFranchise secondTeam;
	private EastFranchise thirdTeam;
	private EastFranchise fourthTeam;
	private EastFranchise fifthTeam;
	private EastFranchise sixthTeam;
	private EastFranchise seventhTeam;
	private EastFranchise eighthTeam;
	
	// constructor
	public EastBracketWrapper(int amount, List<EastFranchise> teams) {
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
	
	public EastFranchise getFirstTeam() {
		return firstTeam;
	}
	
	public void setFirstTeam(EastFranchise firstTeam) {
		this.firstTeam = firstTeam;
	}
	
	public EastFranchise getSecondTeam() {
		return secondTeam;
	}
	
	public void setSecondTeam(EastFranchise secondTeam) {
		this.secondTeam = secondTeam;
	}
	
	public EastFranchise getThirdTeam() {
		return thirdTeam;
	}
	
	public void setThirdTeam(EastFranchise thirdTeam) {
		this.thirdTeam = thirdTeam;
	}
	
	public EastFranchise getFourthTeam() {
		return fourthTeam;
	}
	
	public void setFourthTeam(EastFranchise fourthTeam) {
		this.fourthTeam = fourthTeam;
	}
	
	public EastFranchise getFifthTeam() {
		return fifthTeam;
	}
	
	public void setFifthTeam(EastFranchise fifthTeam) {
		this.fifthTeam = fifthTeam;
	}
	
	public EastFranchise getSixthTeam() {
		return sixthTeam;
	}
	
	public void setSixthTeam(EastFranchise sixthTeam) {
		this.sixthTeam = sixthTeam;
	}
	
	public EastFranchise getSeventhTeam() {
		return seventhTeam;
	}
	
	public void setSeventhTeam(EastFranchise seventhTeam) {
		this.seventhTeam = seventhTeam;
	}
	
	public EastFranchise getEighthTeam() {
		return eighthTeam;
	}
	
	public void setEighthTeam(EastFranchise eighthTeam) {
		this.eighthTeam = eighthTeam;
	}
	
}
