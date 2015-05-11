package br.edu.unitri.projectmanager.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_departamento")
public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	public String nome;

	@OneToMany(mappedBy = "departamento", cascade = CascadeType.PERSIST)
	private List<Empregado> empregados = new ArrayList<Empregado>();

	@ManyToMany
	@JoinTable(name = "local_dept", joinColumns = @JoinColumn(name = "num_dept"), inverseJoinColumns = @JoinColumn(name = "cod_local"))
	private Collection<Local> locais = new ArrayList<Local>();

	public Departamento() {
		super();
	}

	public Departamento(String nome) {
		this.nome = nome;
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

	public List<Empregado> getEmpregados() {
		return empregados;
	}

	public void setEmpregados(List<Empregado> empregados) {
		this.empregados = empregados;
	}

	public Collection<Local> getLocais() {
		return locais;
	}

	public void setLocais(Collection<Local> locais) {
		this.locais = locais;
	}

}
