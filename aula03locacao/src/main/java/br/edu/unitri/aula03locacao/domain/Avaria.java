package br.edu.unitri.aula03locacao.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_avaria")
public class Avaria implements Serializable {

	private static final long serialVersionUID = 9033007353232152764L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Double valor;
	private String descicao;

	@ManyToOne
	@JoinColumn(name = "locacao_id")
	private Locacao locacao;

	public Avaria() {
		super();
	}

	public Avaria(Double valor, String descicao, Locacao locacao) {
		super();
		this.valor = valor;
		this.descicao = descicao;
		this.locacao = locacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescicao() {
		return descicao;
	}

	public void setDescicao(String descicao) {
		this.descicao = descicao;
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

}
