package com.jerielb.NBASideApp.model.wrappers;

import com.jerielb.NBASideApp.model.enums.EastFranchise;

import java.util.List;

public class EastBracketWrapper {
	// variables
	private EastFranchise firstSeed;
	private EastFranchise secondSeed;
	private EastFranchise thirdSeed;
	private EastFranchise fourthSeed;
	private EastFranchise fifthSeed;
	private EastFranchise sixthSeed;
	private EastFranchise seventhSeed;
	private EastFranchise eighthSeed;
	
	// constructor
	public EastBracketWrapper(int amount, List<EastFranchise> teams) {
		// TODO: conf. finals - 2 teams; conf. semis - 4 teams; conf. quarters - 8 teams;
		firstSeed = teams.get(0);
		secondSeed = teams.get(1);
		thirdSeed = teams.get(2);
		fourthSeed = teams.get(3);
		fifthSeed = teams.get(4);
		sixthSeed = teams.get(5);
		seventhSeed = teams.get(6);
		eighthSeed = teams.get(7);
	}
	
	public EastFranchise getFirstSeed() {
		return firstSeed;
	}
	
	public void setFirstSeed(EastFranchise firstSeed) {
		this.firstSeed = firstSeed;
	}
	
	public EastFranchise getSecondSeed() {
		return secondSeed;
	}
	
	public void setSecondSeed(EastFranchise secondSeed) {
		this.secondSeed = secondSeed;
	}
	
	public EastFranchise getThirdSeed() {
		return thirdSeed;
	}
	
	public void setThirdSeed(EastFranchise thirdSeed) {
		this.thirdSeed = thirdSeed;
	}
	
	public EastFranchise getFourthSeed() {
		return fourthSeed;
	}
	
	public void setFourthSeed(EastFranchise fourthSeed) {
		this.fourthSeed = fourthSeed;
	}
	
	public EastFranchise getFifthSeed() {
		return fifthSeed;
	}
	
	public void setFifthSeed(EastFranchise fifthSeed) {
		this.fifthSeed = fifthSeed;
	}
	
	public EastFranchise getSixthSeed() {
		return sixthSeed;
	}
	
	public void setSixthSeed(EastFranchise sixthSeed) {
		this.sixthSeed = sixthSeed;
	}
	
	public EastFranchise getSeventhSeed() {
		return seventhSeed;
	}
	
	public void setSeventhSeed(EastFranchise seventhSeed) {
		this.seventhSeed = seventhSeed;
	}
	
	public EastFranchise getEighthSeed() {
		return eighthSeed;
	}
	
	public void setEighthSeed(EastFranchise eighthSeed) {
		this.eighthSeed = eighthSeed;
	}
	
}
