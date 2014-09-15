package br.com.satyasistemas.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.satyasistemas.dao.entity.Sprint;

public class SprintDAO implements DAO<Sprint>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager entityManager;
	
	public SprintDAO() {
		super();
		this.entityManager = DatabaseUtil.getEmf().createEntityManager();
	}

	@Override
	public void save(Sprint sprint) {
		beginTransaction();
		
		if(sprint.getId() <= 0)
			entityManager.persist(sprint);
		else
			entityManager.merge(sprint);
		
		closeTransaction();
	}

	@Override
	public Sprint findById(int id) {		
		return null;
	}
	
	@Override
	public void delete(Sprint sprint) {
		beginTransaction();
		entityManager.remove(sprint);
		closeTransaction();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sprint> list() {
		Query query = entityManager.createNamedQuery("Sprint.findAll");
		return query.getResultList();
	}

	@Override
	public List<Sprint> pageList() {
		return null;
	}
	
	private void beginTransaction(){
		entityManager.getTransaction().begin();
	}
	
	private void closeTransaction(){
		entityManager.getTransaction().commit();
	}
	
}
