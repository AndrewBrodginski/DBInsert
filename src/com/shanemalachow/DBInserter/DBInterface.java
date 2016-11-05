package com.shanemalachow.DBInserter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBInterface {
	private String db;
	private String statement = "INSERT INTO ? (";
	private Connection conn;
	private Controller main;

	public DBInterface(String db, String user, char[] pass) throws SQLException {
		this.db = db;
		conn = DriverManager.getConnection(db, user, new String(pass));
	}

	public boolean insert(String[] data, String table) throws SQLException {
		String s = statement;
		for (int x = 0; x < data.length; x++) {
			if (x == data.length - 1) {
				s = s.concat("?);");
			} else {
				s = s.concat("?,");
			}
		}
		PreparedStatement preparedStatement = conn.prepareStatement(statement);
		preparedStatement.setString(1, table);
		for (int x = 2; x <= data.length; x++) {
			//TODO: Handle more data types other than int, double, and string.
			if (data[x - 2].matches("(0-9)+")) {
				preparedStatement.setInt(x, Integer.parseInt(data[x - 2]));
			} else if (data[x - 1].matches("(0-9)+.(0-9)+")) {
				preparedStatement.setDouble(x, Double.parseDouble(data[x - 2]));
			} else {
				preparedStatement.setString(x, data[x - 2]);
			}
		}
		preparedStatement.executeQuery();
		return false;
	}

	public boolean login(String user, char[] pass) {
		return false;
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
