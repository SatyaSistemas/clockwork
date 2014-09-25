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
import br.com.satyasistemas.dao.SprintDAO;
import br.com.satyasistemas.dao.UsuarioDAO;
import br.com.satyasistemas.dao.entity.ProductBacklog;
//import br.com.satyasistemas.dao.entity.ProductBacklog;
import br.com.satyasistemas.dao.entity.Sprint;
import br.com.satyasistemas.dao.entity.Usuario;

@ManagedBean(name = "sprintBean")
@ViewScoped
public class SprintBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private SprintDAO sprintDAO;
	private List<Sprint> sprints;
	private Sprint sprint;
	private ProductBacklogDAO productBacklogDAO;
	private int sprintID;
	
	public final static String CHANNEL = "/sprintsChange";

	public SprintBean() {
		this.sprintDAO = new SprintDAO();
		productBacklogDAO = new ProductBacklogDAO();
		this.sprints = new ArrayList<Sprint>();
		this.sprint = new Sprint();
	}
	
	@PostConstruct
	public void init(){
		sprints = sprintDAO.list();
	}


	public void addSprintItem() {
		if(sprint.getMeta() == null 
			|| sprint.getMeta().equals("") 
			|| sprint.getTamanho() < 1 
			|| sprint.getTermino().before(sprint.getInicio()) 
			|| sprint.getTamanhoRealizado() < 0 
			|| sprint.getTamanhoRealizado() > sprint.getTamanho()
			 ) {
				FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erro ao cadastrar",
							"Dados inválidos, favor verificar os campos"));
		} else {
			sprintDAO.save(sprint);
			publishEvent("added");
			update();
		}
	}
	
	public List<ProductBacklog> getBacklogs(){
		return productBacklogDAO.list();
	}

	public void onCellEdit(Sprint sprint) {
		sprintDAO.save(sprint);
		publishEvent("edited");
		update();
	}

	public void deleteSprint() {
		sprintDAO.delete(this.sprint);
		publishEvent("removed");
		update();
	}

	public List<Sprint> getSprints() {
		return sprints;
	}

	public void setSprints(List<Sprint> sprints) {
		this.sprints = sprints;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public String goSprintDetail() {
		return "pretty:sprintDetail";
	}

	public int getSprintID() {
		return sprintID;
	}

	public void setSprintID(int sprintID) {
		this.sprintID = sprintID;
	}
	
	private void publishEvent(String s){
		 EventBus eventBus = EventBusFactory.getDefault().eventBus();
	     FacesContext fCtx = FacesContext.getCurrentInstance();
	     HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
	     String sessionId = session.getId();
	     eventBus.publish(CHANNEL, s+"*"+sessionId);
	}
	
	public void update(){
		sprint = new Sprint();
		sprintDAO = new SprintDAO();
		sprints = sprintDAO.list();
	}

}