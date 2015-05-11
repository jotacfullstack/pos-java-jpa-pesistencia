package br.edu.unitri.projectmanager.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_empregado")
public class Empregado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String endereco;

	private String sexo;

	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@Column(name = "codigo_gerente")
	private int codigoGerente;

	@ManyToOne
	private Departamento departamento;

	@OneToMany(mappedBy = "empregado", cascade = CascadeType.PERSIST)
	private List<Dependente> dependentes = new ArrayList<Dependente>();

	public Empregado() {
		super();
	}

	public Empregado(String nome, Departamento departamento) {
		super();
		this.nome = nome;
		this.departamento = departamento;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getCodigoGerente() {
		return codigoGerente;
	}

	public void setCodigoGerente(int codigoGerente) {
		this.codigoGerente = codigoGerente;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

	@Override
	public String toString() {
		return "Empregado [id=" + id + ", nome=" + nome + ", endereco="
				+ endereco + ", sexo=" + sexo + ", dataNascimento="
				+ dataNascimento + ", codigoGerente=" + codigoGerente
				+ ", departamento=" + departamento + ", dependentes="
				+ dependentes + "]";
	}
}
