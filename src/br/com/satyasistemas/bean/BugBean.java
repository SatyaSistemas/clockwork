package br.com.satyasistemas.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

import br.com.satyasistemas.dao.BugDAO;
import br.com.satyasistemas.dao.UsuarioDAO;
import br.com.satyasistemas.dao.entity.Bug;
import br.com.satyasistemas.dao.entity.Usuario;

@ManagedBean(name = "bugBean")
@ViewScoped
public class BugBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private BugDAO bugDAO;
	private UsuarioDAO usuarioDAO;
	private List<Bug> bugList;
	private Bug bug;
	
	public final static String CHANNEL = "/bugChange";

	public BugBean() {
		bugDAO = new BugDAO();
		bug = new Bug();
		usuarioDAO = new UsuarioDAO();
		bugList = new ArrayList<Bug>();
	}
	
	@PostConstruct
	private void init(){
		bugList = bugDAO.list();
	}

	public List<Bug> getBugList() {
		return bugList;
	}

	public void setBugList(List<Bug> bugList) {
		this.bugList = bugList;
	}

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	public void addBug() {
			bugDAO.save(bug);
			bug = new Bug();
			publishEvent("added");
	}

	public void onCellEdit(Bug bug) {
		bugDAO.save(bug);
		publishEvent("edited");
	}
	
	public void deleteBug(){
		System.out.println(this.bug);
		bugDAO.delete(this.bug);
		//this.bug = new Bug();
		publishEvent("removed");
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
		this.bug = new Bug();
		bugDAO.getEntityManager().close();
		bugDAO = new BugDAO();
		bugList= bugDAO.list();
	}

	
}