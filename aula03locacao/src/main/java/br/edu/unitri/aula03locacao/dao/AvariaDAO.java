package br.edu.unitri.aula03locacao.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.edu.unitri.aula03locacao.domain.Avaria;
import br.edu.unitri.aula03locacao.util.JPAUtil;

public class AvariaDAO {
	EntityManager manager = null;

	public AvariaDAO() {
		manager = new JPAUtil().getEntityManager();

	}

	public void insereAvaria(Avaria avaria) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(avaria);
		tx.commit();
	}

	public void alteraAvaria(Avaria avaria) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.merge(avaria);
		tx.commit();
	}

	public void deleteAvaria(Avaria avaria) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.remove(avaria);
		tx.commit();
	}
	
	public Avaria consultaAvariaPorId(Long id) {
		return manager.find(Avaria.class, id);
	}

	public List<Avaria> consultaAvaria() {
		TypedQuery<Avaria> query = manager.createQuery(
				"Select f from Avaria f", Avaria.class);
		return query.getResultList();
	}
}
