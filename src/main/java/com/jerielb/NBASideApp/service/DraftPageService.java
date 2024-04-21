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
			
			teamTotals.setOverall(Math.round(teamOvr/roster.size()));
		}
		
		teamTotals.setInsideScoring(ins);
		teamTotals.setMidRangeScoring(mid);
		teamTotals.setThreePointScoring(three);
		
		teamTotals.setInteriorDefense(intD);
		teamTotals.setPerimeterDefense(perD);
		teamTotals.setPlaymaking(plm);
		
		teamTotals.setRebounding(reb);
		teamTotals.setPhysicals(phy);
		teamTotals.setIq(iq);
		
		return teamTotals;
	}
	
	public List<Player> getRoster() {
		return roster;
	}
	
	public List<Player> getDraftPool() {
		return draftPool;
	}
}
