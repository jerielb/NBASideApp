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
}
