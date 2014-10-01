package br.com.satyasistemas.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.satyasistemas.dao.entity.Bug;

public class BugDAO implements DAO<Bug>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager entityManager;
	
	public BugDAO() {
		super();
		this.entityManager = DatabaseUtil.getEmf().createEntityManager();
	}

	@Override
	public void save(Bug bug) {
		beginTransaction();
		if(bug.getId() > 0){
			entityManager.merge(bug);
		}else{
			entityManager.persist(bug);
		}
		
		closeTransaction();
	}

	@Override
	public Bug findById(int id) {		
		return null;
	}
	
	@Override
	public void delete(Bug bug) {
		beginTransaction();
		entityManager.remove(bug);
		closeTransaction();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bug> list() {
		Query query = entityManager.createNamedQuery("Bug.findAll");
		return query.getResultList();
	}

	@Override
	public List<Bug> pageList() {
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
