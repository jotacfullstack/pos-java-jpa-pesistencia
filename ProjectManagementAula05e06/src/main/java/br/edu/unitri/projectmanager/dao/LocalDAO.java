package br.edu.unitri.projectmanager.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.edu.unitri.projectmanager.domain.Local;
import br.edu.unitri.projectmanager.util.JPAUtil;

public class LocalDAO {
	EntityManager manager = null;

	public LocalDAO() {
		manager = new JPAUtil().getEntityManager();

	}

	public void insereLocal(Local local) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(local);
		tx.commit();
	}

	public void alteraLocal(Local local) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.merge(local);
		tx.commit();
	}

	public void deleteLocal(Local local) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.remove(local);
		tx.commit();
	}
	
	public Local consultaLocalPorId(Long id) {
		return manager.find(Local.class, id);
	}

	public List<Local> consultaLocal() {
		TypedQuery<Local> query = manager.createQuery(
				"Select f from Local f", Local.class);
		return query.getResultList();
	}
}
