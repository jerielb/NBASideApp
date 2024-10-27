package com.jerielb.NBASideApp.model.enums;

public enum Franchise {
	// added display names for HTML (thmyeleaf) code
	ATL("Atlanta Hawks"),
	BOS("Boston Celtics"),
	BRK("Brooklyn Nets"),
	CHI("Chicago Bulls"),
	CHO("Charlotte Hornets"),
	CLE("Cleveland Cavaliers"),
	DAL("Dallas Mavericks"),
	DEN("Denver Nuggets"),
	DET("Detroit Pistons"),
	GSW("Golden State Warriors"),
	HOU("Houston Rockets"),
	IND("Indiana Pacers"),
	LAC("Los Angeles Clippers"),
	LAL("Los Angeles Lakers"),
	MEM("Memphis Grizzlies"),
	MIA("Miami Heat"),
	MIL("Milwaukee Bucks"),
	MIN("Minnesota Timberwolves"),
	NOP("New Orleans Pelicans"),
	NYK("New York Knicks"),
	OKC("Oklahoma City Thunder"),
	ORL("Orlando Magic"),
	PHI("Philadelphia 76ers"),
	PHO("Phoenix Suns"),
	POR("Portland Trail Blazers"),
	SAC("Sacramento Kings"),
	SAS("San Antonio Spurs"),
	TOR("Toronto Raptors"),
	UTA("Utah Jazz"),
	WAS("Washington Wizards");
	
	
	private final String displayValue;
	
	Franchise(String displayValue) {
		this.displayValue = displayValue;
	}
	
	public String getDisplayValue() {
		return displayValue;
	}
}
