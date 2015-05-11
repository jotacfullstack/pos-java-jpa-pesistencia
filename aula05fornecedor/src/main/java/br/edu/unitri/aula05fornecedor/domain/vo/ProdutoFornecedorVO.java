package br.edu.unitri.aula05fornecedor.domain.vo;

public class ProdutoFornecedorVO {
	private String produto;
	private String fornecedor;

	public ProdutoFornecedorVO() {
		super();
	}

	public ProdutoFornecedorVO(String produto, String fornecedor) {
		super();
		this.produto = produto;
		this.fornecedor = fornecedor;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		return "ProdutoFornecedorVO [produto=" + produto + ", fornecedor="
				+ fornecedor + "]";
	}

}
