package br.edu.unitri.aula04pessoa;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.unitri.aula05fornecedor.dao.FornecedorDAO;
import br.edu.unitri.aula05fornecedor.domain.Fornecedor;

public class GerenciarFornecedoresTest {
	FornecedorDAO fornecedorDAO = null;

	@Before
	public void init() {
		fornecedorDAO = new FornecedorDAO();
	}

	@Test
	public void findFornecedorByJpaQl() {
		List<Fornecedor> fornecedores = fornecedorDAO
				.consultaFornedorByCriteria();
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println("Forncedor nome: " + fornecedor.getNome());
		}
	}

	@Test
	public void findFornecedorByCriteria() {
		List<Fornecedor> fornecedores = fornecedorDAO
				.consultaFornedorByCriteria();
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println("Forncedor nome: " + fornecedor.getNome());
		}
	}

	@Test
	public void findFornecedorBySQLNativo() {
		List<Fornecedor> fornecedores = fornecedorDAO
				.consultaFornedorBySQLNativo();
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println("Forncedor nome: " + fornecedor.getNome());
		}
	}

	@Test
	public void findJpaQl_Par() {
		List<Fornecedor> fornecedores = fornecedorDAO.consultaJpaQl_Par(1);
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println("Forncedor nome: " + fornecedor.getNome());
		}
	}

	@Test
	public void findSQl_Par() {
		List<Fornecedor> fornecedores = fornecedorDAO.consultaSQL_Par(1);
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println("Forncedor nome: " + fornecedor.getNome());
		}
	}

	@Test
	public void findListagem() {
		Integer totalLista = fornecedorDAO.listagem();
		Assert.assertNotNull(totalLista);
	}

	@Test
	public void findProblMaisUm() {
		List<Fornecedor> fornecedores = fornecedorDAO.problMaisUm();
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println("Forncedor nome: " + fornecedor.getNome());
		}
	}

	@Test
	public void findProblMaisUmResolvido() {
		List<Fornecedor> fornecedores = fornecedorDAO.problMaisUmResolvido();
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println("Forncedor nome: " + fornecedor.getNome());
		}
	}
}