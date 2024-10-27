 drop table TEAM;

create table TEAM (
	TEAM_ID int primary key,
    TEAM_NAME varchar(100),
    OVERALL varchar(2),
    INSIDE_SCORING varchar(2),
    MID_RANGE_SCORING varchar(2),
    THREE_POINT_SCORING varchar(2),
    INTERIOR_DEFENSE varchar(2),
    PERIMETER_DEFENSE varchar(2),
    PLAYMAKING varchar(2),
    REBOUNDING varchar(2),
    LEAGUE_ID int -- foreign key
);
