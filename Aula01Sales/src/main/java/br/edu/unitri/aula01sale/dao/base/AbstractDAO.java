package br.edu.unitri.aula01sale.dao.base;

import java.sql.Connection;

public abstract class AbstractDAO<T, I> implements DAO<T, I> {
	
	protected Connection conexao;

	public Connection getConexao() {
		return conexao;
	}
}
