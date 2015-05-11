package br.edu.unitri.aula03locacao;

import java.util.List;

import br.edu.unitri.aula03locacao.dao.DepartamentoDAO;
import br.edu.unitri.aula03locacao.dao.FuncionarioDAO;
import br.edu.unitri.aula03locacao.domain.Departamento;
import br.edu.unitri.aula03locacao.domain.Funcionario;

public class FuncionarioTest {
	public static void main(String args[]) {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		DepartamentoDAO departamentoDAO = new DepartamentoDAO();
		Departamento d1 = new Departamento("Comercial", "Comercial");

		departamentoDAO.insereDepartamento(d1);

		Departamento departamento = departamentoDAO
				.consultaDepartamentoPorId(d1.getId());
		
		Funcionario c1 = new Funcionario("Maria", "2345234534", departamento);
		Funcionario c2 = new Funcionario("José", "2345234534", departamento);
		Funcionario c3 = new Funcionario("Antonio", "2345234534", departamento);
		Funcionario c4 = new Funcionario("Joana", "3425234", departamento);

		funcionarioDAO.insereFuncionario(c1);
		funcionarioDAO.insereFuncionario(c2);
		funcionarioDAO.insereFuncionario(c3);
		funcionarioDAO.insereFuncionario(c4);

		List<Funcionario> funcionarios = funcionarioDAO.consultaFuncionario();
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Funcionario Name Inseridos: "
					+ funcionario.getNome() + " = " + "cpf: "
					+ funcionario.getMatricula());
		}

	}
}