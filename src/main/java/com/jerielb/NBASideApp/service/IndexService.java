package com.jerielb.NBASideApp.service;

import com.jerielb.NBASideApp.model.enums.EastFranchise;
import com.jerielb.NBASideApp.model.enums.WestFranchise;
import com.jerielb.NBASideApp.model.wrappers.EastBracketWrapper;
import com.jerielb.NBASideApp.model.wrappers.WestBracketWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IndexService {
    private final Logger LOGGER = LogManager.getLogger(IndexService.class);
    private final List<WestFranchise> WEST_FRANCHISES = List.of(WestFranchise.values());
    private final List<EastFranchise> EAST_FRANCHISES = List.of(EastFranchise.values());
    
    
    @Autowired
    public IndexService() {}
    
    public List<WestFranchise> getWestTeamsTop() {
        return WEST_FRANCHISES.subList(0,8);
    }
    public List<WestFranchise> getWestTeamsBottom() {
        return WEST_FRANCHISES.subList(8,15);
    }
    
    public List<EastFranchise> getEastTeamsTop() {
        return EAST_FRANCHISES.subList(0,8);
    }
    public List<EastFranchise> getEastTeamsBottom() {
        return EAST_FRANCHISES.subList(8,15);
    }
    
    public WestBracketWrapper getRandomWestTeams(int playoffTeams, WestFranchise team) {
        List<WestFranchise> westFranchises = new ArrayList<>();
        List<WestFranchise> westTeams = new LinkedList<>(WEST_FRANCHISES);
        boolean playerTeam = false;
        if (team != null) {
            team.setSelected(true);
            westTeams.remove(team);
            playerTeam = true;
        }
        
        for (int i=0; i<playoffTeams/2; i++) {
            int randomIndex = new Random().nextInt(westTeams.size());
            WestFranchise chosen = westTeams.get(randomIndex);
//            LOGGER.info((i+1) + ". West Team Chosen: " + chosen);
            if (playerTeam && (new Random().nextBoolean())) {
                westFranchises.add(team);
                playerTeam = false;
            }
            
            westFranchises.add(chosen);
            westTeams.remove(randomIndex);
        }
        
        if (playerTeam) {
            westFranchises.add(team);
        }
        
        return new WestBracketWrapper(playoffTeams, westFranchises);
    }
    
    public EastBracketWrapper getRandomEastTeams(int playoffTeams, EastFranchise team) {
        List<EastFranchise> eastFranchises = new ArrayList<>();
        List<EastFranchise> eastTeams = new LinkedList<>(EAST_FRANCHISES);
        boolean playerTeam = false;
        if (team != null) {
            team.setSelected(true);
            eastTeams.remove(team);
            playerTeam = true;
        }
        
        for (int i=0; i<playoffTeams/2; i++) {
            int randomIndex = new Random().nextInt(eastTeams.size());
            EastFranchise chosen = eastTeams.get(randomIndex);
//            LOGGER.info((i+1) + ". East Team Chosen: " + chosen);
            if (playerTeam && (new Random().nextBoolean())) {
                eastTeams.add(team);
                playerTeam = false;
            }
            
            eastFranchises.add(chosen);
            eastTeams.remove(randomIndex);
        }
        
        if (playerTeam) {
            eastFranchises.add(team);
        }
        
        return new EastBracketWrapper(playoffTeams, eastFranchises);
    }
}
