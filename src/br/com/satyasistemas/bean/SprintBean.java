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
import br.com.satyasistemas.dao.entity.ProductBacklog;
import br.com.satyasistemas.dao.entity.Sprint;

@ManagedBean(name = "sprintBean")
@ViewScoped
public class SprintBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private SprintDAO sprintDAO;
	private List<Sprint> sprints;
	private Sprint sprint;
	private ProductBacklogDAO productBacklogDAO;
	private int sprintID;
	private String metas[];
	
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

	public String createString(String s[]){
		String ret = s[0] + ";"; // inicializando a strin de retorno com a primeira opçao para tirar o null
		for (int i = 1; i < s.length; i++){ 
		ret = ret + " " + s[i] + "; ";	// preenchendo o resto  das opçoes no formato correto
		}
		return ret;	// retorna as opções no formato correto
	}
	
	public void addSprintItem() {
		sprint.setMeta(createString(metas));
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
		if (metas != null){
			sprint.setMeta(createString(metas));
		}
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
		sprintDAO.getEntityManager().close();
		sprintDAO = new SprintDAO();
		sprints = sprintDAO.list();
		metas = null;		
	}

	public String[] getMetas() {
		return metas;
	}

	public void setMetas(String metas[]) {
		this.metas = metas;
	}

}