package br.com.satyasistemas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.satyasistemas.dao.entity.Usuario;

public class UsuarioDAO implements DAO<Usuario>{
	
	private EntityManager entityManager;
	
	public UsuarioDAO() {
		super();
		this.entityManager = DatabaseUtil.getEmf().createEntityManager();
	}

	@Override
	public void save(Usuario usuario) {
		beginTransaction();
		
		if(usuario.getId() <= 0)
			entityManager.persist(usuario);
		else
			entityManager.merge(usuario);
		
		closeTransaction();
	}

	@Override
	public Usuario findById(int id) {		
		return null;
	}
	
	@Override
	public void delete(Usuario usuario) {
		beginTransaction();
		entityManager.remove(usuario);
		closeTransaction();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> list() {
		Query query = entityManager.createNamedQuery("findAllUsuario");
		return query.getResultList();
	}

	@Override
	public List<Usuario> pageList() {
		return null;
	}
	
	private void beginTransaction(){
		entityManager.getTransaction().begin();
	}
	
	private void closeTransaction(){
		entityManager.getTransaction().commit();
	}
	
}
