package com.jerielb.NBASideApp.service;

import com.jerielb.NBASideApp.model.League;
import com.jerielb.NBASideApp.repository.LeagueRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {
    private final Logger LOGGER = LogManager.getLogger(IndexService.class);
	private final LeagueRepository leagueRepository;
	
    @Autowired
    public IndexService(LeagueRepository leagueRepository) {
		this.leagueRepository = leagueRepository;
	}
	
	public List<League> getLeagues() {
		LOGGER.debug("Getting all leagues from LEAGUE table");
		return leagueRepository.findAll();
	}
}
