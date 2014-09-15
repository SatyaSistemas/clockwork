package br.com.satyasistemas.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.satyasistemas.dao.entity.Impedimento;

public class ImpedimentoDAO implements DAO<Impedimento>,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager entityManager;
	
	public ImpedimentoDAO() {
		super();
		this.entityManager = DatabaseUtil.getEmf().createEntityManager();
	}

	@Override
	public void save(Impedimento impedimento) {
		beginTransaction();
		
		if(impedimento.getId() <= 0)
			entityManager.persist(impedimento);
		else
			entityManager.merge(impedimento);
		
		closeTransaction();
	}

	@Override
	public Impedimento findById(int id) {		
		return null;
	}
	
	@Override
	public void delete(Impedimento impedimento) {
		beginTransaction();
		entityManager.remove(impedimento);
		closeTransaction();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Impedimento> list() {
		Query query = entityManager.createNamedQuery("Impedimento.findAll");
		return query.getResultList();
	}

	@Override
	public List<Impedimento> pageList() {
		return null;
	}
	
	private void beginTransaction(){
		entityManager.getTransaction().begin();
	}
	
	private void closeTransaction(){
		entityManager.getTransaction().commit();
	}
	
}
