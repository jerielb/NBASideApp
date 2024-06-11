package com.jerielb.NBASideApp.repository;

import com.jerielb.NBASideApp.model.League;
import com.jerielb.NBASideApp.repository.rowmapper.LeagueRowMapper;
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
	
	@Override
	public List<League> findAll() {
		String query = "select * from LEAGUE";
		return jdbcTemplate.query(query, leagueMapper);
	}
	
	@Override
	public int addLeague(League league) {
		String query = "insert into LEAGUE(LEAGUE_ID, LEAGUE_NAME) " +
				"values(?, ?)";
		return jdbcTemplate.update(query, league.getLeagueId(), league.getLeagueName());
	}
}
