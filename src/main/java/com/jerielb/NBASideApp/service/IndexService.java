package com.jerielb.NBASideApp.service;

import com.jerielb.NBASideApp.model.enums.FranchiseAcr;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IndexService {
    private final Logger LOGGER = LogManager.getLogger(IndexService.class);
    
//    private Set<FranchiseAcr> teams = new HashSet<>(Arrays.asList(FranchiseAcr.values()));
    private List<FranchiseAcr> teams = new LinkedList<>(Arrays.asList(FranchiseAcr.values()));
    
    @Autowired
    public IndexService() {}
    
    public List<FranchiseAcr> getRandomTeams(int playoffTeams) {
        List<FranchiseAcr> franchises = new ArrayList<>();
        
        for (int i=0; i<playoffTeams; i++) {
            int randomIndex = new Random().nextInt(teams.size());
            FranchiseAcr chosen = teams.get(randomIndex);
            
            System.out.println(i + ". Team Chosen: " + chosen);
            
            franchises.add(chosen);
            teams.remove(randomIndex);
        }
        
        return franchises;
    }
}
