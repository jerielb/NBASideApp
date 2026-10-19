package com.jerielb.NBASideApp.repository;

import com.jerielb.NBASideApp.model.Franchise;

import java.util.List;

/**
 * @Repository for the Franchise DB table 
 * - contains all communicating queries with the table
 **/
public interface FranchiseRepository {
	List<Franchise> findAll();
	Franchise findById(long franchiseId);
	Franchise getRandom(String league);
}
