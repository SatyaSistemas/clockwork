package br.com.satyasistemas.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.satyasistemas.dao.UsuarioDAO;
import br.com.satyasistemas.dao.entity.Usuario;

@ManagedBean(name = "usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Usuario> usuarios;
	private UsuarioDAO usuarioDao;
	private Usuario usuario;

	public UsuarioBean() {
		usuarios = new ArrayList<Usuario>();
		usuarioDao = new UsuarioDAO();
		usuario = new Usuario();
	}

	public void deleteUsuario() {
		System.out.println("teste");
		System.out.println(this.usuario);
		usuarioDao.delete(this.usuario);
	}

	public List<Usuario> getUsuarios() {
		return usuarioDao.list();
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void addUser() {
			usuarioDao.save(usuario);
			usuario = new Usuario();
	}

	public void onCellEdit(Usuario usuario) {
		usuarioDao.save(usuario);
	}
}