package br.edu.unitri.aula03locacao;

import java.util.List;

import br.edu.unitri.aula03locacao.dao.ClienteDAO;
import br.edu.unitri.aula03locacao.dao.DepartamentoDAO;
import br.edu.unitri.aula03locacao.dao.FuncionarioDAO;
import br.edu.unitri.aula03locacao.dao.LocacaoDAO;
import br.edu.unitri.aula03locacao.dao.MultaDAO;
import br.edu.unitri.aula03locacao.dao.VeiculoCategoriaDAO;
import br.edu.unitri.aula03locacao.dao.VeiculoDAO;
import br.edu.unitri.aula03locacao.domain.Cliente;
import br.edu.unitri.aula03locacao.domain.Departamento;
import br.edu.unitri.aula03locacao.domain.Funcionario;
import br.edu.unitri.aula03locacao.domain.Locacao;
import br.edu.unitri.aula03locacao.domain.Multa;
import br.edu.unitri.aula03locacao.domain.Veiculo;
import br.edu.unitri.aula03locacao.domain.VeiculoCategoria;

public class MultaTest {
	public static void main(String args[]) {
		LocacaoDAO locacaoDAO = new LocacaoDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		VeiculoCategoriaDAO veiculoCategoriaDAO = new VeiculoCategoriaDAO();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		MultaDAO multaDAO = new MultaDAO();

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
		locacaoDAO.insereLocacao(l1);
		Locacao locacao = locacaoDAO.consultaLocacaoPorId(l1.getId());

		Multa m1 = new Multa(12d, "batida", locacao);
		Multa m2 = new Multa(32d, "raspada", locacao);
		Multa m3 = new Multa(323d, "quebra", locacao);
		Multa m4 = new Multa(3d, "das", locacao);

		multaDAO.insereMulta(m1);
		multaDAO.insereMulta(m2);
		multaDAO.insereMulta(m3);
		multaDAO.insereMulta(m4);

		List<Multa> multas = multaDAO.consultaMulta();
		for (Multa multa : multas) {
			System.out.println("Multa Name Inseridos: " + multa.getDescicao()
					+ " = " + "cpf: " + multa.getValor());
		}
	}
}
