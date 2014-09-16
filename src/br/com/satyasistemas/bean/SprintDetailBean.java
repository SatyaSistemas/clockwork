package br.com.satyasistemas.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.satyasistemas.dao.ItemSprintDAO;
import br.com.satyasistemas.dao.RevisaoDAO;
import br.com.satyasistemas.dao.UsuarioDAO;
import br.com.satyasistemas.dao.entity.ItemSprint;
import br.com.satyasistemas.dao.entity.Revisao;
import br.com.satyasistemas.dao.entity.Usuario;

@ManagedBean(name = "sprintDetailBean")
@ViewScoped
public class SprintDetailBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private ItemSprintDAO itemSprintDAO;
	private UsuarioDAO usuarioDAO;
	private RevisaoDAO revisaoDAO;
	private List<ItemSprint> itens;
	private List<Revisao> revisoes;
	private ItemSprint item;
	private Revisao revisao;
	private int sprintId;

	public SprintDetailBean() {
		this.itemSprintDAO = new ItemSprintDAO();
		this.usuarioDAO = new UsuarioDAO();
		this.revisaoDAO = new RevisaoDAO();
		this.itens = new ArrayList<ItemSprint>();
		this.item = new ItemSprint();
		this.revisao = new Revisao();
	}

	@PostConstruct
	public void init() {
		Map<String, String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		sprintId = Integer.valueOf(params.get("sprintID"));
	}

	public void addItemSprint() {
		this.item.setSprint(sprintId);
		this.itemSprintDAO.save(item);
		this.item = new ItemSprint();
	}
	
	public void addRevisao(){
		this.revisao.setSprint(sprintId);
		this.revisaoDAO.save(revisao);
		this.revisao = new Revisao();
	}

	public void onCellEdit(ItemSprint item) {
		itemSprintDAO.save(item);
	}
	
	public void deleteItem(){
		this.itemSprintDAO.delete(item);
		this.item = new ItemSprint();
	}
	
	public void deleteRevisao(){
		this.revisaoDAO.delete(revisao);
		this.revisao = new Revisao();
	}
	
	public void onCellEditRevisao(Revisao revisao) {
		this.revisaoDAO.save(revisao);
	}

	public List<ItemSprint> getItens() {
		return itemSprintDAO.listBySprintID(sprintId);
	}

	public void setItens(List<ItemSprint> itens) {
		this.itens = itens;
	}

	public ItemSprint getItem() {
		return item;
	}

	public void setItem(ItemSprint item) {
		this.item = item;
	}

	public int getSprintId() {
		return sprintId;
	}

	public void setSprintId(int sprintId) {
		this.sprintId = sprintId;
	}

	public List<Usuario> getUsuarios() {
		return usuarioDAO.list();
	}

	public List<Revisao> getRevisoes() {
		return this.revisaoDAO.listBySprintID(sprintId);
	}

	public void setRevisoes(List<Revisao> revisoes) {
		this.revisoes = revisoes;
	}

	public Revisao getRevisao() {
		return revisao;
	}

	public void setRevisao(Revisao revisao) {
		this.revisao = revisao;
	}

}