package com.jerielb.NBASideApp.repository.rowmapper;

import com.jerielb.NBASideApp.model.Player;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PlayerRowMapper implements RowMapper<Player> {
    @Override
    public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
        Player player = new Player();
        long playerId = rs.getLong("PLAYER_ID");
        String full_name = rs.getString("FULL_NAME");
        String image = playerId + "-" + full_name.replace(' ', '_');

        player.setPlayerId(playerId);
        player.setFullName(full_name);
        player.setPositions(rs.getString("POSITIONS"));
        player.setImage(image);
        
        player.setLayup(rs.getString("LAY"));
        player.setDunk(rs.getString("DNK"));
        player.setInsideScoring(rs.getString("INS"));
        
        player.setMidRangeScoring(rs.getString("MID"));
        player.setThreePointScoring(rs.getString("3PT"));
        player.setFreeThrow(rs.getString("FT"));
        
        player.setDribbling(rs.getString("DRB"));
        player.setPassing(rs.getString("PAS"));
        player.setOffensiveRebounding(rs.getString("ORE"));
        
        player.setDefensiveRebounding(rs.getString("DRE"));
        player.setSteal(rs.getString("STL"));
        player.setBlock(rs.getString("BLK"));
        
        player.setOverall(rs.getString("OVR"));

        player.setDrafted(false);
        return player;
    }
}
