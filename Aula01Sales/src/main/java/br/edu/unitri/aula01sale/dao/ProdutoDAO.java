package br.edu.unitri.aula01sale.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.edu.unitri.aula01sale.dao.base.AbstractDAO;
import br.edu.unitri.aula01sale.domain.Produto;

public class ProdutoDAO extends AbstractDAO<Produto, Integer> {

	public ProdutoDAO(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public Produto insert(Produto t) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean remove(Integer i) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean update(Produto t) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Produto getById(Integer i) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public List<Produto> findAll() throws SQLException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
