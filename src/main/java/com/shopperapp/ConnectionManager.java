package com.shopperapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static DatabaseConfiguration CONFIG;

	public static Connection getConnection() throws SQLException {
		try {
			CONFIG = new DatabaseConfiguration();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (CONFIG != null) {
			String dbName = CONFIG.getDbName();
			String userName = CONFIG.getUserName();
			String password = CONFIG.getPassword();
			String hostname = CONFIG.getHostname();
			String port = CONFIG.getPort();
			String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password="
					+ password;
			return DriverManager.getConnection(jdbcUrl);
		}
		
		throw new IllegalArgumentException("Cannot get database connection configuration");
	}
}