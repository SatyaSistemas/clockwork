package br.com.satyasistemas.dao;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.satyasistemas.dao.entity.ItemSprint;

public class ItemSprintDAO implements DAO<ItemSprint>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager entityManager;
	
	public ItemSprintDAO() {
		super();
		this.entityManager = DatabaseUtil.getEmf().createEntityManager();
	}

	@Override
	public void save(ItemSprint item) {
		if (item.getNome() == null || item.getPrioridade() < 1
				|| item.getSituacao() == null) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erro ao cadastrar",
							"Dados inválidos, favor verificar os campos"));
		} else {
			beginTransaction();
			if (item.getId() <= 0) {
				entityManager.persist(item);
			} else {
				entityManager.merge(item);
			}
			closeTransaction();
		}
	}

	@Override
	public ItemSprint findById(int id) {		
		return null;
	}
	
	@Override
	public void delete(ItemSprint item) {
		beginTransaction();
		entityManager.remove(item);
		closeTransaction();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemSprint> list() {
		Query query = entityManager.createNamedQuery("ItemSprint.findAll");
		return query.getResultList();
	}
	
	public List<ItemSprint> listBySprintID(int id) {
		Query query = entityManager.createNamedQuery("ItemSprint.findAllBySprintID").setParameter("sprintID", id);
		return query.getResultList();
	}

	@Override
	public List<ItemSprint> pageList() {
		return null;
	}
	
	private void beginTransaction(){
		entityManager.getTransaction().begin();
	}
	
	private void closeTransaction(){
		entityManager.getTransaction().commit();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
}
