package com.shanemalachow.DBInserter;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.swing.JFrame;

public class Controller {

	private JFrame frame;
	private DBInterface db;

	/**
	 * Standard constructor for the Controller, creating the frame work of GUI
	 */
	
	public Controller() {
		frame = new MainGUI(this);
		db = null;
	}
	
	/**
	 * Determines where or not the data was Inserted with a true or false
	 * 
	 * @param table
	 * 		The table the data is being inserted into
	 * @param file
	 * 		The name of the file to be read
	 * @param delim
	 * 		The delimiter between attributes of each entry.
	 * @return
	 *		Whether or not the data was inserted 
	 *
	 */


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
	
	/**
	 * Determines whether or not the User logged in successfully
	 * 
	 * @param db
	 * 		The database the user is trying to access
	 * @param user
	 * 		The login ID for the user
	 * @param pass
	 * 		The users password for the database
	 * @return
	 * 		A true or false, indicating if the login was successful
	 */

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
