package com.parser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection = prepareConnection();
		Statement statement = connection.createStatement();
		String query = "select * from words limit 20,10";
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			System.out.println(resultSet.getString("wordId") + " " + resultSet.getString("word"));
			MerriamWebster.getMeanings(resultSet.getString("word"));
		}
	}

	public static Connection prepareConnection() throws ClassNotFoundException, SQLException {
		String driverClass = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/dawn";
		String user = "root";
		String password = "root";
		Class.forName(driverClass);
		return DriverManager.getConnection(url, user, password);
	}
}
