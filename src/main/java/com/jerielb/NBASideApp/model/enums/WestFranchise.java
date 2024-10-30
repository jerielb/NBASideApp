package com.jerielb.NBASideApp.model.enums;

public enum WestFranchise {
	// added display names for HTML (thmyeleaf) code
	DAL("Dallas Mavericks"),
	DEN("Denver Nuggets"),
	GSW("Golden State Warriors"),
	HOU("Houston Rockets"),
	LAC("Los Angeles Clippers"),
	LAL("Los Angeles Lakers"),
	MEM("Memphis Grizzlies"),
	MIN("Minnesota Timberwolves"),
	NOP("New Orleans Pelicans"),
	OKC("Oklahoma City Thunder"),
	PHO("Phoenix Suns"),
	POR("Portland Trail Blazers"),
	SAC("Sacramento Kings"),
	SAS("San Antonio Spurs"),
	UTA("Utah Jazz");
	
	private final String displayValue;
	
	WestFranchise(String displayValue) {
		this.displayValue = displayValue;
	}
	
	public String getDisplayValue() {
		return displayValue;
	}
	
}
