package com.jerielb.NBASideApp.repository.rowmapper;

import com.jerielb.NBASideApp.model.Team;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Sets the Team model's variables to the columns of the TEAM table
 **/
@Component
public class TeamRowMapper implements RowMapper<Team> {
	@Override
	public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
		Team team = new Team();
		
		team.setTeamId(rs.getInt("TEAM_ID"));
		team.setTeamName(rs.getString("TEAM_NAME"));
		team.setOverall(rs.getInt("OVERALL"));
		
		team.setInsideScoring(rs.getString("INSIDE_SCORING"));
		team.setMidRangeScoring(rs.getString("MID_RANGE_SCORING"));
		team.setThreePointScoring(rs.getString("THREE_POINT_SCORING"));
		
		team.setInteriorDefense(rs.getString("INTERIOR_DEFENSE"));
		team.setPerimeterDefense(rs.getString("PERIMETER_DEFENSE"));
		team.setPlaymaking(rs.getString("PLAYMAKING"));
		
		team.setRebounding(rs.getString("REBOUNDING"));
		team.setPhysicals(rs.getString("PHYSICALS"));
		team.setIq(rs.getString("IQ"));
		
		team.setLeagueId(rs.getInt("LEAGUE_ID"));
		return team;
	}
}
