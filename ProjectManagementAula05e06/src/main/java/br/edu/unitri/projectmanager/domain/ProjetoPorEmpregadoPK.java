package br.edu.unitri.projectmanager.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProjetoPorEmpregadoPK implements Serializable {
	private static final long serialVersionUID = -633559695799265489L;

	@Column(name = "cod_empregado", nullable = false)
	private Long codEmpregado;

	@Column(name = "num_projeto", nullable = false)
	private Long numProjeto;

	public ProjetoPorEmpregadoPK() {
		super();
	}

	public ProjetoPorEmpregadoPK(Long codEmpregado, Long numProjeto) {
		super();
		this.codEmpregado = codEmpregado;
		this.numProjeto = numProjeto;
	}

	public Long getCodEmpregado() {
		return codEmpregado;
	}

	public void setCodEmpregado(Long codEmpregado) {
		this.codEmpregado = codEmpregado;
	}

	public Long getNumProjeto() {
		return numProjeto;
	}

	public void setNumProjeto(Long numProjeto) {
		this.numProjeto = numProjeto;
	}

}
