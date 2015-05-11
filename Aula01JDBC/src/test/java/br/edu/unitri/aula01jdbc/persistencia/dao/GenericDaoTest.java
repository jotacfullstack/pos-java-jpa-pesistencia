package br.edu.unitri.aula01jdbc.persistencia.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GenericDaoTest {
	GenericDAO genericDAO = null;

	@Before
	public void getDaoInstance() {
		genericDAO = new GenericDAO();
	}
	
	@Test
	public void shouldDiscribeAccountTable() {
		String result = genericDAO.getDiscribeAccount();
		System.out.println(result);
		assertTrue(result!=null);
	}
}
