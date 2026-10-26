package com.jerielb.NBASideApp.service;

import com.jerielb.NBASideApp.controller.DraftPageController;
import com.jerielb.NBASideApp.model.Franchise;
import com.jerielb.NBASideApp.model.Player;
import com.jerielb.NBASideApp.model.Team;
import com.jerielb.NBASideApp.repository.FranchiseRepository;
import com.jerielb.NBASideApp.repository.PlayerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DraftPageService {
    // variables
    private final Logger LOGGER = LogManager.getLogger(DraftPageController.class);
	private static int leagueSize;
	private static int rosterSize;
	private static boolean playedFor;
	private static List<Team> league = new ArrayList<>();
	private static List<Player> draftPool = new ArrayList<>();
	private static Map<String,List<Player>> playedForPool = new HashMap<>();
	private static List<Franchise> franchises = new ArrayList<>();
	// used to track the current team selecting for within the league List 
	private static int teamIndex;
	
	// repos
	private final PlayerRepository playerRepository;
	private final FranchiseRepository franchiseRepository;
    
    // constructor
	@Autowired
    public DraftPageService(PlayerRepository playerRepository, FranchiseRepository franchiseRepository) {
		this.playerRepository = playerRepository;
		this.franchiseRepository = franchiseRepository;
	}
	
    // functions
	public void reset(int leagueSize, int rosterSize, boolean playedFor) {
		LOGGER.debug("Resetting draft page");
		teamIndex = 0;
		this.leagueSize = leagueSize;
		this.rosterSize = rosterSize;
		this.playedFor = playedFor;
		
		league.clear();
		if (playedFor) {
			getCurrentTeams(leagueSize);
			this.draftPool = playedForPool.get(franchises.get(teamIndex).getAcronym());
		} else {
			this.draftPool = getAllPlayers();
		}
		
		for (int i=0; i<leagueSize; i++) {
			Team team = new Team();
			if (playedFor) {
				team.setTeamName(franchises.get(i).getAcronym());
			} else {
				team.setTeamName(String.valueOf(i));
			}
			league.add(team);
		}
	}
	
	public List<Player> getAllPlayers() {
		LOGGER.debug("Getting all players from PLAYER table");
		return playerRepository.findAll();
	}
	
	public boolean draftPlayerToTeam(int playerId) {
		Optional<Player> playerOptional = draftPool.stream().filter(e -> e.getPlayerId() == playerId).findFirst();
		Player player = playerOptional.get();
		LOGGER.info("Drafted player: " + player.getFullName());
		
		Team team = league.get(teamIndex);
		team.addPlayer(player, playedFor);
		if (playedFor) {
			player.setDrafted(true);
		} else {
			draftPool.remove(player);
		}
		
		// checks if the last team has a full roster
        if (team.getRoster().size() == rosterSize && teamIndex == league.size()-1) {
			// complete league roster
			return true;
		} else {
			nextTeam();
			return false;
        }
    }
	
	public int getTeamIndex(){
		return teamIndex;
	}
	
	public int getLeagueSize() {
		return leagueSize;
	}
	
	public List<Player> getDraftPool() {
		draftPool.sort(Comparator.comparing(Player::getOverall).reversed());
		return draftPool;
	}
	
	public Team getTeamAtIndex(int teamIndex) {
		return league.get(teamIndex);
	}
	
	public Team getTeam() {
		return league.get(teamIndex);
	}
	
	public void nextTeam() {
		if (teamIndex == league.size()-1) {
			teamIndex = 0;
		} else {
			teamIndex++;
		}
		this.draftPool = playedForPool.get(franchises.get(teamIndex).getAcronym());
	}
	
	public void getCurrentTeams(int size) {
		franchises = franchiseRepository.findCurrent(size);
		List<Player> allPlayers = getAllPlayers();
		for (Franchise franchise : franchises) {
			List<Player> players = new ArrayList<>();
			List<Long> franchiseIds = franchiseRepository.findPrevious(franchise.getAcronym());
			franchiseIds.add(franchise.getFranchiseId());
			
			List<Long> playerIds = franchiseRepository.findPlayedForIds(franchiseIds);
			for (Long playerId : playerIds) {
				Player player = allPlayers.get(Math.toIntExact(playerId));
				players.add(player);
			}
			playedForPool.put(franchise.getAcronym(), players);
		}
	}
}
