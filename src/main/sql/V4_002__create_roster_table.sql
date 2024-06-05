-- many-to-many relationship (PLAYER_TEAM)
create table ROSTER (
	TEAM_ID int,
    PLAYER_ID int,
	foreign key(TEAM_ID) references TEAM(TEAM_ID),
    foreign key(PLAYER_ID) references PLAYER(PLAYER_ID)
);
