-- table creation
create table TEAM (
	TEAM_ID int primary key,
    TEAM_NAME varchar(50),
    TEAM_OUTSIDE_SCORING int,
    TEAM_INSIDE_SCORING int,
    TEAM_PLAYMAKING int,
    TEAM_DEFENDING int,
    TEAM_REBOUNDING int
);

create table PLAYER (
	PLAYER_ID int primary key,
    FIRST_NAME varchar(25),
    LAST_NAME varchar(25),
    OUTSIDE_SCORING int,
    INSIDE_SCORING int,
    PLAYMAKING int,
    DEFENDING int,
    REBOUNDING int,
    POSITIONS varchar(2)
);

create table ROSTER (
	TEAM_ID int,
    PLAYER_ID int,
    foreign key(TEAM_ID) references TEAM(TEAM_ID),
    foreign key(PLAYER_ID) references PLAYER(PLAYER_ID)
);
