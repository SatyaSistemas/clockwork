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
import br.com.satyasistemas.dao.entity.ItemSprint;

@ManagedBean(name = "sprintDetailBean")
@ViewScoped
public class SprintDetailBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ItemSprintDAO itemSprintDAO;
	private List<ItemSprint> itens;
	private ItemSprint item;
	private int sprintId;

	public SprintDetailBean() {
		this.itemSprintDAO = new ItemSprintDAO();
		itens = new ArrayList<ItemSprint>();
		item = new ItemSprint();
	}
	
	@PostConstruct
	public void init(){
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		sprintId = Integer.valueOf(params.get("sprintID"));
	}
	
	public void addItemSprint(){
		this.itemSprintDAO.save(item);
	}

	public List<ItemSprint> getItens() {
		return itemSprintDAO.list();
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
}