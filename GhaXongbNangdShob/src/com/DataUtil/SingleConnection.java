package com.DataUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SingleConnection {

	private static SingleConnection instance = null;
	private static String url = "jdbc:mysql://localhost:3306/gxns";
	private static String username = "root";
	private static String password = "ld123456";

	private SingleConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static SingleConnection getSingleInstance() {
		if (instance == null) {
			instance = new SingleConnection();
		}
		return instance;
	}

	public Connection getConn() throws SQLException {

		return DriverManager.getConnection(url, username, password);
	}

	public static void Close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (conn != null)
				conn.close();
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
