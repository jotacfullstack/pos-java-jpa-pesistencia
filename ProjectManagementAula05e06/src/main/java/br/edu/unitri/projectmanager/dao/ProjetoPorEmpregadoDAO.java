package br.edu.unitri.projectmanager.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.edu.unitri.projectmanager.domain.ProjetoPorEmpregado;
import br.edu.unitri.projectmanager.util.JPAUtil;

public class ProjetoPorEmpregadoDAO {
	EntityManager manager = null;

	public ProjetoPorEmpregadoDAO() {
		manager = new JPAUtil().getEntityManager();

	}

	public void insereProjetoPorEmpregado(ProjetoPorEmpregado projetoPorEmpregado) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(projetoPorEmpregado);
		tx.commit();
	}

	public void alteraProjetoPorEmpregado(ProjetoPorEmpregado projetoPorEmpregado) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.merge(projetoPorEmpregado);
		tx.commit();
	}

	public void deleteProjetoPorEmpregado(ProjetoPorEmpregado projetoPorEmpregado) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.remove(projetoPorEmpregado);
		tx.commit();
	}
	
	public ProjetoPorEmpregado consultaProjetoPorEmpregadoPorId(Long id) {
		return manager.find(ProjetoPorEmpregado.class, id);
	}

	public List<ProjetoPorEmpregado> consultaProjetoPorEmpregado() {
		TypedQuery<ProjetoPorEmpregado> query = manager.createQuery(
				"Select f from ProjetoPorEmpregado f", ProjetoPorEmpregado.class);
		return query.getResultList();
	}
}
