package com.students.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	private static Connection dbConnection = null;

	public static Connection getConnection() {
		if (dbConnection != null) {
			return dbConnection;
		} else {
			try {
//				String dbDriver = System.getenv("dbDriver");
//				String connectionUrl = System.getenv("dbConnectionUrl");
//				String userName = System.getenv("dbUserName");
//				String password = System.getenv("dbPassword");
				
				
				String dbDriver = "com.mysql.cj.jdbc.Driver";
				String connectionUrl = "jdbc:mysql://localhost:3306/collegeapp_db ";
				String userName = "root";
				String password = "root";
				
				Class.forName(dbDriver);
				dbConnection = DriverManager.getConnection(connectionUrl, userName, password);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return dbConnection;
		}
	}
}
