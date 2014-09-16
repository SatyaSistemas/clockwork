package br.com.satyasistemas.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.satyasistemas.dao.SprintDAO;
import br.com.satyasistemas.dao.entity.Sprint;

@ManagedBean(name = "sprintBean")
@ViewScoped
public class SprintBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SprintDAO sprintDAO;
	private List<Sprint> sprints;
	private Sprint sprint;
	private int sprintID;

	public SprintBean() {
		this.sprintDAO = new SprintDAO();
		this.sprints = new ArrayList<Sprint>();
		this.sprint = new Sprint();
	}

	/*
	 * TODO: Falta validação dos campos
	 */
	public void addSprintItem() {
		sprintDAO.save(sprint);
		this.sprint = new Sprint();
	}

	public void onCellEdit(Sprint sprint) {
		sprintDAO.save(sprint);
	}

	public void deleteSprint() {
		sprintDAO.delete(this.sprint);
	}

	public List<Sprint> getSprints() {
		return sprintDAO.list();
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

}