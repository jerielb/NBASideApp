package com.jerielb.NBASideApp.model.wrappers;

import com.jerielb.NBASideApp.model.enums.WestFranchise;

import java.util.List;

public class WestBracketWrapper {
	// variables
	private WestFranchise firstSeed;
	private WestFranchise secondSeed;
	private WestFranchise thirdSeed;
	private WestFranchise fourthSeed;
	private WestFranchise fifthSeed;
	private WestFranchise sixthSeed;
	private WestFranchise seventhSeed;
	private WestFranchise eighthSeed;
	
	// constructor
	public WestBracketWrapper(int amount, List<WestFranchise> teams) {
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
	
	public WestFranchise getFirstSeed() {
		return firstSeed;
	}
	
	public void setFirstSeed(WestFranchise firstSeed) {
		this.firstSeed = firstSeed;
	}
	
	public WestFranchise getSecondSeed() {
		return secondSeed;
	}
	
	public void setSecondSeed(WestFranchise secondSeed) {
		this.secondSeed = secondSeed;
	}
	
	public WestFranchise getThirdSeed() {
		return thirdSeed;
	}
	
	public void setThirdSeed(WestFranchise thirdSeed) {
		this.thirdSeed = thirdSeed;
	}
	
	public WestFranchise getFourthSeed() {
		return fourthSeed;
	}
	
	public void setFourthSeed(WestFranchise fourthSeed) {
		this.fourthSeed = fourthSeed;
	}
	
	public WestFranchise getFifthSeed() {
		return fifthSeed;
	}
	
	public void setFifthSeed(WestFranchise fifthSeed) {
		this.fifthSeed = fifthSeed;
	}
	
	public WestFranchise getSixthSeed() {
		return sixthSeed;
	}
	
	public void setSixthSeed(WestFranchise sixthSeed) {
		this.sixthSeed = sixthSeed;
	}
	
	public WestFranchise getSeventhSeed() {
		return seventhSeed;
	}
	
	public void setSeventhSeed(WestFranchise seventhSeed) {
		this.seventhSeed = seventhSeed;
	}
	
	public WestFranchise getEighthSeed() {
		return eighthSeed;
	}
	
	public void setEighthSeed(WestFranchise eighthSeed) {
		this.eighthSeed = eighthSeed;
	}
}
