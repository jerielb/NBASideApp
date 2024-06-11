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
		
        player.setPlayerId(rs.getLong("PLAYER_ID"));
        player.setFullName(rs.getString("FULL_NAME"));
        player.setPositions(rs.getString("POSITIONS"));
        player.setOverall(rs.getInt("OVERALL"));
        
        player.setInsideScoring(rs.getString("INSIDE_SCORING"));
        player.setMidRangeScoring(rs.getString("MID_RANGE_SCORING"));
        player.setThreePointScoring(rs.getString("THREE_POINT_SCORING"));
        
        player.setInteriorDefense(rs.getString("INTERIOR_DEFENSE"));
        player.setPerimeterDefense(rs.getString("PERIMETER_DEFENSE"));
        player.setPlaymaking(rs.getString("PLAYMAKING"));
		
        player.setRebounding(rs.getString("REBOUNDING"));
        player.setPhysicals(rs.getString("PHYSICALS"));
        player.setIq(rs.getString("IQ"));
		
        return player;
    }
}
