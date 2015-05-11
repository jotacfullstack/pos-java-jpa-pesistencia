package br.com.psi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.psi.domain.Department;
import br.com.psi.domain.Employee;
import br.com.psi.util.JPAUtil;

public class DepartmentDAO {
	EntityManager manager = null;

	public DepartmentDAO() {
		manager = new JPAUtil().getEntityManager();
	}

	public void insertEmployee() {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		try {
			createEmployees();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		listEmployees();

		System.out.println(".. done");
	}

	private void createEmployees() {
		int numOfEmployees = manager
				.createQuery("Select a From Employee a", Employee.class)
				.getResultList().size();
		if (numOfEmployees == 0) {
			Department department = new Department("java");
			manager.persist(department);

			manager.persist(new Employee("Jakab Gipsz", department));
			manager.persist(new Employee("Captain Nemo", department));

		}
	}

	private void listEmployees() {
		List<Employee> resultList = manager.createQuery(
				"Select a From Employee a", Employee.class).getResultList();
		System.out.println("num of employess:" + resultList.size());
		for (Employee next : resultList) {
			System.out.println("next employee: " + next);
		}
	}
}
