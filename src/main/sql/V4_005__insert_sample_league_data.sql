insert into LEAGUE (LEAGUE_ID, LEAGUE_NAME, LEAGUE_SIZE, ROSTER_SIZE)
values(1, 'Celtics vs Lakers', 2, 13);

insert into LEAGUE (TEAM_ID, TEAM_NAME, OVERALL, INSIDE_SCORING, MID_RANGE_SCORING, THREE_POINT_SCORING, PLAYMAKING, INTERIOR_DEFENSE, PERIMETER_DEFENSE, REBOUNDING, PHYSICALS, IQ, LEAGUE_ID)
values
    (1, 'BOSTON CELTICS', '94', 'A', 'A-', 'B+', 'A-', 'B-', 'A-', 'B', 'A-', 'A', 1),
    (2, 'LA LAKERS', '94', 'A', 'B+', 'B', 'B+', 'B+', 'B+', 'B', 'A-', 'A+', 1)
;

insert into ROSTER (TEAM_ID, PLAYER_ID)
values
    (1, 30),
    (1, 57),
    (1, 62),
    (1, 6),
    (1, 5),
    (1, 107),
    (1, 119),
    (1, 31),
    (1, 122),
    (1, 13),
    (1, 345),
    (1, 344),
    (1,45 ),
    
    (2, 22),
    (2, 8),
    (2, 2),
    (2, 4),
    (2, 9),
    (2, 135),
    (2, 230),
    (2, 32),
    (2, 50),
    (2, 3),
    (2, 293),
    (2, 300),
    (2, 14)
;