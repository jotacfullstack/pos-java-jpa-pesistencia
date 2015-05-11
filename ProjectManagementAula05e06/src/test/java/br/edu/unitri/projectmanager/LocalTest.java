package br.edu.unitri.projectmanager;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.unitri.projectmanager.dao.DepartamentoDAO;
import br.edu.unitri.projectmanager.dao.LocalDAO;
import br.edu.unitri.projectmanager.domain.Local;

public class LocalTest {
	LocalDAO localDAO = null;
	DepartamentoDAO departamentoDAO = null;

	@Before
	public void init() {
		localDAO = new LocalDAO();
	}

	@Test
	public void adicionaLocalLocals() {
		LocalDAO localDAO = new LocalDAO();
		Local d1 = new Local("local1");
		Local d2 = new Local("local2");
		localDAO.insereLocal(d1);
		localDAO.insereLocal(d2);
	}

	@Test
	public void listaLocals() {
		List<Local> locals = localDAO.consultaLocal();
		for (Local local : locals) {
			System.out
					.println("Avaria Name Inseridos: " + local.getDescricao());
		}
	}

}