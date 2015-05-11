package br.edu.unitri.aula06livro.domain;

public class ProdFornVO {

	private String prod;
	private String forn;

	public ProdFornVO() {
		super();
	}

	public ProdFornVO(String prod, String forn) {
		super();
		this.prod = prod;
		this.forn = forn;
	}

	public String getProd() {
		return prod;
	}

	public void setProd(String prod) {
		this.prod = prod;
	}

	public String getForn() {
		return forn;
	}

	public void setForn(String forn) {
		this.forn = forn;
	}

	@Override
	public String toString() {
		return "ProdFornVO [prod=" + prod + ", forn=" + forn + "]";
	}

}
