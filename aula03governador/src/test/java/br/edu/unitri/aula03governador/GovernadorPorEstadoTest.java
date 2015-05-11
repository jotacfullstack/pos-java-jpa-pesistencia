package br.edu.unitri.aula03governador;

import org.junit.Before;
import org.junit.Test;

import br.edu.unitri.aula03governador.dao.EstadoDAO;
import br.edu.unitri.aula03governador.dao.GovernadorDAO;
import br.edu.unitri.aula03governador.domain.Estado;
import br.edu.unitri.aula03governador.domain.Governador;

public class GovernadorPorEstadoTest {
	EstadoDAO estadoDAO = null;
	GovernadorDAO governadorDAO = null;

	@Before
	public void init() {
		estadoDAO = new EstadoDAO();
		governadorDAO = new GovernadorDAO();
	}

	@Test
	public void adicionaAutorLivros() {

		Governador g = new Governador();
		g.setNome("Geraldo Alckmin");
		governadorDAO.insereGovernador(g);
		Governador governador = governadorDAO.buscaPorId(g.getId());
		
		Estado e = new Estado();
		e.setNome("São Paulo");
		e.setGovernador(governador);
		
		estadoDAO.insereEstado(e);
		
	}
}