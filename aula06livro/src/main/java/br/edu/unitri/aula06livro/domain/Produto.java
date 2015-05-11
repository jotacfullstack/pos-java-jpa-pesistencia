package br.edu.unitri.aula06livro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
		@NamedQuery(name = "buscaProdutosPorFornecedorJpa", query = "Select p from Produto p where p.fornecedor = :fornecedor"),
		@NamedQuery(name = "buscaProdutosPorFornecedorJpa2", query = "Select p from Produto p where p.fornecedor.codigo = :fornecedor"),
		@NamedQuery(name = "buscaProdutosPorFornecedorJpa3", query = "Select p from Produto p where p.fornecedor = :fornecedor") })
@NamedNativeQueries({ @NamedNativeQuery(name = "buscaProdutosPorFornecedorSql", query = "Select * from tbProduto where codfrn = ?", resultClass = Produto.class) })
@Entity
@Table(name = "tbProduto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODPRO")
	private Integer codigo;
	@Column(name = "DSCPRO")
	private String descricao;
	@ManyToOne
	@JoinColumn(name = "CODFRN", nullable = false, insertable = true, updatable = true)
	private Fornecedor fornecedor;

	public Produto() {
		super();
	}

	public Produto(String descricao, Fornecedor fornecedor) {
		super();
		this.descricao = descricao;
		this.fornecedor = fornecedor;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", descricao=" + descricao
				+ ", fornecedor=" + fornecedor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}