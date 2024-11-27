package com.jerielb.NBASideApp.model.enums;

public enum WestFranchise {
	// added display names for HTML (thmyeleaf) code
	DAL("Dallas Mavericks", false),
	DEN("Denver Nuggets", false),
	GSW("Golden State Warriors", false),
	HOU("Houston Rockets", false),
	LAC("Los Angeles Clippers", false),
	LAL("Los Angeles Lakers", false),
	MEM("Memphis Grizzlies", false),
	MIN("Minnesota Timberwolves", false),
	NOP("New Orleans Pelicans", false),
	OKC("Oklahoma City Thunder", false),
	PHO("Phoenix Suns", false),
	POR("Portland Trail Blazers", false),
	SAC("Sacramento Kings", false),
	SAS("San Antonio Spurs", false),
	UTA("Utah Jazz", false);
	
	private final String displayValue;
	private boolean selected;
	
	WestFranchise(String displayValue, boolean selected) {
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
