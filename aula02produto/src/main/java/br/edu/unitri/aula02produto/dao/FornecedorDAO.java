package br.edu.unitri.aula02produto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.edu.unitri.aula02produto.domain.Fornecedor;
import br.edu.unitri.aula02produto.util.JPAUtil;

public class FornecedorDAO {
	EntityManager manager = null;

	public FornecedorDAO() {
		manager = new JPAUtil().getEntityManager();

	}

	public void insereFornecedor(Fornecedor fornecedor) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(fornecedor);
		tx.commit();
	}

	public List<Fornecedor> consultaFornedorByJpaQl() {
		TypedQuery<Fornecedor> query = manager.createQuery(
				"Select f from Fornecedor f", Fornecedor.class);
		return query.getResultList();
	}

	public List<Fornecedor> consultaFornedorByCriteria() {
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Fornecedor> cq = cb.createQuery(Fornecedor.class);
		return manager.createQuery(cq).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Fornecedor> consultaFornedorBySQLNativo() {
		Query q = manager.createNativeQuery("Select * from tb_fornecedor",
				Fornecedor.class);
		return q.getResultList();
	}
}
