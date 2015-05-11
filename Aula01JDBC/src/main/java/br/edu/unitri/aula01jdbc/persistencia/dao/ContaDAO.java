package br.edu.unitri.aula01jdbc.persistencia.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.unitri.aula01jdbc.persistencia.factory.ConnectionFactory;
import br.edu.unitri.aula01jdbc.persistencia.model.Conta;
import br.edu.unitri.aula01jdbc.persistencia.util.db.DbUtil;

public class ContaDAO {
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private CallableStatement callableStatement = null;

	public ContaDAO() {
	}

	public List<Conta> getContas() {
		String query = "SELECT * FROM conta";
		ResultSet rs = null;
		Conta conta = null;
		List<Conta> contas = new ArrayList<Conta>();

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);

			while (rs.next()) {
				conta = new Conta();
				conta.setNome(rs.getString("nome"));
				conta.setAgencia(rs.getInt("agencia"));
				conta.setSenha(rs.getInt("senha"));
				contas.add(conta);
			}

		} catch (SQLException ex) {
			throw new RuntimeException("Error: " + ex.getMessage());
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return contas;
	}

	public List<Conta> getAccountByAgency(int agency) {
		String query = "{CALL getAccountByAgency(?)}";
		ResultSet rs = null;
		Conta conta = null;
		List<Conta> contas = new ArrayList<Conta>();

		try {
			connection = ConnectionFactory.getConnection();
			callableStatement = connection.prepareCall(query);
			rs = statement.executeQuery(query);
			
			callableStatement.setInt(1, agency);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(4, java.sql.Types.DATE);
			 
			// execute getDBUSERByUserId store procedure
			callableStatement.executeUpdate();
			 
			String userName = callableStatement.getString(2);
			String createdBy = callableStatement.getString(3);
			Date createdDate = callableStatement.getDate(4);

			while (rs.next()) {
				conta = new Conta();
				conta.setNome(rs.getString("nome"));
				conta.setAgencia(rs.getInt("agencia"));
				conta.setSenha(rs.getInt("senha"));
				contas.add(conta);
			}

		} catch (SQLException ex) {
			throw new RuntimeException("Error: " + ex.getMessage());
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return contas;
	}

	public boolean insertConta(Conta conta) {
		boolean inserted;

		String sql = "insert into conta (nome, agencia, senha) values (?, ?, ?)";

		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, conta.getNome());
			preparedStatement.setInt(2, conta.getAgencia());
			preparedStatement.setInt(3, conta.getSenha());

			int result = preparedStatement.executeUpdate();

			connection.commit();

			if (result == 1)
				inserted = true;
			else
				inserted = false;

		} catch (SQLException ex) {
			throw new RuntimeException("Error: " + ex.getMessage());
		} finally {
			DbUtil.close(preparedStatement);
			DbUtil.close(connection);
		}
		return inserted;
	}

	public boolean insertContaByBatch(List<Conta> contas) {
		boolean inserted;

		String sql = "insert into conta (nome, agencia, senha) values (?, ?, ?)";

		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			for (Conta conta : contas) {
				preparedStatement.setString(1, conta.getNome());
				preparedStatement.setInt(2, conta.getAgencia());
				preparedStatement.setInt(3, conta.getSenha());
				preparedStatement.addBatch();
			}

			preparedStatement.executeBatch();

			connection.commit();

			inserted = true;

		} catch (SQLException ex) {
			throw new RuntimeException("Error: " + ex.getMessage());
		} finally {
			DbUtil.close(preparedStatement);
			DbUtil.close(connection);
		}
		return inserted;
	}

	public boolean deleteContas() {
		boolean inserted;

		String sql = "delete from conta where id > 1";

		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			int result = preparedStatement.executeUpdate();

			connection.commit();

			if (result == 1)
				inserted = true;
			else
				inserted = false;

		} catch (SQLException ex) {
			throw new RuntimeException("Error: " + ex.getMessage());
		} finally {
			DbUtil.close(preparedStatement);
			DbUtil.close(connection);
		}
		return inserted;
	}
}
