package br.com.satyasistemas.dao;

import java.io.Serializable;
import java.util.List;

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
		beginTransaction();
		
		if(item.getId() <= 0)
			entityManager.persist(item);
		else
			entityManager.merge(item);
		
		closeTransaction();
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
