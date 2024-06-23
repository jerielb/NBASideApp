package com.jerielb.NBASideApp.repository.rowmapper;

import com.jerielb.NBASideApp.model.League;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LeagueRowMapper implements RowMapper<League> {
	@Override
	public League mapRow(ResultSet rs, int rowNum) throws SQLException {
		League league = new League();
		
		league.setLeagueId(rs.getInt("LEAGUE_ID"));
		league.setLeagueName(rs.getString("LEAGUE_NAME"));
		league.setLeagueSize(rs.getInt("LEAGUE_SIZE"));
		league.setRosterSize(rs.getInt("ROSTER_SIZE"));
		return league;
	}
}
