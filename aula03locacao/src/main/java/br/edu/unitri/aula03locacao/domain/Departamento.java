package br.edu.unitri.aula03locacao.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_departamento")
public class Departamento implements Serializable {

	private static final long serialVersionUID = 3498138793790762520L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "DEPNAME")
	private String nome;

	private String descricao;

	@OneToMany(mappedBy = "departamento", cascade = { CascadeType.ALL })
	private Collection<Funcionario> funcionarios;

	public Departamento(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public Departamento() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Collection<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Collection<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
