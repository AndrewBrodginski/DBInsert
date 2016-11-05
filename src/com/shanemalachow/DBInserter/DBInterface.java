package com.shanemalachow.DBInserter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBInterface {
	private String db;
	private Connection conn;
	private Controller main;

	public DBInterface(String db, String user, char[] pass) throws SQLException {
		this.db = db;
		conn = DriverManager.getConnection(db, user, new String(pass));
	}

	public boolean login(String user, char[] pass) {
		return false;
	}
}
