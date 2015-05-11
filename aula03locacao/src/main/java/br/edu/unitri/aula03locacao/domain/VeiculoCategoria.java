package br.edu.unitri.aula03locacao.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_veiculo_categoria")
public class VeiculoCategoria implements Serializable {

	private static final long serialVersionUID = -8245697393337213928L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "preco_base")
	private Double precoBase;
	private String descricao;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "veiculoCategoria")
	private List<Veiculo> veiculos;

	public VeiculoCategoria() {
		super();
	}

	public VeiculoCategoria(Double precoBase, String descricao) {
		super();
		this.precoBase = precoBase;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrecoBase() {
		return precoBase;
	}

	public void setPrecoBase(Double precoBase) {
		this.precoBase = precoBase;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

}
