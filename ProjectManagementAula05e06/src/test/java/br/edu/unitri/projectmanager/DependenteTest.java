package br.edu.unitri.projectmanager;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.unitri.projectmanager.dao.EmpregadoDAO;
import br.edu.unitri.projectmanager.dao.DependenteDAO;
import br.edu.unitri.projectmanager.domain.Empregado;
import br.edu.unitri.projectmanager.domain.Dependente;

public class DependenteTest {
	DependenteDAO dependenteDAO = null;
	EmpregadoDAO empregadoDAO = null;

	@Before
	public void init() {
		dependenteDAO = new DependenteDAO();
		empregadoDAO = new EmpregadoDAO();
	}

	@Test
	public void adicionaDependenteDependentes() {
		Empregado empregado = empregadoDAO.consultaEmpregadoPorId(1l);
		DependenteDAO dependenteDAO = new DependenteDAO();
		Dependente d1 = new Dependente("Comercial", empregado);
		Dependente d2 = new Dependente("Fincanceiro", empregado);
		dependenteDAO.insereDependente(d1);
		dependenteDAO.insereDependente(d2);
	}

	@Test
	public void listaDependentes() {
		List<Dependente> dependentes = dependenteDAO.consultaDependente();
		for (Dependente dependente : dependentes) {
			System.out.println("Avaria Name Inseridos: " + dependente.getNome()
					+ " = " + "cpf: " + dependente.getNome());
		}
	}

	@Test
	// Exercicio D - Sem Criteria
	public void listaDependentesDeUmEmpregado() {
		List<Dependente> dependentes = dependenteDAO.consultaDependentePorEmpregado("Joao");
		for (Dependente dependente : dependentes) {
			System.out.println("Avaria Name Inseridos: " + dependente.getNome()
					+ " = " + "cpf: " + dependente.getNome());
		}
	}

}