---- foreign keys prevent from truncating a table ----

-- drop table ROSTER;

create table ROSTER (
	TEAM_ID int, -- foreign key
    PLAYER_ID int -- foreign key
--    , foreign key(TEAM_ID) references TEAM(TEAM_ID),
--    foreign key(PLAYER_ID) references PLAYER(PLAYER_ID)
);
