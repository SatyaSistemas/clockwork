package br.com.satyasistemas.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

import br.com.satyasistemas.dao.ProductBacklogDAO;
import br.com.satyasistemas.dao.UsuarioDAO;
import br.com.satyasistemas.dao.entity.ProductBacklog;
import br.com.satyasistemas.dao.entity.Usuario;

@ManagedBean(name = "backlogBean")
@ViewScoped
public class BacklogBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ProductBacklogDAO backlogDAO;
	private UsuarioDAO usuarioDAO;
	private List<ProductBacklog> itensBacklog;
	private ProductBacklog productBacklog;
	
	public final static String CHANNEL = "/backlogChange";

	public BacklogBean() {
		backlogDAO = new ProductBacklogDAO();
		productBacklog = new ProductBacklog();
		usuarioDAO = new UsuarioDAO();
		itensBacklog = new ArrayList<ProductBacklog>();
	}
	
	@PostConstruct
	private void init(){
		itensBacklog = backlogDAO.list();
	}

	public List<ProductBacklog> getItensBacklog() {
		return itensBacklog;
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
			|| productBacklog.getDemonstracao() == null
			|| productBacklog.getEstimativa() < 1
			|| productBacklog.getImportancia() < 1
			|| productBacklog.getSolicitante() == null
			|| productBacklog.getNome().equals("")
			|| productBacklog.getDemonstracao().equals("")
			|| productBacklog.getStatus() == null
				) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erro ao cadastrar",
							"Dados inválidos, favor verificar os campos"));
		} else {
			backlogDAO.save(productBacklog);
			publishEvent("added");
			update();
		}
	}

	public void onCellEdit(ProductBacklog backlog) {
		backlogDAO.save(backlog);
		publishEvent("edited");
		update();
	}
	
	public void deleteBacklogItem(){
		System.out.println(this.productBacklog);
		backlogDAO.delete(this.productBacklog);
		publishEvent("removed");
		update();
	}
	
	public List<Usuario> getUsuarios(){
		return usuarioDAO.list();
	}
	
	private void publishEvent(String s){
		 EventBus eventBus = EventBusFactory.getDefault().eventBus();
	     FacesContext fCtx = FacesContext.getCurrentInstance();
	     HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
	     String sessionId = session.getId();
	     eventBus.publish(CHANNEL, s+"*"+sessionId);
	}
	
	public void update(){
		productBacklog = new ProductBacklog();
		backlogDAO = new ProductBacklogDAO();
		itensBacklog = backlogDAO.list();
	}
	
}