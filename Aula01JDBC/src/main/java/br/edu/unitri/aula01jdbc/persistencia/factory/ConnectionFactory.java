package br.edu.unitri.aula01jdbc.persistencia.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	// static reference to itself
	private static ConnectionFactory instance = new ConnectionFactory();
	public static final String URL = "jdbc:mysql://localhost:3306/persistencia-aula01";
	public static final String USER = "root";
	public static final String PASSWORD = "admin";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

	// private constructor
	private ConnectionFactory() {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}

	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return connection;
	}

	public static Connection getConnection() {
		return instance.createConnection();
	}
}
