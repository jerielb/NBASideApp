package com.jerielb.NBASideApp.repository;

import com.jerielb.NBASideApp.model.League;

import java.util.List;

/**
 * @Repository for the LEAGUE DB table 
 * - contains all communicating queries with the table
 **/
public interface LeagueRepository {
	List<League> findAll();
	int addLeague(League league);
}
