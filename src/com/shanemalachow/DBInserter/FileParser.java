package com.shanemalachow.DBInserter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileParser {
	private Scanner scnr;
	private String filename;
	private String delimiter;
	private Controller main;

	public FileParser(Controller con, String filename, String delimiter) {
		this.filename = filename;
		this.main = con;
		this.delimiter = delimiter;
		try {
			this.scnr = new Scanner(new File(this.filename));
		} catch (FileNotFoundException e) {
			main.print("File not found.");
			main.print("Halting.");
		}
	}

	public String[] readEntry() {
		if (!scnr.hasNext()) {
			return null;
		}
		String entry = scnr.nextLine();
		String[] result = entry.split(delimiter);
		return result;
	}

	public boolean hasNext() {
		return scnr.hasNext();
	}
}
