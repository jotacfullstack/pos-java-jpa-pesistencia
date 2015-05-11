package br.edu.unitri.aula01jdbc.persistencia.factory;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;

import org.junit.Test;

import br.edu.unitri.aula01jdbc.persistencia.factory.ConnectionFactory;
import br.edu.unitri.aula01jdbc.persistencia.util.db.DbUtil;

public class ConnectionTest {

	@Test
	public void connectionTest() {
		Connection conn = null;

		try {
			conn = ConnectionFactory.getConnection();
			assertTrue(conn != null);
		} catch (Exception e) {
			System.err.println("connection erro:" + e.getMessage());
		} finally {
			DbUtil.close(conn);
		}

	}

}
