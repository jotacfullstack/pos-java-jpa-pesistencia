package br.edu.unitri.aula03livro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.edu.unitri.aula03livro.domain.Livro;
import br.edu.unitri.aula03livro.util.JPAUtil;

public class LivroDAO {
	EntityManager manager = null;

	public LivroDAO() {
		manager = new JPAUtil().getEntityManager();

	}

	public void insereLivro(Livro Livro) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(Livro);
		tx.commit();
	}

	public List<Livro> consultaLivroByJpaQl() {
		TypedQuery<Livro> query = manager.createQuery(
				"Select f from Livro f", Livro.class);
		return query.getResultList();
	}

	public List<Livro> consultaLivroByCriteria() {
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Livro> cq = cb.createQuery(Livro.class);
		return manager.createQuery(cq).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Livro> consultaLivroBySQLNativo() {
		Query q = manager.createNativeQuery("Select * from tb_produto",
				Livro.class);
		return q.getResultList();
	}
}
