package br.com.satyasistemas.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

import br.com.satyasistemas.dao.ImpedimentoDAO;
//import br.com.satyasistemas.dao.ProductBacklogDAO;
import br.com.satyasistemas.dao.UsuarioDAO;
import br.com.satyasistemas.dao.entity.Impedimento;
//import br.com.satyasistemas.dao.entity.ProductBacklog;
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
	
	public final static String CHANNEL = "/impedimentoChange";

	public ImpedimentoBean() {
		impedimentoDAO = new ImpedimentoDAO();
		usuarioDAO = new UsuarioDAO();
		impedimentos = new ArrayList<Impedimento>();
		impedimento = new Impedimento();
	}
	
	public void addImpedimento() {
		if(impedimento.getImpedimento() == null 
			|| impedimento.getReportado() == null 
			|| impedimento.getFinalizacao().before(impedimento.getCriacao()) 
			|| impedimento.getFinalizacao() == null 
			|| impedimento.getCriacao() == null
			 ) {
				FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erro ao cadastrar",
							"Dados inválidos, favor verificar os campos"));
		} else {
			impedimentoDAO.save(impedimento);
			this.impedimento = new Impedimento();
			publishEvent("added");
			update();
		}
	}
	
	

	public void deleteImpedimento() {
		impedimentoDAO.delete(this.impedimento);
		update();
	}

	public void onCellEdit(Impedimento impedimentos) {
		impedimentoDAO.save(impedimentos);
		update();
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
	
	private void publishEvent(String s){
		 EventBus eventBus = EventBusFactory.getDefault().eventBus();
	     FacesContext fCtx = FacesContext.getCurrentInstance();
	     HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
	     String sessionId = session.getId();
	     eventBus.publish(CHANNEL, s+"*"+sessionId);
	}
	
	
	public void update(){
		impedimento = new Impedimento();
		impedimentoDAO = new ImpedimentoDAO();
		impedimentos = impedimentoDAO.list();
	}

}