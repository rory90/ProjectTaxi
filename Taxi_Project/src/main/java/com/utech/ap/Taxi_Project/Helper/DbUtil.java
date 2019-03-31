package com.utech.ap.Taxi_Project.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	
	String driverClassName = "com.mysql.cj.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/Taxi?autoReconnect=true&useSSL=false";
	String dbUser = "root";
	String dbPwd = "rory123";

	private static DbUtil dbUtil = null;

	private DbUtil() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		return conn;
	}

	public static DbUtil getInstance() {
		if (dbUtil == null) {
			dbUtil = new DbUtil();
		}
		return dbUtil;
	}

}
