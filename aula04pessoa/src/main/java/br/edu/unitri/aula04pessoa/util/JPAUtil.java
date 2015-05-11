package br.edu.unitri.aula04pessoa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("persistencePU");

	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

}
