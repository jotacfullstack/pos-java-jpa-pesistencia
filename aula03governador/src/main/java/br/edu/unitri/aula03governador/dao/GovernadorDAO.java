package br.edu.unitri.aula03governador.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.edu.unitri.aula03governador.domain.Governador;
import br.edu.unitri.aula03governador.util.JPAUtil;

public class GovernadorDAO {
	EntityManager manager = null;

	public GovernadorDAO() {
		manager = new JPAUtil().getEntityManager();
	}

	public void insereGovernador(Governador Governador) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(Governador);
		tx.commit();
	}

	public Governador buscaPorId(Long id) {
		return manager.find(Governador.class, id);
	}

	public List<Governador> consultaGovernador() {
		TypedQuery<Governador> query = manager.createQuery(
				"Select f from Governador f", Governador.class);
		return query.getResultList();
	}
}
