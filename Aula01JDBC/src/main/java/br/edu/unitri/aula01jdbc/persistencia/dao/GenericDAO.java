package br.edu.unitri.aula01jdbc.persistencia.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.unitri.aula01jdbc.persistencia.factory.ConnectionFactory;
import br.edu.unitri.aula01jdbc.persistencia.util.db.DbUtil;

public class GenericDAO {
	private Connection connection = null;

	public String getDiscribeAccount() {

		String discribeAccount = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			DatabaseMetaData meta = connection.getMetaData();
			ResultSet res = meta.getColumns(null, null, "conta", null);
			System.out.println("List of columns: ");

			while (res.next()) {
				discribeAccount += "  " + res.getString("TABLE_SCHEM") + ", "
						+ res.getString("TABLE_NAME") + ", "
						+ res.getString("COLUMN_NAME") + ", "
						+ res.getString("TYPE_NAME") + ", "
						+ res.getInt("COLUMN_SIZE") + ", "
						+ res.getString("NULLABLE");
			}
			
			res.close();

			DbUtil.close(connection);
		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
		}
		return discribeAccount;
	}

}
