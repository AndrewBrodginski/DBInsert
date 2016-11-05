package com.shanemalachow.DBInserter;

import javax.swing.JFrame;

public class Controller {

	private JFrame frame;
	private DBInterface db;

	public Controller() {
		frame = new MainGUI(this);
		db = new DBInterface();
	}

	public boolean insertData(String db, String table, String file, String delim) {
		FileParser in = new FileParser(this, file, delim);
		while (in.hasNext()) {

		}
		return false;
	}

	public void login(String user, char[] pass) {

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
