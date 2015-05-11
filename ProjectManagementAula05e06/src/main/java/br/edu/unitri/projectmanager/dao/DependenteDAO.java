package br.edu.unitri.projectmanager.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.edu.unitri.projectmanager.domain.Dependente;
import br.edu.unitri.projectmanager.domain.Empregado;
import br.edu.unitri.projectmanager.util.JPAUtil;

public class DependenteDAO {
	EntityManager manager = null;

	public DependenteDAO() {
		manager = new JPAUtil().getEntityManager();

	}

	public void insereDependente(Dependente dependente) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(dependente);
		tx.commit();
	}

	public void alteraDependente(Dependente dependente) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.merge(dependente);
		tx.commit();
	}

	public void deleteDependente(Dependente dependente) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.remove(dependente);
		tx.commit();
	}

	public Dependente consultaDependentePorId(Long id) {
		return manager.find(Dependente.class, id);
	}

	public List<Dependente> consultaDependente() {
		TypedQuery<Dependente> query = manager.createQuery(
				"Select f from Dependente f", Dependente.class);
		return query.getResultList();
	}

	public List<Dependente> consultaDependentePorEmpregado(String empregado) {
		TypedQuery<Dependente> query = manager
				.createQuery(
						"Select f from Dependente f where f.empregado.nome =:empregado ",
						Dependente.class);
		query.setParameter("empregado", empregado);
		return query.getResultList();
	}
}
