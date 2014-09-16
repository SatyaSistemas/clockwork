package br.com.satyasistemas.dao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "item_sprint")
@NamedQueries({
		@NamedQuery(name = "ItemSprint.findAll", query = "select i from ItemSprint i"),
		@NamedQuery(name = "ItemSprint.findAllBySprintID", query = "select i from ItemSprint i where i.sprint = :sprintID") })
public class ItemSprint implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;

	private boolean dependente;
	private int horasPlanejadas;
	private int horasRealizadas;
	private String nome;
	private String observacoes;
	private int prioridade;
	private String responsavel;
	private String situacao;

	@JoinColumn(name = "fk_sprint")
	private int sprint;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getDependente() {
		return this.dependente;
	}

	public void setDependente(boolean dependente) {
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

	public int getSprint() {
		return sprint;
	}

	public void setSprint(int sprint) {
		this.sprint = sprint;
	}

}