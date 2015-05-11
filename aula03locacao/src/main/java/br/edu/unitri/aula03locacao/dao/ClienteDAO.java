package br.edu.unitri.aula03locacao.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.edu.unitri.aula03locacao.domain.Cliente;
import br.edu.unitri.aula03locacao.util.JPAUtil;

public class ClienteDAO {
	EntityManager manager = null;

	public ClienteDAO() {
		manager = new JPAUtil().getEntityManager();
	}

	public void insereCliente(Cliente cliente) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(cliente);
		tx.commit();
	}

	public void alteraCliente(Cliente cliente) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.merge(cliente);
		tx.commit();
	}

	public void deleteCliente(Cliente cliente) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.remove(cliente);
		tx.commit();
	}

	public Cliente consultaClientePorId(Long id) {
		return manager.find(Cliente.class, id);
	}

	public Cliente consultaClientePorNome(String nome) {
		TypedQuery<Cliente> query = manager.createQuery(
				"Select f from Cliente f where f.nome = :nome", Cliente.class);
		query.setParameter("nome", nome);
		return query.getSingleResult();
	}

	public List<Cliente> consultaCliente() {
		TypedQuery<Cliente> query = manager.createQuery(
				"Select f from Cliente f", Cliente.class);
		return query.getResultList();
	}
}
