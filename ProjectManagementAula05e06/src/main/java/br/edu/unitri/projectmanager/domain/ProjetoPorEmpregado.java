package br.edu.unitri.projectmanager.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_projeto_empregado")
public class ProjetoPorEmpregado implements Serializable {

	private static final long serialVersionUID = -7001501283668540714L;

	@EmbeddedId
	private ProjetoPorEmpregadoPK id;

	@Column(name = "quantidade_horas")
	private int quantidadeHoras;

	public ProjetoPorEmpregado() {
		super();
	}

	public ProjetoPorEmpregado(ProjetoPorEmpregadoPK id, int quantidadeHoras) {
		super();
		this.id = id;
		this.quantidadeHoras = quantidadeHoras;
	}

	public ProjetoPorEmpregadoPK getId() {
		return id;
	}

	public void setId(ProjetoPorEmpregadoPK id) {
		this.id = id;
	}

	public int getQuantidadeHoras() {
		return quantidadeHoras;
	}

	public void setQuantidadeHoras(int quantidadeHoras) {
		this.quantidadeHoras = quantidadeHoras;
	}

}
