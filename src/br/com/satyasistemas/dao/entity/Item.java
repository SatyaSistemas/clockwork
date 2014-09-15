package br.com.satyasistemas.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="item")
@NamedQuery(name = "Item.findAll", query = "select i from Impedimento i")
public class Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	
	private byte dependente;

	@Column(name="horas_planejadas")
	private int horasPlanejadas;

	@Column(name="horas_realizadas")
	private int horasRealizadas;

	private String nome;

	private String observacoes;

	private int prioridade;

	private String responsavel;

	private String situacao;

//	@JoinColumn(name="fk_sprint")
//	private Sprint sprint;

	public Item() {}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getDependente() {
		return this.dependente;
	}

	public void setDependente(byte dependente) {
		this.dependente = dependente;
	}

	public int getHorasPlanejadas() {
		return this.horasPlanejadas;
	}

	public void setHorasPlanejadas(int horasPlanejadas) {
		this.horasPlanejadas = horasPlanejadas;
	}

	public int getHorasRealizadas() {
		return this.horasRealizadas;
	}

	public void setHorasRealizadas(int horasRealizadas) {
		this.horasRealizadas = horasRealizadas;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObservacoes() {
		return this.observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public int getPrioridade() {
		return this.prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public String getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

//	public Sprint getSprint() {
//		return this.sprint;
//	}
//
//	public void setSprint(Sprint sprint) {
//		this.sprint = sprint;
//	}
}
