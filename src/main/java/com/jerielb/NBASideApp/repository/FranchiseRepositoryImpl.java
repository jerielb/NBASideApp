package com.jerielb.NBASideApp.repository;

import com.jerielb.NBASideApp.model.Franchise;
import com.jerielb.NBASideApp.repository.rowmapper.FranchiseRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FranchiseRepositoryImpl implements FranchiseRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private FranchiseRowMapper franchiseMapper;
	
	@Override
	public List<Franchise> findAll() {
		String query = "select * from FRANCHISE";
		return jdbcTemplate.query(query, franchiseMapper);
	}
	
	@Override
	public Franchise findById(long franchiseId) {
		String query = "select * from PLAYER where PLAYER_ID = ?";
		return jdbcTemplate.queryForObject(query, franchiseMapper, franchiseId);
	}
	
	@Override
	public Franchise getRandom(String league) {
		String query;
		if (league.equals("hoop-land")) {
			query = "select * from FRANCHISE where ACTIVE = ? order by rand() limit 1;";
		} else {
			// league = "nba"
			query = "select * from FRANCHISE where ACTIVE != '' and ACTIVE != ? order by rand() limit 1;";
		}
		return jdbcTemplate.queryForObject(query, franchiseMapper, "HL");
	}
}
