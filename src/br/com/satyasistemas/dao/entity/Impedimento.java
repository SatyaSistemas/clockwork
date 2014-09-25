package br.com.satyasistemas.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "impedimentos")
@NamedQuery(name = "Impedimento.findAll", query = "select i from Impedimento i")
public class Impedimento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	
	@NotEmpty(message="Impedimento não informado.")
	private String impedimento;
	
	@NotEmpty(message="Autor do impedimento não informado.")
	private String reportado;
	
	private String responsavel;
	
	@Temporal(TemporalType.DATE)
	@NotNull(message="Data de criação não informada.")
	private Date criacao;
	
	@Temporal(TemporalType.DATE)
	@NotNull(message="Data de finalização não informada.")
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

	public String getReportado() {
		return reportado;
	}

	public void setReportado(String reportado) {
		this.reportado = reportado;
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