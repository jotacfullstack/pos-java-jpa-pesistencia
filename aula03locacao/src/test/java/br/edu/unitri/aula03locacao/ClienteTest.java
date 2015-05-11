package br.edu.unitri.aula03locacao;

import java.util.List;

import br.edu.unitri.aula03locacao.dao.ClienteDAO;
import br.edu.unitri.aula03locacao.domain.Cliente;

public class ClienteTest {
	public static void main(String args[]) {
		ClienteDAO clienteDAO = new ClienteDAO();

		Cliente c1 = new Cliente("Maria", "2345234534");
		Cliente c2 = new Cliente("José", "2345234534");
		Cliente c3 = new Cliente("Antonio", "2345234534");
		Cliente c4 = new Cliente("Joana", "3425234");

		clienteDAO.insereCliente(c1);
		clienteDAO.insereCliente(c2);
		clienteDAO.insereCliente(c3);
		clienteDAO.insereCliente(c4);
		
		List<Cliente> clientes = clienteDAO.consultaCliente();
		for (Cliente cliente : clientes) {
			System.out.println("Cliente Name Inseridos: " + cliente.getNome() + " = "
					+ "cpf: " + cliente.getCpf());
		}
		
		Cliente result = clienteDAO.consultaClientePorId(1l);
		result.setNome("Maria Guilhermina");
		
		clienteDAO.alteraCliente(result);
		
		Cliente remove = clienteDAO.consultaClientePorId(3l);
		clienteDAO.deleteCliente(remove);
		
		List<Cliente> clientesAlterados = clienteDAO.consultaCliente();
		for (Cliente cliente : clientesAlterados) {
			System.out.println("Cliente Name alterados: " + cliente.getNome() + " = "
					+ "cpf: " + cliente.getCpf());
		}
	}
}
