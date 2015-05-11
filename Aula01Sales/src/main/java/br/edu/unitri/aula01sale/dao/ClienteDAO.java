package br.edu.unitri.aula01sale.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.edu.unitri.aula01sale.dao.base.AbstractDAO;
import br.edu.unitri.aula01sale.domain.Cliente;

public class ClienteDAO extends AbstractDAO<Cliente, Integer> {

	public ClienteDAO(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public Cliente insert(Cliente cliente) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean remove(Integer id) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean update(Cliente cliente) throws SQLException {
		PreparedStatement statement = null;
		String sql = "Update Cliente set nome = ?,tipo = ?,"
				+ "estado = ? where codpro = ?";
		try {
			statement = conexao.prepareStatement(sql);
			statement.setString(1, cliente.getNome());
			statement.setInt(2, cliente.getTipo());
			statement.setString(3, cliente.getEstado());
			statement.setInt(4, cliente.getCodigo());
			boolean retorno = statement.execute();
			return retorno;
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
				System.err.println("Impossivel fechar comando " + e2);
			}
		}
	}

	@Override
	public Cliente getById(Integer id) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public List<Cliente> findAll() throws SQLException {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
