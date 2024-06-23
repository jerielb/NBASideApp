package com.jerielb.NBASideApp.service;

import com.jerielb.NBASideApp.model.League;
import com.jerielb.NBASideApp.model.Team;
import com.jerielb.NBASideApp.repository.LeagueRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoadDraftPageService {
	private final Logger LOGGER = LogManager.getLogger(LoadDraftPageService.class);
	private League league;
	
	private final LeagueRepository leagueRepository;
	
	@Autowired
	public LoadDraftPageService(LeagueRepository leagueRepository) {
		this.leagueRepository = leagueRepository;
	}
	
	public League getLeagueId(int id) {
		LOGGER.info("Getting LEAGUE details for LEAGUE_ID = " + id);
		league = leagueRepository.getLeagueId(id);
		return league;
	}
	
	public long getLeagueSize() {
		return league.getLeagueSize();
	}
	
	public Team getTeamAtIndex(int index) {
		return league.getTeams().get(index);
	}
}
