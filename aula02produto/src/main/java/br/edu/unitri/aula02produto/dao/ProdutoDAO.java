package br.edu.unitri.aula02produto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.edu.unitri.aula02produto.domain.Produto;
import br.edu.unitri.aula02produto.util.JPAUtil;

public class ProdutoDAO {
	EntityManager manager = null;

	public ProdutoDAO() {
		manager = new JPAUtil().getEntityManager();

	}

	public void insereProduto(Produto Produto) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(Produto);
		tx.commit();
	}

	public List<Produto> consultaProdutoByJpaQl() {
		TypedQuery<Produto> query = manager.createQuery(
				"Select f from Produto f", Produto.class);
		return query.getResultList();
	}

	public List<Produto> consultaProdutoByCriteria() {
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Produto> cq = cb.createQuery(Produto.class);
		return manager.createQuery(cq).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Produto> consultaProdutoBySQLNativo() {
		Query q = manager.createNativeQuery("Select * from tb_produto",
				Produto.class);
		return q.getResultList();
	}
}
