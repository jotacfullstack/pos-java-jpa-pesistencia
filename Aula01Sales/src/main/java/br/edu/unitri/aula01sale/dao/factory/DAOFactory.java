package br.edu.unitri.aula01sale.dao.factory;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.unitri.aula01sale.dao.ClienteDAO;
import br.edu.unitri.aula01sale.dao.ProdutoDAO;
import br.edu.unitri.aula01sale.dao.base.DAO;
import br.edu.unitri.aula01sale.domain.Cliente;
import br.edu.unitri.aula01sale.domain.Produto;

public class DAOFactory {
	
	public static DAO<Cliente, Integer> getClienteDAO(Connection conexao)
			throws SQLException {
		return new ClienteDAO(conexao);
	}

	public static DAO<Produto, Integer> getProdutoDAO(Connection conexao)
			throws SQLException {
		return new ProdutoDAO(conexao);
	}
}
