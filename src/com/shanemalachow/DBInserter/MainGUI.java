package com.shanemalachow.DBInserter;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class MainGUI extends JFrame {
	private JTextField pathField;
	private JTextField tableField;
	private JTextField fileField;
	private JTextField delimiterField;
	private JTextPane txtpnConsole;
	private Controller main;
	private JTextField userField;
	private JPasswordField passField;

	public MainGUI(Controller con) {
		setTitle("DBInserter");
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		main = con;

		JLabel lblDatabasePath = new JLabel("Database Path");
		getContentPane().add(lblDatabasePath);

		JLabel lblTableName = new JLabel("Table Name");
		springLayout.putConstraint(SpringLayout.WEST, lblDatabasePath, 0, SpringLayout.WEST, lblTableName);
		springLayout.putConstraint(SpringLayout.WEST, lblTableName, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblTableName);

		JLabel lblFileName = new JLabel("File Name");
		springLayout.putConstraint(SpringLayout.WEST, lblFileName, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblFileName);

		JLabel lblDelimiter = new JLabel("Delimiter");
		springLayout.putConstraint(SpringLayout.WEST, lblDelimiter, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblFileName, -12, SpringLayout.NORTH, lblDelimiter);
		getContentPane().add(lblDelimiter);

		pathField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, pathField, 5, SpringLayout.EAST, lblDatabasePath);
		springLayout.putConstraint(SpringLayout.EAST, pathField, -153, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblDatabasePath, 3, SpringLayout.NORTH, pathField);
		springLayout.putConstraint(SpringLayout.SOUTH, pathField, 27, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, pathField, 7, SpringLayout.NORTH, getContentPane());
		getContentPane().add(pathField);
		pathField.setColumns(10);

		tableField = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, tableField, 0, SpringLayout.EAST, pathField);
		springLayout.putConstraint(SpringLayout.NORTH, lblTableName, 3, SpringLayout.NORTH, tableField);
		springLayout.putConstraint(SpringLayout.NORTH, tableField, 6, SpringLayout.SOUTH, pathField);
		springLayout.putConstraint(SpringLayout.WEST, tableField, 0, SpringLayout.WEST, pathField);
		getContentPane().add(tableField);
		tableField.setColumns(10);

		fileField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lblFileName, 3, SpringLayout.NORTH, fileField);
		springLayout.putConstraint(SpringLayout.NORTH, fileField, 6, SpringLayout.SOUTH, tableField);
		springLayout.putConstraint(SpringLayout.WEST, fileField, 0, SpringLayout.WEST, tableField);
		springLayout.putConstraint(SpringLayout.EAST, fileField, 0, SpringLayout.EAST, tableField);
		getContentPane().add(fileField);
		fileField.setColumns(10);

		delimiterField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lblDelimiter, 3, SpringLayout.NORTH, delimiterField);
		springLayout.putConstraint(SpringLayout.NORTH, delimiterField, 6, SpringLayout.SOUTH, fileField);
		springLayout.putConstraint(SpringLayout.WEST, delimiterField, 0, SpringLayout.WEST, fileField);
		springLayout.putConstraint(SpringLayout.EAST, delimiterField, 0, SpringLayout.EAST, fileField);
		getContentPane().add(delimiterField);
		delimiterField.setColumns(10);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				insert();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnInsert, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnInsert, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnInsert);

		txtpnConsole = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, txtpnConsole, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtpnConsole, 0, SpringLayout.EAST, delimiterField);
		txtpnConsole.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
		springLayout.putConstraint(SpringLayout.NORTH, txtpnConsole, 10, SpringLayout.SOUTH, delimiterField);
		txtpnConsole.setEditable(false);
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnConsole, 0, SpringLayout.SOUTH, btnInsert);
		txtpnConsole.setText(">GUI Start");
		getContentPane().add(txtpnConsole);

		JLabel lblUser = new JLabel("Username");
		springLayout.putConstraint(SpringLayout.WEST, lblUser, 5, SpringLayout.EAST, txtpnConsole);
		getContentPane().add(lblUser);

		userField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, userField, 5, SpringLayout.EAST, txtpnConsole);
		springLayout.putConstraint(SpringLayout.EAST, userField, -10, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblUser, -5, SpringLayout.NORTH, userField);
		getContentPane().add(userField);
		userField.setColumns(10);

		passField = new JPasswordField();
		springLayout.putConstraint(SpringLayout.WEST, passField, 5, SpringLayout.EAST, txtpnConsole);
		springLayout.putConstraint(SpringLayout.SOUTH, passField, -6, SpringLayout.NORTH, btnInsert);
		springLayout.putConstraint(SpringLayout.EAST, passField, 0, SpringLayout.EAST, btnInsert);
		getContentPane().add(passField);
		passField.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		springLayout.putConstraint(SpringLayout.WEST, lblPassword, 0, SpringLayout.WEST, passField);
		springLayout.putConstraint(SpringLayout.SOUTH, userField, -5, SpringLayout.NORTH, lblPassword);
		springLayout.putConstraint(SpringLayout.SOUTH, lblPassword, -5, SpringLayout.NORTH, passField);
		getContentPane().add(lblPassword);
	}

	public void print(String s) {
		s = "\n>" + s;
		String history = txtpnConsole.getText();
		txtpnConsole.setText(history + s);
	}

	public void insert() {
		main.login(userField.getText(), passField.getPassword());
		main.insertData(pathField.getText(), tableField.getText(), fileField.getText(), delimiterField.getText());
	}
}
