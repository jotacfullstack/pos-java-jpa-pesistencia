package br.edu.unitri.aula01sale.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
	private static final String driver = "org.apache.derby.jdbc.ClientDriver";
	private static final String url = "jdbc:derby:memory:posjava-aula02;create=true";
	private static final String user = "app";
	private static final String password = "app";
	private static final Logger logger = Logger
			.getLogger(ConnectionFactory.class.getName());

	public static Connection getConnection() {
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			return con;
		} catch (ClassNotFoundException | SQLException ex) {
			throw new RuntimeException("Erro: banco " + url + ". " + ex);
		}
	}

	public static void closeConnection(Connection con, Statement stmt,
			ResultSet rs) {
		try { // ...
		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Erro: banco " + url + ". {0}", ex);
		}
	}
}