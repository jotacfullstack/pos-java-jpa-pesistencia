package aula02produto;

import java.util.List;

import br.edu.unitri.aula02produto.dao.FornecedorDAO;
import br.edu.unitri.aula02produto.dao.ProdutoDAO;
import br.edu.unitri.aula02produto.domain.Fornecedor;
import br.edu.unitri.aula02produto.domain.Produto;

public class JPAProdutoManagerTest {

	public static void main(String args[]) {
		FornecedorDAO fornecedorDao = new FornecedorDAO();

		Fornecedor f1 = new Fornecedor("Alpargatas");
		Fornecedor f2 = new Fornecedor("Unilever");
		Fornecedor f3 = new Fornecedor("Sadia");
		Fornecedor f4 = new Fornecedor("Perdigão");

		fornecedorDao.insereFornecedor(f1);
		fornecedorDao.insereFornecedor(f2);
		fornecedorDao.insereFornecedor(f3);
		fornecedorDao.insereFornecedor(f4);

		ProdutoDAO produtoDao = new ProdutoDAO();
		produtoDao.insereProduto(new Produto("havaianas top", f1));
		produtoDao.insereProduto(new Produto("havaianas color", f1));
		produtoDao.insereProduto(new Produto("linguiça toscana", f3));

		List<Fornecedor> fornecedores = fornecedorDao.consultaFornedorByJpaQl();
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println("Fornecedor(ByJpaQl): " + fornecedor.getNome());
		}

		List<Fornecedor> fornecedores1 = fornecedorDao
				.consultaFornedorByCriteria();
		for (Fornecedor fornecedor1 : fornecedores1) {
			System.out.println("Fornecedor(ByCriteria): "
					+ fornecedor1.getNome());
		}

		List<Fornecedor> fornecedores2 = fornecedorDao
				.consultaFornedorBySQLNativo();
		for (Fornecedor fornecedor2 : fornecedores2) {
			System.out.println("Fornecedor(BySQLNativo): "
					+ fornecedor2.getNome());
		}

		List<Produto> produtos = produtoDao.consultaProdutoByJpaQl();
		for (Produto produto : produtos) {
			System.out.println("Produto(ByJpaQl): " + produto.getDescricao()
					+ " = " + "Fornecedor: "
					+ produto.getFornecedor().getNome());
		}

		List<Produto> produtos1 = produtoDao.consultaProdutoByCriteria();
		for (Produto produto1 : produtos1) {
			System.out.println("Produto(ByCriteria): "
					+ produto1.getDescricao() + " = " + "Fornecedor: "
					+ produto1.getFornecedor().getNome());
		}

		List<Produto> produtos2 = produtoDao.consultaProdutoBySQLNativo();
		for (Produto produto2 : produtos2) {
			System.out.println("Produto(BySQLNativo): "
					+ produto2.getDescricao() + " = " + "Fornecedor: "
					+ produto2.getFornecedor().getNome());
		}

	}
}