alter table TEAM 
	add column LEAGUE_ID int,
	add foreign key(LEAGUE_ID) references LEAGUE(LEAGUE_ID);
