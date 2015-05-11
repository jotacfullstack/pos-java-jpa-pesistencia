package br.edu.unitri.aula04pessoa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.edu.unitri.aula04pessoa.domain.PessoaJuridica;
import br.edu.unitri.aula04pessoa.util.JPAUtil;

public class PessoaJuridicaDAO {
	EntityManager manager = null;

	public PessoaJuridicaDAO() {
		manager = new JPAUtil().getEntityManager();

	}

	public void inserePessoaJuridica(PessoaJuridica PessoaJuridica) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(PessoaJuridica);
		tx.commit();
	}

	public PessoaJuridica findById(Long id) {
		return manager.find(PessoaJuridica.class, id);
	}

	public List<PessoaJuridica> consultaPessoaJuridicaByJpaQl() {
		TypedQuery<PessoaJuridica> query = manager.createQuery(
				"Select f from PessoaJuridica f", PessoaJuridica.class);
		return query.getResultList();
	}

	public List<PessoaJuridica> consultaPessoaJuridicaByCriteria() {
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<PessoaJuridica> cq = cb.createQuery(PessoaJuridica.class);
		return manager.createQuery(cq).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PessoaJuridica> consultaPessoaJuridicaBySQLNativo() {
		Query q = manager.createNativeQuery("Select * from tb_produto",
				PessoaJuridica.class);
		return q.getResultList();
	}
}
