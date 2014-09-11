package br.com.satyasistemas.dao;

import javax.persistence.EntityManager;

public class BackLogDAO {
	
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
		entityManager = DatabaseUtil.getEmf().createEntityManager();
		entityManager.createNativeQuery("select * from pessoa");
	}
}
