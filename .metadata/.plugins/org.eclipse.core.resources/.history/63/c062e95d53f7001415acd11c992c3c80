package br.edu.unitri.aula04pessoa;

import org.junit.Before;
import org.junit.Test;

import br.edu.unitri.aula04pessoa.dao.PessoaDAO;
import br.edu.unitri.aula04pessoa.dao.PessoaFisicaDAO;
import br.edu.unitri.aula04pessoa.dao.PessoaJuridicaDAO;
import br.edu.unitri.aula04pessoa.domain.Endereco;
import br.edu.unitri.aula04pessoa.domain.Pessoa;
import br.edu.unitri.aula04pessoa.domain.PessoaFisica;
import br.edu.unitri.aula04pessoa.domain.PessoaJuridica;

public class GerenciarPessoasTest {
	PessoaDAO pessoaDAO = null;
	PessoaJuridicaDAO pessoaJuridicaDAO = null;
	PessoaFisicaDAO pessoaFisicaDAO = null;

	@Before
	public void init() {
		pessoaDAO = new PessoaDAO();
		pessoaJuridicaDAO = new PessoaJuridicaDAO();
		pessoaFisicaDAO = new PessoaFisicaDAO();
	}

	@Test
	public void adicionaPessoaFisica() {

		PessoaFisica pessoaFisica = new PessoaFisica();
		pessoaFisica.setNome("Fulano");
		pessoaFisica.setCpf("111.222.333-44");
		pessoaFisicaDAO.inserePessoaFisica(pessoaFisica);

	}

	@Test
	public void insertPJ() {

		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		pessoaJuridica.setNome("Empresa");
		pessoaJuridica.setCnpj("11.444.777/0001-61");
		pessoaJuridicaDAO.inserePessoaJuridica(pessoaJuridica);

	}

	@Test
	public void insert() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Bla");
		pessoaDAO.inserePessoa(pessoa);
	}

	@Test
	public void insertComEndereco() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Bla");
		Endereco endereco = new Endereco("Brasil", "Estado", "Cidade",
				" Lograduro", 1232, "complemento", 234234534);
		pessoa.setEndereco(endereco);
		pessoaDAO.inserePessoa(pessoa);
	}

	@Test
	public void findPessoa() {

		Pessoa pessoa = pessoaDAO.findById(1l);
		PessoaFisica pessoaFisica = pessoaFisicaDAO.findById(1l);
		PessoaJuridica pessoaJuridica = pessoaJuridicaDAO.findById(1l);

		System.out.println("OK!! " + pessoa);
		System.out.println("OK!! " + pessoaFisica);
		System.out.println("OK!! " + pessoaJuridica);
	}
}