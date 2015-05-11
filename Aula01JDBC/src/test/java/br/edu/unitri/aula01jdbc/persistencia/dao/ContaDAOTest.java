package br.edu.unitri.aula01jdbc.persistencia.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.unitri.aula01jdbc.persistencia.model.Conta;

public class ContaDAOTest {
	ContaDAO contaDAO = null;
	Conta conta = null;

	@Before
	public void getDaoInstance() {
		contaDAO = new ContaDAO();
	}

	@Test
	public void shouldInsertAccount() {

		conta = new Conta();

		conta.setNome("rogerio");
		conta.setAgencia(1);
		conta.setSenha(1234);

		boolean result = contaDAO.insertConta(conta);
		assertEquals(true, result);
	}

	@Test
	public void shouldListAccounts() {
		List<Conta> contas = contaDAO.getContas();
		assertTrue(contas.size() > 0);
	}
	
	@Test
	public void shouldInsertAccountByBatch(){
		
		List<Conta> contas = new ArrayList<Conta>();
		
		Conta conta1 = new Conta();

		conta1.setNome("rogerio");
		conta1.setAgencia(1);
		conta1.setSenha(1234);
		contas.add(conta1);
		
		Conta conta2 = new Conta();

		conta2.setNome("rogerio");
		conta2.setAgencia(1);
		conta2.setSenha(1234);
		contas.add(conta2);
		
		Conta conta3 = new Conta();

		conta3.setNome("rogerio");
		conta3.setAgencia(1);
		conta3.setSenha(1234);
		contas.add(conta3);
		
		Conta conta4 = new Conta();

		conta4.setNome("rogerio");
		conta4.setAgencia(1);
		conta4.setSenha(1234);
		contas.add(conta4);
		
		boolean result = contaDAO.insertContaByBatch(contas);
		
		assertEquals(true, result);
	}
	
	@Test
	public void shouldDeleteAccounts() {
		boolean result = contaDAO.deleteContas();
		
		assertEquals(true, result);
	}

}
