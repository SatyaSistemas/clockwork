package br.com.satyasistemas.dao;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
		if (impedimento.getImpedimento() == null
				|| impedimento.getReportado() == null
				|| impedimento.getFinalizacao()
						.before(impedimento.getCriacao())
				|| impedimento.getFinalizacao() == null
				|| impedimento.getCriacao() == null) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erro ao cadastrar",
							"Dados inválidos, favor verificar os campos"));
		} else {
			beginTransaction();
			if (impedimento.getId() <= 0)
				entityManager.persist(impedimento);
			else
				entityManager.merge(impedimento);
			closeTransaction();
		}
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

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
}
