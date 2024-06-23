package com.jerielb.NBASideApp.repository;

import com.jerielb.NBASideApp.model.League;
import com.jerielb.NBASideApp.model.Player;
import com.jerielb.NBASideApp.model.Team;
import com.jerielb.NBASideApp.repository.rowmapper.LeagueRowMapper;
import com.jerielb.NBASideApp.repository.rowmapper.PlayerRowMapper;
import com.jerielb.NBASideApp.repository.rowmapper.TeamRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LeagueRepositoryImpl implements LeagueRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private LeagueRowMapper leagueMapper;
	@Autowired
	private TeamRowMapper teamMapper;
	@Autowired
	private PlayerRowMapper playerMapper;
	
	@Override
	public List<League> findAll() {
		String query = "select * from LEAGUE";
		return jdbcTemplate.query(query, leagueMapper);
	}
	
	@Override
	public League getLeagueId(int leagueId) {
		String leagueQuery = "select * from LEAGUE where LEAGUE_ID = ?";
		League league = jdbcTemplate.query(leagueQuery, leagueMapper, leagueId).get(0);
		
		String teamQuery = "select * from TEAM where LEAGUE_ID = ?";
		List<Team> teams = jdbcTemplate.query(teamQuery, teamMapper, leagueId);
		
		for (Team team : teams) {
			long teamId = team.getTeamId();
			String rosterQuery = "select * from PLAYER where PLAYER_ID in (" +
					"	select PLAYER_ID from ROSTER where TEAM_ID = ?" +
					")";
			List<Player> roster = jdbcTemplate.query(rosterQuery, playerMapper, teamId);
			team.setRoster(roster);
		}
		
		league.setTeams(teams);
		return league;
	}
	
	@Override
	public int addLeague(League league) {
		String query = "insert into LEAGUE(LEAGUE_ID, LEAGUE_NAME) " +
				"values(?, ?)";
		return jdbcTemplate.update(query, league.getLeagueId(), league.getLeagueName());
	}
	
	@Override
	public List<Team> getLeagueTeams(int leagueId) {
		String query = "select * from TEAM where LEAGUE_ID = ?";
		List<Team> teams = jdbcTemplate.query(query, teamMapper, leagueId);
		return teams;
	}
}
