package com.jerielb.NBASideApp.model.enums;

public enum EastFranchise {
	// added display names for HTML (thmyeleaf) code
	ATL("Atlanta Hawks", false),
	BOS("Boston Celtics", false),
	BRK("Brooklyn Nets", false),
	CHI("Chicago Bulls", false),
	CHO("Charlotte Hornets", false),
	CLE("Cleveland Cavaliers", false),
	DET("Detroit Pistons", false),
	IND("Indiana Pacers", false),
	MIA("Miami Heat", false),
	MIL("Milwaukee Bucks", false),
	NYK("New York Knicks", false),
	ORL("Orlando Magic", false),
	PHI("Philadelphia 76ers", false),
	TOR("Toronto Raptors", false),
	WAS("Washington Wizards", false);
	
	private final String displayValue;
	private boolean selected;
	
	EastFranchise(String displayValue, boolean selected) {
		this.displayValue = displayValue;
		this.selected = selected;
	}
	
	public String getDisplayValue() {
		return displayValue;
	}
	
	public boolean getSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
