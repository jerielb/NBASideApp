--alter table PLAYER 
--	drop column FIRST_NAME,
--	drop column LAST_NAME;
--
--alter table PLAYER 
--	add column FULL_NAME varchar(100);

drop table ROSTER;
drop table PLAYER;

create table PLAYER (
	PLAYER_ID int primary key,
    FULL_NAME varchar(100),
    POSITIONS varchar(2),
    OVERALL int,
    INSIDE_SCORING varchar(2),
    MID_RANGE_SCORING varchar(2),
    THREE_POINT_SCORING varchar(2),
    INTERIOR_DEFENSE varchar(2),
    PERIMETER_DEFENSE varchar(2),
    PLAYMAKING varchar(2),
    REBOUNDING varchar(2),
    PHYSICALS varchar(2),
    IQ varchar(2)
);
