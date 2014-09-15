package br.com.satyasistemas.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.satyasistemas.dao.ProductBacklogDAO;
import br.com.satyasistemas.dao.UsuarioDAO;
import br.com.satyasistemas.dao.entity.ProductBacklog;
import br.com.satyasistemas.dao.entity.Usuario;

@ManagedBean(name = "backlogBean")
@ViewScoped
public class BacklogBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ProductBacklogDAO backlogDAO;
	private UsuarioDAO usuarioDAO;

	private List<ProductBacklog> itensBacklog = new ArrayList<ProductBacklog>();
	private ProductBacklog productBacklog;

	public BacklogBean() {
		backlogDAO = new ProductBacklogDAO();
		productBacklog = new ProductBacklog();
		usuarioDAO = new UsuarioDAO();
	}

	public List<ProductBacklog> getItensBacklog() {
		return backlogDAO.list();
	}

	public void setItensBacklog(List<ProductBacklog> itensBacklog) {
		this.itensBacklog = itensBacklog;
	}

	public ProductBacklog getProductBacklog() {
		return productBacklog;
	}

	public void setProductBacklog(ProductBacklog productBacklog) {
		this.productBacklog = productBacklog;
	}

	public void addBacklogItem() {
		if (productBacklog.getNome() == null
				|| productBacklog.getNome().equals("")
				|| productBacklog.getImportancia() <= 0) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erro ao cadastrar",
							"Dados inválidos, favor verificar os campos"));
		} else {
			backlogDAO.save(productBacklog);
			productBacklog = new ProductBacklog();
		}
	}

	public void onCellEdit(ProductBacklog backlog) {
		System.out.println(backlog);
		backlogDAO.save(backlog);
	}
	
	public List<Usuario> getUsuarios(){
		return usuarioDAO.list();
	}
	
}