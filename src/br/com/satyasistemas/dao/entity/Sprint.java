package br.com.satyasistemas.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the sprint database table.
 * 
 */
@Entity
@Table(name="sprint")
@NamedQuery(name="Sprint.findAll", query="SELECT s FROM Sprint s")
public class Sprint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	@Column(name="definicao_pronto")
	private String definicaoPronto;

	@Temporal(TemporalType.DATE)
	private Date inicio;

	private String meta;

	private int tamanho;

	@Column(name="tamanho_realizado")
	private int tamanhoRealizado;

	@Temporal(TemporalType.DATE)
	private Date termino;
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDefinicaoPronto() {
		return this.definicaoPronto;
	}

	public void setDefinicaoPronto(String definicaoPronto) {
		this.definicaoPronto = definicaoPronto;
	}

	public Date getInicio() {
		return this.inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public String getMeta() {
		return this.meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	public int getTamanho() {
		return this.tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getTamanhoRealizado() {
		return this.tamanhoRealizado;
	}

	public void setTamanhoRealizado(int tamanhoRealizado) {
		this.tamanhoRealizado = tamanhoRealizado;
	}

	public Date getTermino() {
		return this.termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}
}