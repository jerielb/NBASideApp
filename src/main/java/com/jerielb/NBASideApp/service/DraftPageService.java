package com.jerielb.NBASideApp.service;

import com.jerielb.NBASideApp.controller.DraftPageController;
import com.jerielb.NBASideApp.model.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DraftPageService {
    // variables
    private final Logger LOGGER = LogManager.getLogger(DraftPageController.class);
    private static int rosterAmount = 0;
    private static List<Player> roster = new ArrayList<>();
	private static List<Player> draftPool = new ArrayList<>();
    
    // constructor
    public DraftPageService() {}
	
	public void reset(int rosterAmount, List<Player> draftPool) {
		this.rosterAmount = rosterAmount;
		this.draftPool = draftPool;
		roster.clear();
	}
    
    // functions
    public boolean draftPlayerToTeam(Player player) {
        roster.add(player);
		draftPool.remove(player);
		
        if (roster.size() < rosterAmount) {
            //  incomplete roster
            return false;
        } else {
            // full roster
            return true;
        }
    }
	
	public List<Player> getDraftPool() {
		return draftPool;
	}
}
