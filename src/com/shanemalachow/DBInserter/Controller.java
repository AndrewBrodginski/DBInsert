package com.shanemalachow.DBInserter;

import java.io.FileNotFoundException;
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
		FileParser in;
		try {
			in = new FileParser(file, delim);

			int x = 1;
			while (in.hasNext()) {
				String[] data = in.next();
				try {
					db.insert(data, table);
				} catch (SQLException e) {
					e.printStackTrace();
					print("Error inserting entry " + x);
				}
				x++;
			}
			print(String.format("Finished inserting. Encountered %d entries", x));
			return true;
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			print("File does not exist.");
			return false;
		}
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
