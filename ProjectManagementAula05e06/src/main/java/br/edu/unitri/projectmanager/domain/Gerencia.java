package br.edu.unitri.projectmanager.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_gerencia")
public class Gerencia implements Serializable {

	private static final long serialVersionUID = -6314803202591668953L;

	@EmbeddedId
	private GerenciaPK id;

	private Date date;

	public Gerencia() {
		super();
	}

	public Gerencia(GerenciaPK id, Date date) {
		this.id = id;
		this.date = date;
	}

	public GerenciaPK getId() {
		return id;
	}

	public void setId(GerenciaPK id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
