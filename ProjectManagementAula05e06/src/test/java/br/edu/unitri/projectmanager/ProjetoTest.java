package br.edu.unitri.projectmanager;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.unitri.projectmanager.dao.ProjetoDAO;
import br.edu.unitri.projectmanager.domain.Projeto;

public class ProjetoTest {
	ProjetoDAO projetoDAO = null;

	@Before
	public void init() {
		projetoDAO = new ProjetoDAO();
	}

	@Test
	public void adicionaProjetoProjetos() {
		ProjetoDAO projetoDAO = new ProjetoDAO();
		Projeto d1 = new Projeto("projeto1", "projejjs,");
		Projeto d2 = new Projeto("projeto2", "kskssls");
		projetoDAO.insereProjeto(d1);
		projetoDAO.insereProjeto(d2);
	}

	@Test
	public void listaProjetos() {
		List<Projeto> projetos = projetoDAO.consultaProjeto();
		for (Projeto projeto : projetos) {
			System.out.println("Avaria Name Inseridos: "
					+ projeto.getDescricao());
		}
	}

}