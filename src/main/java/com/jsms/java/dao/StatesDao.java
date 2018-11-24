package com.jsms.java.dao;

import java.util.List;

import com.jsms.java.model.District;
import com.jsms.java.model.State;

public interface StatesDao {
	List<State> getAllStates();
	List<District> getDistrictsById(int id);
	List<District> getSubDistrictsById(int id);
}
