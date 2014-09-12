package br.com.satyasistemas.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.satyasistemas.dao.ProductBacklogDAO;
import br.com.satyasistemas.dao.entity.ProductBacklog;

@ManagedBean(name="indexBean")
@ViewScoped
public class IndexBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProductBacklogDAO backlogDAO;
	
	public IndexBean(){
		backlogDAO = new ProductBacklogDAO();
	}
	
	private List<ProductBacklog> itensBacklog;

	public List<ProductBacklog> getItensBacklog() {
		return backlogDAO.list();
	}

	public void setItensBacklog(List<ProductBacklog> itensBacklog) {
		this.itensBacklog = itensBacklog;
	}
	
	public void addBacklogItem(){
		System.out.println("called add");
	}
	
}