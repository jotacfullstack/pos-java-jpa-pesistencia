package br.edu.unitri.aula03locacao;

import java.util.List;

import br.edu.unitri.aula03locacao.dao.ClienteDAO;
import br.edu.unitri.aula03locacao.dao.DepartamentoDAO;
import br.edu.unitri.aula03locacao.dao.FuncionarioDAO;
import br.edu.unitri.aula03locacao.dao.LocacaoDAO;
import br.edu.unitri.aula03locacao.dao.VeiculoCategoriaDAO;
import br.edu.unitri.aula03locacao.dao.VeiculoDAO;
import br.edu.unitri.aula03locacao.domain.Cliente;
import br.edu.unitri.aula03locacao.domain.Departamento;
import br.edu.unitri.aula03locacao.domain.Funcionario;
import br.edu.unitri.aula03locacao.domain.Locacao;
import br.edu.unitri.aula03locacao.domain.Veiculo;
import br.edu.unitri.aula03locacao.domain.VeiculoCategoria;

public class LocacaoTest {
	public static void main(String args[]) {
		LocacaoDAO locacaoDAO = new LocacaoDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		VeiculoCategoriaDAO veiculoCategoriaDAO = new VeiculoCategoriaDAO();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		Cliente c1 = new Cliente("fasd", "2345234534");
		clienteDAO.insereCliente(c1);
		Cliente cliente = clienteDAO.consultaClientePorId(c1.getId());

		VeiculoCategoria veiculoCategoria = new VeiculoCategoria(12d, "fsdf");
		veiculoCategoriaDAO.insereVeiculoCategoria(veiculoCategoria);
		veiculoCategoriaDAO.consultaVeiculoCategoriaPorId(veiculoCategoria
				.getId());

		Veiculo v1 = new Veiculo("fiesta", "ford", 434d, veiculoCategoria);
		veiculoDAO.insereVeiculo(v1);
		Veiculo veiculo = veiculoDAO.consultaVeiculoPorId(v1.getId());
		
		DepartamentoDAO departamentoDAO = new DepartamentoDAO();
		Departamento d1 = new Departamento("Comercial", "Comercial");

		departamentoDAO.insereDepartamento(d1);

		Departamento departamento = departamentoDAO
				.consultaDepartamentoPorId(d1.getId());

		Funcionario f1 = new Funcionario("Maria", "2345234534", departamento);
		funcionarioDAO.insereFuncionario(f1);
		Funcionario funcionarioCad = funcionarioDAO.consultaFuncionarioPorId(f1
				.getId());

		Funcionario f2 = new Funcionario("Joao", "2345234534", departamento);
		funcionarioDAO.insereFuncionario(f2);
		Funcionario funcionarioRec = funcionarioDAO.consultaFuncionarioPorId(f2
				.getId());

		Locacao l1 = new Locacao(cliente, veiculo, funcionarioCad,
				funcionarioRec, 120, 120000);
		Locacao l2 = new Locacao(cliente, veiculo, funcionarioCad,
				funcionarioRec, 120, 120000);
		Locacao l3 = new Locacao(cliente, veiculo, funcionarioCad,
				funcionarioRec, 120, 120000);
		Locacao l4 = new Locacao(cliente, veiculo, funcionarioCad,
				funcionarioRec, 120, 120000);

		locacaoDAO.insereLocacao(l1);
		locacaoDAO.insereLocacao(l2);
		locacaoDAO.insereLocacao(l3);
		locacaoDAO.insereLocacao(l4);

		List<Locacao> locacaos = locacaoDAO.consultaLocacao();
		for (Locacao locacao : locacaos) {
			System.out.println("Locacao Name Inseridos: "
					+ locacao.getVeiculo().getDescicao() + " = " + "cpf: "
					+ locacao.getQuantidadeDias());
		}

	}
}
