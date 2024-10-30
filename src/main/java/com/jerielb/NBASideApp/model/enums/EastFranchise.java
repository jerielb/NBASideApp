package com.jerielb.NBASideApp.model.enums;

public enum EastFranchise {
	// added display names for HTML (thmyeleaf) code
	ATL("Atlanta Hawks"),
	BOS("Boston Celtics"),
	BRK("Brooklyn Nets"),
	CHI("Chicago Bulls"),
	CHO("Charlotte Hornets"),
	CLE("Cleveland Cavaliers"),
	DET("Detroit Pistons"),
	IND("Indiana Pacers"),
	MIA("Miami Heat"),
	MIL("Milwaukee Bucks"),
	NYK("New York Knicks"),
	ORL("Orlando Magic"),
	PHI("Philadelphia 76ers"),
	TOR("Toronto Raptors"),
	WAS("Washington Wizards");
	
	private final String displayValue;
	
	EastFranchise(String displayValue) {
		this.displayValue = displayValue;
	}
	
	public String getDisplayValue() {
		return displayValue;
	}
	
}
