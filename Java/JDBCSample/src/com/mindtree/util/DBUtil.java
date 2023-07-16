package com.mindtree.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mindtree.exception.daoexception.DatabaseConnectionFailedException;

public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/jdbc_sample?autoReconnect=true&useSSL=false";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "949195";

	public Connection getMyConnection() throws DatabaseConnectionFailedException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		} catch (SQLException e) {
			throw new DatabaseConnectionFailedException("Databse could not be connected",e);
		}
		return con;
	}

	public void closeResource(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void closeResource(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void closeResource(PreparedStatement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void closeResource(ResultSet st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
