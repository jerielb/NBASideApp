package com.jerielb.NBASideApp.service;

import com.jerielb.NBASideApp.model.Player;
import com.jerielb.NBASideApp.repository.PlayerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {
    // variables
    private final Logger LOGGER = LogManager.getLogger(IndexService.class);
    // repos
    private final PlayerRepository playerRepository;
    
    // constructor
    @Autowired
    public IndexService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    
    // functions
    public List<Player> getAllPlayers() {
        LOGGER.info("Getting all players from PLAYER table");
        return playerRepository.findAll();
    }
}
