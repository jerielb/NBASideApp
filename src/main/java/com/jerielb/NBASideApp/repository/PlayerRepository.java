package com.jerielb.NBASideApp.repository;

import com.jerielb.NBASideApp.model.Player;

import java.util.List;

/**
 * @Repository for the PLAYER DB table 
 * - contains all communicating queries with the table
**/
public interface PlayerRepository {
    List<Player> findAll();
    Player findById(long playerId);
    int addPlayer(Player player);
}
