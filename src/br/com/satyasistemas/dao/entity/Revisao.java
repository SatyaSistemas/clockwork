package br.com.satyasistemas.dao.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the revisao database table.
 * 
 */
@Entity
@Table(name="revisao")
@NamedQuery(name="Revisao.findAll", query="SELECT r FROM Revisao r")
public class Revisao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String descricao;

	private String tipo;

	@JoinColumn(name="fk_sprint")
	private Sprint sprint;

	public Revisao() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Sprint getSprint() {
		return this.sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

}