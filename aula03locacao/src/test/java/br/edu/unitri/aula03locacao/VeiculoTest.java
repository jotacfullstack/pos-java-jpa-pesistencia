package br.edu.unitri.aula03locacao;

import java.util.List;

import br.edu.unitri.aula03locacao.dao.VeiculoCategoriaDAO;
import br.edu.unitri.aula03locacao.dao.VeiculoDAO;
import br.edu.unitri.aula03locacao.domain.Veiculo;
import br.edu.unitri.aula03locacao.domain.VeiculoCategoria;

public class VeiculoTest {
	public static void main(String args[]) {
		VeiculoCategoriaDAO veiculoCategoriaDAO = new VeiculoCategoriaDAO();
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		
		VeiculoCategoria vc1 = new VeiculoCategoria(12d,
				"utilitario");

		veiculoCategoriaDAO.insereVeiculoCategoria(vc1);
		VeiculoCategoria veiculoCategoria = veiculoCategoriaDAO.consultaVeiculoCategoriaPorId(vc1.getId());
		
		Veiculo v1 = new Veiculo("Fiesta", "Ford", 12d, veiculoCategoria);
		Veiculo v2 = new Veiculo("Focus", "Ford", 11d, veiculoCategoria);
		Veiculo v3 = new Veiculo("ka", "Ford", 14d, veiculoCategoria);
	
		veiculoDAO.insereVeiculo(v1);
		veiculoDAO.insereVeiculo(v2);
		veiculoDAO.insereVeiculo(v3);
		
		List<Veiculo> veiculos = veiculoDAO.consultaVeiculo();
		for (Veiculo veiculo : veiculos) {
			System.out.println("Avaria Name Inseridos: " + veiculo.getDescicao()
					+ " = " + "cpf: " + veiculo.getFatorPreco());
		}
	}
}
