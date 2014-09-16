package br.com.satyasistemas.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
	
	public SprintDetailBean(){
		this.itemSprintDAO = new ItemSprintDAO();
		itens = new ArrayList<ItemSprint>();
		item = new ItemSprint();
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

}