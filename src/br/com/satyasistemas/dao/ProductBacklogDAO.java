package br.com.satyasistemas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.satyasistemas.dao.entity.ProductBacklog;

public class ProductBacklogDAO implements DAO<ProductBacklog>{
	
	private EntityManager entityManager;
	
	public ProductBacklogDAO() {
		super();
		this.entityManager = DatabaseUtil.getEmf().createEntityManager();
	}

	@Override
	public void save(ProductBacklog backlog) {
		beginTransaction();
		
		if(backlog.getId() <= 0)
			entityManager.persist(backlog);
		else
			entityManager.merge(backlog);
		
		closeTransaction();
	}

	@Override
	public ProductBacklog findById(int id) {		
		return null;
	}
	
	@Override
	public void delete(ProductBacklog backlog) {
		beginTransaction();
		entityManager.remove(backlog);
		closeTransaction();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBacklog> list() {
		Query query = entityManager.createNamedQuery("findAll");
		return query.getResultList();
	}

	@Override
	public List<ProductBacklog> pageList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void beginTransaction(){
		entityManager.getTransaction().begin();
	}
	
	private void closeTransaction(){
		entityManager.getTransaction().commit();
	}
	
}
