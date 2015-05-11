package br.edu.unitri.projectmanager;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.unitri.projectmanager.dao.DepartamentoDAO;
import br.edu.unitri.projectmanager.dao.EmpregadoDAO;
import br.edu.unitri.projectmanager.domain.Departamento;
import br.edu.unitri.projectmanager.domain.Empregado;

public class EmpregadoTest {
	EmpregadoDAO empregadoDAO = null;
	DepartamentoDAO departamentoDAO = null;

	@Before
	public void init() {
		empregadoDAO = new EmpregadoDAO();
		departamentoDAO = new DepartamentoDAO();
	}

	@Test
	public void adicionaEmpregadoEmpregados() {
		Departamento departamento = departamentoDAO
				.consultaDepartamentoPorId(1l);
		EmpregadoDAO empregadoDAO = new EmpregadoDAO();
		Empregado d1 = new Empregado("Comercial", departamento);
		Empregado d2 = new Empregado("Fincanceiro", departamento);
		empregadoDAO.insereEmpregado(d1);
		empregadoDAO.insereEmpregado(d2);
	}

	@Test
	public void listaEmpregados() {
		List<Empregado> empregados = empregadoDAO.consultaEmpregado();
		for (Empregado empregado : empregados) {
			System.out.println("Name Inseridos: " + empregado.getNome()
					+ " = " + "cpf: " + empregado.getNome());
		}
	}

	@Test
	// Exercicio B - Sem Criteria
	public void listaTodasAsInformacoesDosEmpregados() {
		List<Empregado> empregados = empregadoDAO.consultaEmpregado();
		for (Empregado empregado : empregados) {
			System.out.println("Empregado: " + empregado.toString());
		}
	}
	
	@Test
	// Exercicio C - Sem Criteria
	public void listaEmpregadosPorDepartamento() {
		List<Empregado> empregados = empregadoDAO.consultaEmpregadoPorDepartamento("Comercial");
		for (Empregado empregado : empregados) {
			System.out.println("Empregado: " + empregado.toString());
		}
	}

}