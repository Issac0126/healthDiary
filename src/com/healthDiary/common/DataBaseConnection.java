package com.healthDiary.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

	private DataBaseConnection() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static DataBaseConnection connection = new DataBaseConnection();
	
	public static DataBaseConnection getInstance() {
		return connection;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
	}
	
	
	
}
