package com.jerielb.NBASideApp.repository;

import com.jerielb.NBASideApp.model.Franchise;
import com.jerielb.NBASideApp.model.Player;
import com.jerielb.NBASideApp.repository.rowmapper.FranchiseRowMapper;
import com.jerielb.NBASideApp.repository.rowmapper.PlayerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FranchiseRepositoryImpl implements FranchiseRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private FranchiseRowMapper franchiseMapper;
	@Autowired
	private PlayerRowMapper playerMapper;
	
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
			query = "select * from FRANCHISE where ACTIVE = 'HL' order by rand() limit 1;";
		} else {
			// league = "nba"
			query = "select * from FRANCHISE where ACTIVE = '' order by rand() limit 1;";
		}
		return jdbcTemplate.queryForObject(query, franchiseMapper);
	}
	
	@Override
	public List<Franchise> findCurrent(int size) {
		String query = "select * from FRANCHISE where ACTIVE = '' order by rand() limit ?";
		return jdbcTemplate.query(query, franchiseMapper, size);
	}
	
	@Override
	public List<Long> findHistoric(String franchiseAcronym) {
		String query = "select FRANCHISE_ID from FRANCHISE where ACTIVE = ?";
		return jdbcTemplate.queryForList(query, Long.class, franchiseAcronym);
	}
	
	@Override
	public List<Player> findPlayedFor(long franchiseId) {
		String query = "select p.* from PLAYER p " +
				"join PLAYED_FOR pf on p.PLAYER_ID = pf.PLAYER_ID " +
				"join FRANCHISE f on pf.FRANCHISE_ID = f.FRANCHISE_ID " +
				"where pf.FRANCHISE_ID = ?";
		return jdbcTemplate.query(query, playerMapper, franchiseId);
	}
	
	@Override
	public List<Long> findPlayedForIds(List<Long> franchiseIds) {
		String placeholders = franchiseIds.stream()
				.map(n -> "?")
				.collect(Collectors.joining(", "));
		String query = "select p.PLAYER_ID from PLAYER p " +
				"join PLAYED_FOR pf on p.PLAYER_ID = pf.PLAYER_ID " +
				"join FRANCHISE f on pf.FRANCHISE_ID = f.FRANCHISE_ID " +
				"where pf.FRANCHISE_ID in (" + placeholders + ") group by PLAYER_ID";
		Object[] args = new Object[franchiseIds.size()];
		for (int i = 0; i < franchiseIds.size(); i++) {
			args[i] = franchiseIds.get(i);
		}
		return jdbcTemplate.queryForList(query, Long.class, args);
	}
	
	@Override
	public List<Long> findDraftedByIds(List<Long> franchiseIds) {
		String placeholders = franchiseIds.stream()
				.map(n -> "?")
				.collect(Collectors.joining(", "));
		String query = "select p.PLAYER_ID from PLAYER p " +
				"join DRAFTED_BY db on p.PLAYER_ID = db.PLAYER_ID " +
				"join FRANCHISE f on db.FRANCHISE_ID = f.FRANCHISE_ID " +
				"where db.FRANCHISE_ID in (" + placeholders + ") group by PLAYER_ID";
		Object[] args = new Object[franchiseIds.size()];
		for (int i = 0; i < franchiseIds.size(); i++) {
			args[i] = franchiseIds.get(i);
		}
		return jdbcTemplate.queryForList(query, Long.class, args);
	}
}
