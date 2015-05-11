import static org.junit.Assert.assertTrue;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

import br.edu.unitri.aula01sale.connection.ConnectionFactory;
import br.edu.unitri.aula01sale.dao.base.DAO;
import br.edu.unitri.aula01sale.dao.factory.DAOFactory;
import br.edu.unitri.aula01sale.domain.Cliente;

public class ClienteDAOTest {

	@Test
	public void insertCliente() {
		Connection conexao = null;
		Cliente clienteSalvo = null;
		try {
			conexao = ConnectionFactory.getConnection();
			DAO<Cliente, Integer> clienteDAO = DAOFactory
					.getClienteDAO(conexao);
			Cliente clienteNovo = new Cliente(10, "Fulano de Tal", 2, "MG");
			clienteSalvo = clienteDAO.insert(clienteNovo);
			conexao.commit();
		} catch (Exception e) {
			System.err.println(e);
			try {
				if (conexao != null)
					conexao.rollback();
			} catch (Exception ex) {
			}
			Assert.fail("não consegui inserir Cliente");
		} finally {
			ConnectionFactory.closeConnection(conexao, null, null);
		}
		assertTrue(clienteSalvo != null);
	}

}
