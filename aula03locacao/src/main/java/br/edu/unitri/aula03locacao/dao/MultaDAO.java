package br.edu.unitri.aula03locacao.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.edu.unitri.aula03locacao.domain.Multa;
import br.edu.unitri.aula03locacao.util.JPAUtil;

public class MultaDAO {
	EntityManager manager = null;

	public MultaDAO() {
		manager = new JPAUtil().getEntityManager();

	}

	public void insereMulta(Multa multa) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(multa);
		tx.commit();
	}

	public void alteraMulta(Multa multa) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.merge(multa);
		tx.commit();
	}

	public void deleteMulta(Multa multa) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.remove(multa);
		tx.commit();
	}
	
	public Multa consultaMultaPorId(Long id) {
		return manager.find(Multa.class, id);
	}

	public List<Multa> consultaMulta() {
		TypedQuery<Multa> query = manager.createQuery(
				"Select f from Multa f", Multa.class);
		return query.getResultList();
	}
}
