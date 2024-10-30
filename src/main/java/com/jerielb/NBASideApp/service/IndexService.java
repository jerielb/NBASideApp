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
    
    @Autowired
    public IndexService() {}
    
    public WestBracketWrapper getRandomWestTeams(int playoffTeams) {
        List<WestFranchise> westFranchises = new ArrayList<>();
        List<WestFranchise> westTeams = new LinkedList<>(Arrays.asList(WestFranchise.values()));
        
        for (int i=0; i<playoffTeams/2; i++) {
            int randomIndex = new Random().nextInt(westTeams.size());
            WestFranchise chosen = westTeams.get(randomIndex);
            
            LOGGER.info((i+1) + ". West Team Chosen: " + chosen);
            
            westFranchises.add(chosen);
            westTeams.remove(randomIndex);
        }
        
        return new WestBracketWrapper(playoffTeams, westFranchises);
    }
    
    public EastBracketWrapper getRandomEastTeams(int playoffTeams) {
        List<EastFranchise> eastFranchises = new ArrayList<>();
        List<EastFranchise> eastTeams = new LinkedList<>(Arrays.asList(EastFranchise.values()));
        
        for (int i=0; i<playoffTeams/2; i++) {
            int randomIndex = new Random().nextInt(eastTeams.size());
            EastFranchise chosen = eastTeams.get(randomIndex);
            
            LOGGER.info((i+1) + ". East Team Chosen: " + chosen);
            
            eastFranchises.add(chosen);
            eastTeams.remove(randomIndex);
        }
        
        return new EastBracketWrapper(playoffTeams, eastFranchises);
    }
}
