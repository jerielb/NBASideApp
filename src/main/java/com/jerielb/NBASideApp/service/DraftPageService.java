package com.jerielb.NBASideApp.service;

import com.jerielb.NBASideApp.controller.DraftPageController;
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
    private static int rosterAmount = 5;
    private static List<Player> roster = new ArrayList<>();
	private static List<Player> draftPool = new ArrayList<>();
    
    // constructor
    public DraftPageService() {}
	
    // functions
	public void reset(int rosterAmount, List<Player> draftPool) {
		this.rosterAmount = rosterAmount;
		this.draftPool = draftPool;
		roster.clear();
	}
	
	public boolean draftPlayerToTeam(int playerId) {
		Optional<Player> playerOptional = draftPool.stream().filter(e -> e.getPlayerId() == playerId).findFirst();
		Player player = playerOptional.get();
		LOGGER.info("Drafted player: " + player.getFullName());
		
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
	
	public List<Player> getRoster() {
		return roster;
	}
	
	public List<Player> getDraftPool() {
		return draftPool;
	}
}
