-- drop table PLAYER;

create table PLAYER (
	PLAYER_ID int primary key, 
    FULL_NAME varchar(100),
    POSITIONS varchar(5),
    OVERALL varchar(2),
    INSIDE_SCORING varchar(2),
    MID_RANGE_SCORING varchar(2),
    THREE_POINT_SCORING varchar(2),
    INTERIOR_DEFENSE varchar(2),
    PERIMETER_DEFENSE varchar(2),
    PLAYMAKING varchar(2),
    REBOUNDING varchar(2)
);
