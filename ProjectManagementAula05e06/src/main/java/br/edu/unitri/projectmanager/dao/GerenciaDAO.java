package br.edu.unitri.projectmanager.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.edu.unitri.projectmanager.domain.Gerencia;
import br.edu.unitri.projectmanager.util.JPAUtil;

public class GerenciaDAO {
	EntityManager manager = null;

	public GerenciaDAO() {
		manager = new JPAUtil().getEntityManager();

	}

	public void insereGerencia(Gerencia gerencia) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(gerencia);
		tx.commit();
	}

	public void alteraGerencia(Gerencia gerencia) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.merge(gerencia);
		tx.commit();
	}

	public void deleteGerencia(Gerencia gerencia) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.remove(gerencia);
		tx.commit();
	}
	
	public Gerencia consultaGerenciaPorId(Long id) {
		return manager.find(Gerencia.class, id);
	}

	public List<Gerencia> consultaGerencia() {
		TypedQuery<Gerencia> query = manager.createQuery(
				"Select f from Gerencia f", Gerencia.class);
		return query.getResultList();
	}
}
