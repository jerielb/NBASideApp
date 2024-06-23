package com.jerielb.NBASideApp.repository;

import com.jerielb.NBASideApp.model.League;
import com.jerielb.NBASideApp.model.Team;

import java.util.List;

/**
 * @Repository for the LEAGUE DB table 
 * - contains all communicating queries with the table
 **/
public interface LeagueRepository {
	List<League> findAll();
	League getLeagueId(int id);
	int addLeague(League league);
	List<Team> getLeagueTeams(int leagueId);
}
