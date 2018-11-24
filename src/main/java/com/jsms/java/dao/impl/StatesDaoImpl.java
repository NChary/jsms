package com.jsms.java.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jsms.java.constants.JsfsTables;
import com.jsms.java.dao.StatesDao;
import com.jsms.java.model.District;
import com.jsms.java.model.State;
import com.jsms.java.model.SubDistrict;

@Repository(value="statesDao")
public class StatesDaoImpl implements StatesDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate(){
		return jdbcTemplate;
	}
	
	
	@Override
	public List<State> getAllStates() {
		String sql="select * from "+JsfsTables.STATES;
		List<State> states = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(State.class));
		return states;
	}

	class StatesRowMapper implements RowMapper
	{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			State state = new State();
			state.setId(rs.getInt("Id"));
			state.setStateName(rs.getString("stateName"));
			state.setCountryId(rs.getInt("countryId"));
			return state;
		}							

	}

	@Override
	public List<District> getDistrictsById(int id) {
		String sql = "select * from "+JsfsTables.DISTRICTS+" where stateId="+id;
		List<District> districts = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(District.class));
		return districts;
	}


	@Override
	public List getSubDistrictsById(int id) {
		String sql = "select * from "+JsfsTables.SUBDISTRICTS+" where districtId="+id;
		List<SubDistrict> subDistricts = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(SubDistrict.class));
		return subDistricts;
	}

	 	
}
