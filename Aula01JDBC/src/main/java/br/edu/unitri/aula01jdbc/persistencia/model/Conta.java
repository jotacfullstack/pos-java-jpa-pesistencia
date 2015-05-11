package br.edu.unitri.aula01jdbc.persistencia.model;

public class Conta {
	private long id;
	private String nome;
	private int agencia;
	private int senha;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", nome=" + nome + ", agencia=" + agencia
				+ ", senha=" + senha + "]";
	}
	
}
