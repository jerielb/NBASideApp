package com.jerielb.NBASideApp.service;

import com.jerielb.NBASideApp.controller.DraftPageController;
import com.jerielb.NBASideApp.model.GradesUtil;
import com.jerielb.NBASideApp.model.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DraftPageService {
    // variables
    private final Logger LOGGER = LogManager.getLogger(DraftPageController.class);
    private static int rosterSize = 5;
    private static List<Player> roster = new ArrayList<>();
	private static List<Player> draftPool = new ArrayList<>();
	private static Player teamTotals = new Player();
    
    // constructor
    public DraftPageService() {}
	
    // functions
	public void reset(int rosterSize, List<Player> draftPool) {
		this.rosterSize = rosterSize;
		this.draftPool = draftPool;
		roster.clear();
	}
	
	public boolean draftPlayerToTeam(int playerId) {
		Optional<Player> playerOptional = draftPool.stream().filter(e -> e.getPlayerId() == playerId).findFirst();
		Player player = playerOptional.get();
		LOGGER.info("Drafted player: " + player.getFullName());
		
        roster.add(player);
		draftPool.remove(player);
		
        if (roster.size() < rosterSize) {
            return false;
        } else {
            // complete roster
            return true;
        }
    }
	
	public Player teamSummaryStats() {
		// instead of creating new Java object make use of the existing Player object
		teamTotals.setFullName("Totals: ");
		List<String> teamInsideScoring = new ArrayList<>();
		List<String> teamMidRangeScoring = new ArrayList<>();
		List<String> teamThreePointScoring = new ArrayList<>();
		
		List<String> teamInteriorDefense = new ArrayList<>();
		List<String> teamPerimeterDefense = new ArrayList<>();
		List<String> teamPlaymaking = new ArrayList<>();
		
		List<String> teamRebounding = new ArrayList<>();
		List<String> teamPhysicals = new ArrayList<>();
		List<String> teamIq = new ArrayList<>();
		
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
		}
		
		teamTotals.setInsideScoring(GradesUtil.gradeAverage(teamInsideScoring, roster.size()));
		teamTotals.setMidRangeScoring(GradesUtil.gradeAverage(teamMidRangeScoring, roster.size()));
		teamTotals.setThreePointScoring(GradesUtil.gradeAverage(teamThreePointScoring, roster.size()));
		
		teamTotals.setInteriorDefense(GradesUtil.gradeAverage(teamInteriorDefense, roster.size()));
		teamTotals.setPerimeterDefense(GradesUtil.gradeAverage(teamPerimeterDefense, roster.size()));
		teamTotals.setPlaymaking(GradesUtil.gradeAverage(teamPlaymaking, roster.size()));
		
		teamTotals.setRebounding(GradesUtil.gradeAverage(teamRebounding, roster.size()));
		teamTotals.setPhysicals(GradesUtil.gradeAverage(teamPhysicals, roster.size()));
		teamTotals.setIq(GradesUtil.gradeAverage(teamIq, roster.size()));
		
		return teamTotals;
	}
	
	public List<Player> getRoster() {
		return roster;
	}
	
	public List<Player> getDraftPool() {
		return draftPool;
	}
}
