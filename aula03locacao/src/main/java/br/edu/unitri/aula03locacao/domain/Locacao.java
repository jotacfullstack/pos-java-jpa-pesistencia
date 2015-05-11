package br.edu.unitri.aula03locacao.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_locacao")
public class Locacao implements Serializable {

	private static final long serialVersionUID = 504458644232710799L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "veiculo_id")
	private Veiculo veiculo;

	@ManyToOne
	@JoinColumn(name = "funcionario_cad_id")
	private Funcionario funcionarioCad;

	@ManyToOne
	@JoinColumn(name = "funcionario_rec_id")
	private Funcionario funcionarioRec;

	@Column(name = "qtd_dias")
	private int quantidadeDias;

	private int kilometragem;

	public Locacao(Cliente cliente, Veiculo veiculo,
			Funcionario funcionarioCad, Funcionario funcionarioRec,
			int quantidadeDias, int kilometragem) {
		super();
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.funcionarioCad = funcionarioCad;
		this.funcionarioRec = funcionarioRec;
		this.quantidadeDias = quantidadeDias;
		this.kilometragem = kilometragem;
	}

	public Locacao() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Funcionario getFuncionarioCad() {
		return funcionarioCad;
	}

	public void setFuncionarioCad(Funcionario funcionarioCad) {
		this.funcionarioCad = funcionarioCad;
	}

	public Funcionario getFuncionarioRec() {
		return funcionarioRec;
	}

	public int getQuantidadeDias() {
		return quantidadeDias;
	}

	public void setQuantidadeDias(int quantidadeDias) {
		this.quantidadeDias = quantidadeDias;
	}

	public int getKilometragem() {
		return kilometragem;
	}

	public void setKilometragem(int kilometragem) {
		this.kilometragem = kilometragem;
	}

}
