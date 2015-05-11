package br.edu.unitri.aula06livro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import br.edu.unitri.aula06livro.domain.Autor;
import br.edu.unitri.aula06livro.util.JPAUtil;

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
		TypedQuery<Autor> query = manager.createQuery("Select f from Autor f",
				Autor.class);
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

	public List<Autor> getLivrosDeAutoresComFetchJoin() {
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Autor> qAutor = cb.createQuery(Autor.class);
		Root<Autor> root = qAutor.from(Autor.class);
		root.fetch("livros", JoinType.LEFT);
		qAutor.select(root).distinct(true);
		return manager.createQuery(qAutor).getResultList();
	}

	public List<Autor> getLivrosDeAutores() {
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Autor> qAutor = cb.createQuery(Autor.class);
		Root<Autor> root = qAutor.from(Autor.class);
		qAutor.select(root);
		return manager.createQuery(qAutor).getResultList();
	}

}
