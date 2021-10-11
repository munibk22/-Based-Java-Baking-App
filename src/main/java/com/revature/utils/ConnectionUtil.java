package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() throws SQLException {

		try {
			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		String url = "jdbc:postgresql://java-db.cbqphqthw4wu.us-east-2.rds.amazonaws.com:5432/bank";
		String username = "postgres";
		String password = "password";

		return DriverManager.getConnection(url, username, password);

	}

	public static void getConn() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("Connection successfull!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
