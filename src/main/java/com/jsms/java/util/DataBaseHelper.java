package com.jsms.java.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.core.env.Environment;

public class DataBaseHelper {

	Environment env;
	Connection connection=null;
	PreparedStatement preparedStatement = null;
	
	public Connection getConnection(){
		try {
			Class.forName(env.getProperty("driverURL"));
			connection = DriverManager.getConnection(env.getProperty("databaseURL"), env.getProperty("databaseUserId"), env.getProperty("databasePassword"));
		} catch (Exception e) {
			
		}
		return connection;
	}
	
	public PreparedStatement getPreparedStatement(String sql){
		try {
			if(getConnection()!=null)
				preparedStatement = getConnection().prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}
}
