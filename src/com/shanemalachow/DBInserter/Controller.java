package com.shanemalachow.DBInserter;

import java.sql.SQLException;

import javax.swing.JFrame;

public class Controller {

	private JFrame frame;
	private DBInterface db;

	public Controller() {
		frame = new MainGUI(this);
		db = null;
	}

	public boolean insertData(String table, String file, String delim) {
		FileParser in = new FileParser(this, file, delim);
		while (in.hasNext()) {
			String[] data = in.next();
		}
		return false;
	}

	public boolean login(String db, String user, char[] pass) {
		try {
			this.db = new DBInterface(db, user, pass);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			print("Unexpected SQL Exception.");
			print("Login Failed.");
			return false;
		}
	}

	public void print(String s) {
		if (frame instanceof MainGUI) {
			((MainGUI) frame).print(s);
		} else {
			System.out.println(">" + s);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
