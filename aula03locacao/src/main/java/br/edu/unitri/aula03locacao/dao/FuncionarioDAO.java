package br.edu.unitri.aula03locacao.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.edu.unitri.aula03locacao.domain.Funcionario;
import br.edu.unitri.aula03locacao.util.JPAUtil;

public class FuncionarioDAO {
	EntityManager manager = null;

	public FuncionarioDAO() {
		manager = new JPAUtil().getEntityManager();

	}

	public void insereFuncionario(Funcionario funcionario) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(funcionario);
		tx.commit();
	}

	public void alteraFuncionario(Funcionario funcionario) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.merge(funcionario);
		tx.commit();
	}

	public void deleteFuncionario(Funcionario funcionario) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.remove(funcionario);
		tx.commit();
	}

	public Funcionario consultaFuncionarioPorId(Long id) {
		return manager.find(Funcionario.class, id);
	}
	
	public List<Funcionario> consultaFuncionario() {
		TypedQuery<Funcionario> query = manager.createQuery(
				"Select f from Funcionario f", Funcionario.class);
		return query.getResultList();
	}
}
