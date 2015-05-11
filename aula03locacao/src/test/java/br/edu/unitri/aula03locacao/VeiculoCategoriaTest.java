package br.edu.unitri.aula03locacao;

import java.util.List;

import br.edu.unitri.aula03locacao.dao.VeiculoCategoriaDAO;
import br.edu.unitri.aula03locacao.domain.VeiculoCategoria;

public class VeiculoCategoriaTest {
	public static void main(String args[]) {
		VeiculoCategoriaDAO veiculoCategoriaDAO = new VeiculoCategoriaDAO();

		VeiculoCategoria veiculoCategoria = new VeiculoCategoria(12d,
				"Comercial");

		VeiculoCategoria veiculoCategoria1 = new VeiculoCategoria(12d,
				"utilitario");

		veiculoCategoriaDAO.insereVeiculoCategoria(veiculoCategoria);
		veiculoCategoriaDAO.insereVeiculoCategoria(veiculoCategoria1);

		List<VeiculoCategoria> categorias = veiculoCategoriaDAO.consultaVeiculoCategoria();
		for (VeiculoCategoria categoria : categorias) {
			System.out.println("Avaria Name Inseridos: " + categoria.getDescricao()
					+ " = " + "cpf: " + categoria.getPrecoBase());
		}
	}
}
