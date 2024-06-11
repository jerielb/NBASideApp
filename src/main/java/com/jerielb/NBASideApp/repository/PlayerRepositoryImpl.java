package com.jerielb.NBASideApp.repository;

import com.jerielb.NBASideApp.model.Player;
import com.jerielb.NBASideApp.repository.rowmapper.PlayerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerRepositoryImpl implements PlayerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private PlayerRowMapper playerMapper;

    @Override
    public List<Player> findAll() {
        String query = "select * from PLAYER";
        return jdbcTemplate.query(query, playerMapper);
    }

    @Override
    public Player findById(long playerId) {
        String query = "select * from PLAYER where PLAYER_ID = ?";
        return jdbcTemplate.queryForObject(query, playerMapper, playerId);
    }

    @Override
    public int addPlayer(Player player) {
        String query = "insert into PLAYER(" +
                "PLAYER_ID, FULL_NAME, POSITIONS, OVERALL, " +
                "INSIDE_SCORING, MID_RANGE_SCORING, THREE_POINT_SCORING, " +
                "INTERIOR_DEFENSE, PERIMETER_DEFENSE, PLAYMAKING, " +
                "REBOUNDING, PHYSICALS, IQ) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(query, 
                player.getPlayerId(),
                player.getFullName(),
                player.getPositions(),
                player.getOverall(),
                
                player.getInsideScoring(),
                player.getMidRangeScoring(),
                player.getThreePointScoring(),
                
                player.getInsideScoring(),
                player.getPerimeterDefense(),
                player.getPlaymaking(),
                
                player.getRebounding(),
                player.getRebounding(),
                player.getIq()
        );
    }
    
}
