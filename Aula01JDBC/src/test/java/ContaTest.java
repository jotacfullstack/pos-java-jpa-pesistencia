import java.util.List;

import br.edu.unitri.aula01jdbc.persistencia.dao.ContaDAO;
import br.edu.unitri.aula01jdbc.persistencia.model.Conta;

public class ContaTest {

	public static void main(String[] args) {
		ContaDAO contaDao = new ContaDAO();

		/*Conta conta = new Conta();

		conta.setNome("rogerio");
		conta.setAgencia(1);
		conta.setSenha(1234);

		boolean result = contaDao.insertConta(conta);
		System.out.println(result);*/

		List<Conta> contas = contaDao.getContas();

		for (Conta contaResult : contas) {
			System.out.println("Nome:" + contaResult.getNome());
			System.out.println("Agencia:" + contaResult.getAgencia());
			System.out.println("Senha:" + contaResult.getSenha());
			System.out.println("----\n");
		}

	}

}
