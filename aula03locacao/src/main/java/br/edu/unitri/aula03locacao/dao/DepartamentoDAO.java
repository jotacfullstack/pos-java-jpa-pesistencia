package br.edu.unitri.aula03locacao.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.edu.unitri.aula03locacao.domain.Departamento;
import br.edu.unitri.aula03locacao.util.JPAUtil;

public class DepartamentoDAO {
	EntityManager manager = null;

	public DepartamentoDAO() {
		manager = new JPAUtil().getEntityManager();

	}

	public void insereDepartamento(Departamento departamento) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(departamento);
		tx.commit();
	}

	public void alteraDepartamento(Departamento departamento) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.merge(departamento);
		tx.commit();
	}

	public void deleteDepartamento(Departamento departamento) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.remove(departamento);
		tx.commit();
	}
	
	public Departamento consultaDepartamentoPorId(Long id) {
		return manager.find(Departamento.class, id);
	}

	public List<Departamento> consultaDepartamento() {
		TypedQuery<Departamento> query = manager.createQuery(
				"Select f from Departamento f", Departamento.class);
		return query.getResultList();
	}
}
