package com.jerielb.NBASideApp.service;

import com.jerielb.NBASideApp.controller.DraftPageController;
import com.jerielb.NBASideApp.model.GradesUtil;
import com.jerielb.NBASideApp.model.Player;
import com.jerielb.NBASideApp.model.Team;
import com.jerielb.NBASideApp.repository.PlayerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DraftPageService {
    // variables
    private final Logger LOGGER = LogManager.getLogger(DraftPageController.class);
	private static int leagueSize;
	private static int rosterSize;
	private static List<Team> league = new ArrayList<>();
	private static List<Player> draftPool = new ArrayList<>();
	// used to track the current team selecting for within the league List 
	private static int teamIndex;
	
	// repos
	private final PlayerRepository playerRepository;
    
    // constructor
	@Autowired
    public DraftPageService(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}
	
    // functions
	public void reset(int leagueSize, int rosterSize) {
		LOGGER.debug("Resetting draft page");
		teamIndex = 0;
		this.leagueSize = leagueSize;
		this.rosterSize = rosterSize;
		this.draftPool = getAllPlayers();
		
		league.clear();
		for (int i=0; i<leagueSize; i++) {
			league.add(new Team());
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
		team.addPlayer(player);
		draftPool.remove(player);
		
		setTeamSummaryStats(team);
		
		// checks if the last team has a full roster
        if (team.getRoster().size() == rosterSize && teamIndex == league.size()-1) {
			// complete league roster
			return true;
		} else {
			nextTeam();
			return false;
        }
    }
	
	public Team setTeamSummaryStats(Team team) {
		List<Player> roster = team.getRoster();
		
		List<String> teamInsideScoring = new ArrayList<>();
		List<String> teamMidRangeScoring = new ArrayList<>();
		List<String> teamThreePointScoring = new ArrayList<>();
		
		List<String> teamInteriorDefense = new ArrayList<>();
		List<String> teamPerimeterDefense = new ArrayList<>();
		List<String> teamPlaymaking = new ArrayList<>();
		
		List<String> teamRebounding = new ArrayList<>();
		List<String> teamPhysicals = new ArrayList<>();
		List<String> teamIq = new ArrayList<>();
		
		String ins, mid, three, intD, perD, plm, reb, phy, iq;
		ins = mid = three = intD = perD = plm = reb = phy = iq = "##";
		
		float teamOvr = 0;
		
		if (!roster.isEmpty()) {
			for (Player player : roster) {
				teamInsideScoring.add(player.getInsideScoring());
				teamMidRangeScoring.add(player.getMidRangeScoring());
				teamThreePointScoring.add(player.getThreePointScoring());
				
				teamInteriorDefense.add(player.getInteriorDefense());
				teamPerimeterDefense.add(player.getPerimeterDefense());
				teamPlaymaking.add(player.getPlaymaking());
				
				teamRebounding.add(player.getRebounding());
				teamPhysicals.add(player.getPhysicals());
				teamIq.add(player.getIq());
				
				teamOvr += player.getOverall();
			}
			ins = GradesUtil.gradeAverage(teamInsideScoring, roster.size());
			mid = GradesUtil.gradeAverage(teamMidRangeScoring, roster.size());
			three = GradesUtil.gradeAverage(teamThreePointScoring, roster.size());
			
			intD = GradesUtil.gradeAverage(teamInteriorDefense, roster.size());
			perD = GradesUtil.gradeAverage(teamPerimeterDefense, roster.size());
			plm = GradesUtil.gradeAverage(teamPlaymaking, roster.size());
			
			reb = GradesUtil.gradeAverage(teamRebounding, roster.size());
			phy = GradesUtil.gradeAverage(teamPhysicals, roster.size());
			iq = GradesUtil.gradeAverage(teamIq, roster.size());
			
			team.setOverall(Math.round(teamOvr/roster.size()));
		}
		
		team.setInsideScoring(ins);
		team.setMidRangeScoring(mid);
		team.setThreePointScoring(three);
		
		team.setInteriorDefense(intD);
		team.setPerimeterDefense(perD);
		team.setPlaymaking(plm);
		
		team.setRebounding(reb);
		team.setPhysicals(phy);
		team.setIq(iq);
		
		LOGGER.info("Updated current team stat averages");
		return team;
	}
	
	public int getTeamIndex(){
		return teamIndex;
	}
	
	public int getLeagueSize() {
		return leagueSize;
	}
	
	public List<Player> getDraftPool() {
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
	}
}
