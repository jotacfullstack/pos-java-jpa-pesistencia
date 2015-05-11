package br.edu.unitri.aula03livro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.edu.unitri.aula03livro.domain.Autor;
import br.edu.unitri.aula03livro.util.JPAUtil;

public class AutorDAO {
	EntityManager manager = null;

	public AutorDAO() {
		manager = new JPAUtil().getEntityManager();

	}

	public void insereAutor(Autor autor) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(autor);
		tx.commit();
	}

	public Autor buscaPorId(Long id) {
		return manager.find(Autor.class, id);
	}
	
	public List<Autor> consultaFornedorByJpaQl() {
		TypedQuery<Autor> query = manager.createQuery(
				"Select f from Autor f", Autor.class);
		return query.getResultList();
	}

	public List<Autor> consultaFornedorByCriteria() {
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Autor> cq = cb.createQuery(Autor.class);
		return manager.createQuery(cq).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Autor> consultaFornedorBySQLNativo() {
		Query q = manager.createNativeQuery("Select * from tb_autor",
				Autor.class);
		return q.getResultList();
	}
}
