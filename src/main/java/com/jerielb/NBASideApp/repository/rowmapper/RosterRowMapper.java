package com.jerielb.NBASideApp.repository.rowmapper;

import com.jerielb.NBASideApp.model.Player;
import com.jerielb.NBASideApp.model.Team;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RosterRowMapper implements RowMapper<List<Team>> {
	
	@Override
	public List<Team> mapRow(ResultSet rs, int rowNum) throws SQLException {
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
		
		List<Player> roster = new ArrayList<>();
		for (int i = 0; i < rs.getInt("ROSTER_SIZE"); i++) {
			
		}
		
		return null;
	}
}
