---- foreign keys prevent from truncating a table ----

-- drop table LINKED_TO;

create table LINKED_TO (
    PLAYER_ID int, -- foreign key
	FRANCHISE_ID int, -- foreign key
    DESCRIPTION VARCHAR(100) -- foreign key
--    , foreign key(FRANCHISE_ID) references FRANCHISE(FRANCHISE_ID),
--    foreign key(PLAYER_ID) references PLAYER(PLAYER_ID)
);
