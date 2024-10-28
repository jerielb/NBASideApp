---- foreign keys prevent from truncating a table ----

-- drop table PLAYED_FOR;

create table PLAYED_FOR (
    PLAYER_ID, int -- foreign key
	FRANCHISE_ID int -- foreign key
--    , foreign key(FRANCHISE_ID) references FRANCHISE(FRANCHISE_ID),
--    foreign key(PLAYER_ID) references PLAYER(PLAYER_ID)
);
