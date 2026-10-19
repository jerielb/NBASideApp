package com.jerielb.NBASideApp.repository.rowmapper;

import com.jerielb.NBASideApp.model.Franchise;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class FranchiseRowMapper implements RowMapper<Franchise> {
    @Override
    public Franchise mapRow(ResultSet rs, int rowNum) throws SQLException {
        Franchise franchise = new Franchise();
        
        franchise.setFranchiseId(rs.getLong("FRANCHISE_ID"));
        franchise.setAcronym(rs.getString("ACRONYM"));
        franchise.setTeamCity(rs.getString("TEAM_CITY"));
        franchise.setTeamName(rs.getString("TEAM_NAME"));
        franchise.setActive(rs.getString("ACTIVE"));

        return franchise;
    }
}
