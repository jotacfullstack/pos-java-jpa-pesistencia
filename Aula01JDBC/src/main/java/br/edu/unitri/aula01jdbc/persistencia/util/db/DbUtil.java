package br.edu.unitri.aula01jdbc.persistencia.util.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class DbUtil {
	public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
            	throw new RuntimeException("Erro ao fechar o Connection "+ e.getMessage());
            }
        }
    }
 
    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
            	throw new RuntimeException("Erro ao ao fechar o Statement" + e.getMessage());
            }
        }
    }
    
    public static void close(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
            	preparedStatement.close();
            } catch (SQLException e) {
            	throw new RuntimeException("Erro ao ao fechar o PreparedStatement" + e.getMessage());
            }
        }
    }
 
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
            	throw new RuntimeException("Erro ao fechar o resultSet" + e.getMessage());
            }
        }
    }
}
