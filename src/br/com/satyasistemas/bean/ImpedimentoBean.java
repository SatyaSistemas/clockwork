package br.com.satyasistemas.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.satyasistemas.dao.ImpedimentoDAO;
import br.com.satyasistemas.dao.UsuarioDAO;
import br.com.satyasistemas.dao.entity.Impedimento;
import br.com.satyasistemas.dao.entity.Usuario;

@ManagedBean(name = "impedimentoBean")
@ViewScoped
public class ImpedimentoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ImpedimentoDAO impedimentoDAO;
	public List<Impedimento> impedimentos;
	public Impedimento impedimento;
	private UsuarioDAO usuarioDAO;

	public ImpedimentoBean() {
		impedimentoDAO = new ImpedimentoDAO();
		usuarioDAO = new UsuarioDAO();
		impedimentos = new ArrayList<Impedimento>();
		impedimento = new Impedimento();
	}

	/*
	 * TODO: Falta validação dos campos
	 */
	public void addImpedimento() {
		impedimentoDAO.save(impedimento);
		this.impedimento = new Impedimento();
	}

	public void onCellEdit(Impedimento impedimentos) {
		impedimentoDAO.save(impedimentos);
	}

	public List<Usuario> getUsuarios() {
		return usuarioDAO.list();
	}

	public List<Impedimento> getImpedimentos() {
		return impedimentoDAO.list();
	}

	public void setImpedimentos(List<Impedimento> impedimentos) {
		this.impedimentos = impedimentos;
	}

	public Impedimento getImpedimento() {
		return impedimento;
	}

	public void setImpedimento(Impedimento impedimento) {
		this.impedimento = impedimento;
	}

}