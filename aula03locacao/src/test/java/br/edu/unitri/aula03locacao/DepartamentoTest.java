package br.edu.unitri.aula03locacao;

import java.util.List;

import br.edu.unitri.aula03locacao.dao.DepartamentoDAO;
import br.edu.unitri.aula03locacao.domain.Departamento;

public class DepartamentoTest {
	public static void main(String args[]) {
		DepartamentoDAO departamentoDAO = new DepartamentoDAO();

		Departamento d1 = new Departamento("Comercial",
				"Comercial");

		Departamento d2 = new Departamento("Fincanceiro",
				"Fincanceido");

		departamentoDAO.insereDepartamento(d1);
		departamentoDAO.insereDepartamento(d2);

		List<Departamento> departamentos = departamentoDAO.consultaDepartamento();
		for (Departamento departamento : departamentos) {
			System.out.println("Avaria Name Inseridos: " + departamento.getNome()
					+ " = " + "cpf: " + departamento.getDescricao());
		}
	}
}
