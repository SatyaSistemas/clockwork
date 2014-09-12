package br.com.satyasistemas.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "impedimentos")
@NamedQuery(name = "findAllImpedimento", query = "select i from Impedimento i")
public class Impedimento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	
	private String impedimento;
	
	@Column(name = "responsavel_por")
	private String responsavelPor;
	
	private String responsavel;
	
	@Column(name = "data_criacao")
	private Date criacao;
	
	@Column(name = "data_final")
	private Date finalizacao;
	
	private String observacao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImpedimento() {
		return impedimento;
	}

	public void setImpedimento(String impedimento) {
		this.impedimento = impedimento;
	}

	public String getResponsavelPor() {
		return responsavelPor;
	}

	public void setResponsavelPor(String responsavelPor) {
		this.responsavelPor = responsavelPor;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Date getCriacao() {
		return criacao;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}

	public Date getFinalizacao() {
		return finalizacao;
	}

	public void setFinalizacao(Date finalizacao) {
		this.finalizacao = finalizacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}