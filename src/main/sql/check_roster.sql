select
	lg.LEAGUE_ID, lg.LEAGUE_NAME,
	tm.TEAM_ID, tm.TEAM_NAME, tm.OVERALL,
    pl.FULL_NAME, pl.OVERALL
from LEAGUE lg
join TEAM tm
	on lg.LEAGUE_ID = tm.LEAGUE_ID
join ROSTER ros
	on tm.TEAM_ID = ros.TEAM_ID
join PLAYER pl
	on ros.PLAYER_ID = pl.PLAYER_ID
    -- and TEAM_NAME = '?'
;