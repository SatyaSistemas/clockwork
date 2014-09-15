package br.com.satyasistemas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.satyasistemas.dao.entity.Revisao;

public class RevisaoDAO implements DAO<Revisao>{
	
	private EntityManager entityManager;
	
	public RevisaoDAO() {
		super();
		this.entityManager = DatabaseUtil.getEmf().createEntityManager();
	}

	@Override
	public void save(Revisao revisao) {
		beginTransaction();
		
		if(revisao.getId() <= 0)
			entityManager.persist(revisao);
		else
			entityManager.merge(revisao);
		
		closeTransaction();
	}

	@Override
	public Revisao findById(int id) {		
		return null;
	}
	
	@Override
	public void delete(Revisao revisao) {
		beginTransaction();
		entityManager.remove(revisao);
		closeTransaction();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Revisao> list() {
		Query query = entityManager.createNamedQuery("Revisao.findAll");
		return query.getResultList();
	}

	@Override
	public List<Revisao> pageList() {
		return null;
	}
	
	private void beginTransaction(){
		entityManager.getTransaction().begin();
	}
	
	private void closeTransaction(){
		entityManager.getTransaction().commit();
	}
	
}
