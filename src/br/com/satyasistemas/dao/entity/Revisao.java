package br.com.satyasistemas.dao.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * The persistent class for the revisao database table.
 * 
 */
@Entity
@Table(name="revisao")
@NamedQueries({
@NamedQuery(name="Revisao.findAll", query="SELECT r FROM Revisao r"),
@NamedQuery(name="Revisao.findAllBySprintID", query="SELECT r FROM Revisao r where r.sprint = :sprintID")
})
public class Revisao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	@NotEmpty(message="Descrição não informada.")
	private String descricao;

	@NotEmpty(message="Tipo não informado.")
	private String tipo;

	@JoinColumn(name="fk_sprint")
	private int sprint;

	public Revisao() {}

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

	public int getSprint() {
		return this.sprint;
	}

	public void setSprint(int sprint) {
		this.sprint = sprint;
	}

}