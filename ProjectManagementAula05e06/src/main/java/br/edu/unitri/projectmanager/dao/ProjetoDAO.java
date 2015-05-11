package br.edu.unitri.projectmanager.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.edu.unitri.projectmanager.domain.Projeto;
import br.edu.unitri.projectmanager.util.JPAUtil;

public class ProjetoDAO {
	EntityManager manager = null;

	public ProjetoDAO() {
		manager = new JPAUtil().getEntityManager();
	}

	public void insereProjeto(Projeto projeto) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(projeto);
		tx.commit();
	}

	public void alteraProjeto(Projeto projeto) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.merge(projeto);
		tx.commit();
	}

	public void deleteProjeto(Projeto projeto) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.remove(projeto);
		tx.commit();
	}
	
	public Projeto consultaProjetoPorId(Long id) {
		return manager.find(Projeto.class, id);
	}

	public List<Projeto> consultaProjeto() {
		TypedQuery<Projeto> query = manager.createQuery(
				"Select f from Projeto f", Projeto.class);
		return query.getResultList();
	}
}
