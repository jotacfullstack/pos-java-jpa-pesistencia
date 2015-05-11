package br.edu.unitri.aula01sale.domain;

import java.io.Serializable;

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private String nome;
	private Integer tipo;
	private String estado;

	public Cliente(Integer codigo, String nome, Integer tipo, String estado) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
		this.estado = estado;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
