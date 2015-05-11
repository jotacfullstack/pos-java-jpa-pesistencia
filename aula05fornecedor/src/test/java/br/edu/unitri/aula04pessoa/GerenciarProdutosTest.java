package br.edu.unitri.aula04pessoa;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.unitri.aula05fornecedor.dao.ProdutoDAO;
import br.edu.unitri.aula05fornecedor.domain.Fornecedor;
import br.edu.unitri.aula05fornecedor.domain.Produto;
import br.edu.unitri.aula05fornecedor.domain.vo.ProdutoFornecedorVO;

public class GerenciarProdutosTest {
	ProdutoDAO produtoDAO = null;

	@Before
	public void init() {
		produtoDAO = new ProdutoDAO();
	}

	@Test
	public void findProdutoByJpaQl() {
		List<Produto> produtoes = produtoDAO.consultaProdutoByCriteria();
		for (Produto produto : produtoes) {
			System.out.println("Produto nome: " + produto.getDescricao());
		}
	}

	@Test
	public void findProdutoByCriteria() {
		List<Produto> produtoes = produtoDAO.consultaProdutoByCriteria();
		for (Produto produto : produtoes) {
			System.out.println("Produto nome: " + produto.getDescricao());
		}
	}

	@Test
	public void findProdutoBySQLNativo() {
		List<Produto> produtoes = produtoDAO.consultaProdutoBySQLNativo();
		for (Produto produto : produtoes) {
			System.out.println("Produto nome: " + produto.getDescricao());
		}
	}

	@Test
	public void findProdutoJpaQlPorFornecedor() {
		Fornecedor fornecedor = new Fornecedor();
		List<Produto> produtoes = produtoDAO
				.consultaJpaQlPorFornecedor(fornecedor);
		for (Produto produto : produtoes) {
			System.out.println("Produto nome: " + produto.getDescricao());
		}
	}

	@Test
	public void findProdutoSQLPorFornecedor() {
		Fornecedor fornecedor = new Fornecedor();
		List<Produto> produtoes = produtoDAO
				.consultaSQLPorFornecedor(fornecedor);
		for (Produto produto : produtoes) {
			System.out.println("Produto nome: " + produto.getDescricao());
		}
	}

	@Test
	public void findComplex() {
		List<Object[]> lista = produtoDAO.resultComplex();
		for (Object[] tupla : lista) {
			System.out.println(" Produto : " + tupla[0]);
			System.out.println(" Fornecedor : " + tupla[1]);
		}
	}

	//@Test
	public void findComplex2() {
		List<ProdutoFornecedorVO> lista = produtoDAO.resultComplex2();
		for (ProdutoFornecedorVO vo : lista) {
			System.out.println(" Produto : " + vo.getProduto());
			System.out.println(" Fornecedor : " + vo.getFornecedor());
		}
	}

	@Test
	public void paginacao() {
		List<Produto> produtos = produtoDAO.paginacao(1, 2);
		for (Produto produto : produtos) {
			System.out.println("Produto nome: " + produto.getDescricao());
		}
	}
	
}