package br.com.satyasistemas.dao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "bugs")
@NamedQuery(name = "Bug.findAll", query = "select b from Bug b")
public class Bug implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	
	@NotEmpty(message="Nome não informado.")
	private String nome;
	
	@NotEmpty(message="Projeto não informado.")
	private String projeto;
	
	@NotEmpty(message="Descrição não informada.")
	private String descricao;
	
	@NotEmpty(message="Autor não informado.")
	private String autor;
	
	@NotEmpty(message="Status não informado.")
	private String status;

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
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Bug [id=" + id + ", nome=" + nome + ", Descrição="
				+ descricao + ", Autor=" + autor
				+ ", Status=" + status + "]";
	}

	public String getProjeto() {
		return projeto;
	}

	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}


	
}