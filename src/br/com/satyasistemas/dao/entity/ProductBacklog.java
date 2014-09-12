package br.com.satyasistemas.dao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "product_backlog")
@NamedQuery(name = "findAllBacklog", query = "select pb from ProductBacklog pb")
public class ProductBacklog implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private int importancia;
	private int estimativa;
	private String demonstracao;
	private String notas;
	private String solicitante;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getImportancia() {
		return importancia;
	}

	public void setImportancia(int importancia) {
		this.importancia = importancia;
	}

	public int getEstimativa() {
		return estimativa;
	}

	public void setEstimativa(int estimativa) {
		this.estimativa = estimativa;
	}

	public String getDemonstracao() {
		return demonstracao;
	}

	public void setDemonstracao(String demonstracao) {
		this.demonstracao = demonstracao;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	@Override
	public String toString() {
		return "ProductBacklog [id=" + id + ", nome=" + nome + ", importancia="
				+ importancia + ", estimativa=" + estimativa
				+ ", demonstracao=" + demonstracao + ", notas=" + notas
				+ ", solicitante=" + solicitante + "]";
	}
	
}