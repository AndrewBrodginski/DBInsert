package com.shanemalachow.DBInserter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A standard file parser that just returns an array of strings from each line
 * of a delimited text file.
 * 
 * @author Shane
 *
 */
public class FileParser {
	private Scanner scnr;
	private String filename;
	private String delimiter;

	/**
	 * Standard constructor for the FileParser, takes in the file name and the
	 * delimiter to use when separating entries in the file.
	 * 
	 * @param filename
	 *            The name of the file to be read
	 * @param delimiter
	 *            The delimiter between attributes of each entry.
	 * @throws FileNotFoundException
	 *             Thrown in the file in question is not found.
	 */
	public FileParser(String filename, String delimiter) throws FileNotFoundException {
		this.filename = filename;
		this.delimiter = delimiter;
		this.scnr = new Scanner(new File(this.filename));
	}

	/**
	 * Reads the next entry in the file, if there are any entries left.
	 * 
	 * @return An array of the next entry in the file, or null if no further
	 *         entries exist.
	 */
	public String[] next() {
		if (!scnr.hasNext()) {
			return null;
		}
		String entry = scnr.nextLine();
		String[] result = entry.split(delimiter);
		return result;
	}

	/**
	 * Determines whether or not there is any data left in the file.
	 * 
	 * @return a boolean indicating whether there is any data left in the file.
	 */
	public boolean hasNext() {
		return scnr.hasNext();
	}
}
