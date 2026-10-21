package com.jerielb.NBASideApp.repository;

import com.jerielb.NBASideApp.model.Franchise;
import com.jerielb.NBASideApp.model.Player;

import java.util.List;

/**
 * @Repository for the Franchise DB table 
 * - contains all communicating queries with the table
 **/
public interface FranchiseRepository {
	List<Franchise> findAll();
	Franchise findById(long franchiseId);
	Franchise getRandom(String league);
	List<Franchise> findCurrent(int size);
	List<Player> findPlayedFor(long franchiseId);
	List<Long> findPlayedForIds(long franchiseId);
}
