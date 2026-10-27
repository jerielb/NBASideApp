truncate table PLAYER;

drop table PLAYER;

create table PLAYER (
	PLAYER_ID int primary key, 
    FULL_NAME varchar(100),
    PRIMARY_POSITION varchar(2),
    SECONDARY_POSITION varchar(2),
    LAY varchar(3),
    DNK varchar(3),
    INS varchar(3),
    MID varchar(3),
    3PT varchar(3),
    FT varchar(3),
    DRB varchar(3),
    PAS varchar(3),
    ORE varchar(3),
    DRE varchar(3),
    STL varchar(3),
    BLK varchar(3),
    OVR varchar(4)
);
