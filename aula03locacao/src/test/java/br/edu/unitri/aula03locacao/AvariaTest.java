package br.edu.unitri.aula03locacao;

import java.util.List;

import br.edu.unitri.aula03locacao.dao.AvariaDAO;
import br.edu.unitri.aula03locacao.dao.ClienteDAO;
import br.edu.unitri.aula03locacao.dao.DepartamentoDAO;
import br.edu.unitri.aula03locacao.dao.FuncionarioDAO;
import br.edu.unitri.aula03locacao.dao.LocacaoDAO;
import br.edu.unitri.aula03locacao.dao.VeiculoCategoriaDAO;
import br.edu.unitri.aula03locacao.dao.VeiculoDAO;
import br.edu.unitri.aula03locacao.domain.Avaria;
import br.edu.unitri.aula03locacao.domain.Cliente;
import br.edu.unitri.aula03locacao.domain.Departamento;
import br.edu.unitri.aula03locacao.domain.Funcionario;
import br.edu.unitri.aula03locacao.domain.Locacao;
import br.edu.unitri.aula03locacao.domain.Veiculo;
import br.edu.unitri.aula03locacao.domain.VeiculoCategoria;

public class AvariaTest {
	public static void main(String args[]) {
		LocacaoDAO locacaoDAO = new LocacaoDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		VeiculoCategoriaDAO veiculoCategoriaDAO = new VeiculoCategoriaDAO();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		AvariaDAO avariaDAO = new AvariaDAO();
	
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

		Avaria a1 = new Avaria(12d, "batida", locacao);
		Avaria a2 = new Avaria(32d, "raspada", locacao);
		Avaria a3 = new Avaria(323d, "quebra", locacao);
		Avaria a4 = new Avaria(3d, "das", locacao);

		avariaDAO.insereAvaria(a1);
		avariaDAO.insereAvaria(a2);
		avariaDAO.insereAvaria(a3);
		avariaDAO.insereAvaria(a4);

		List<Avaria> avarias = avariaDAO.consultaAvaria();
		for (Avaria avaria : avarias) {
			System.out.println("Avaria Name Inseridos: " + avaria.getDescicao()
					+ " = " + "cpf: " + avaria.getValor());
		}
	}
}
