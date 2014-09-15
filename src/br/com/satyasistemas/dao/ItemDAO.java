package br.com.satyasistemas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.satyasistemas.dao.entity.Item;

public class ItemDAO implements DAO<Item>{
	
	private EntityManager entityManager;
	
	public ItemDAO() {
		super();
		this.entityManager = DatabaseUtil.getEmf().createEntityManager();
	}

	@Override
	public void save(Item item) {
		beginTransaction();
		
		if(item.getId() <= 0)
			entityManager.persist(item);
		else
			entityManager.merge(item);
		
		closeTransaction();
	}

	@Override
	public Item findById(int id) {		
		return null;
	}
	
	@Override
	public void delete(Item item) {
		beginTransaction();
		entityManager.remove(item);
		closeTransaction();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> list() {
		Query query = entityManager.createNamedQuery("Item.findAll");
		return query.getResultList();
	}

	@Override
	public List<Item> pageList() {
		return null;
	}
	
	private void beginTransaction(){
		entityManager.getTransaction().begin();
	}
	
	private void closeTransaction(){
		entityManager.getTransaction().commit();
	}
	
}
