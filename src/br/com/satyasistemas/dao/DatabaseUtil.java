package br.com.satyasistemas.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Utility class with database related methods.
 * @author Fernando Augusto Fernandes Braz
 */
public class DatabaseUtil {
	
    private static EntityManagerFactory emf;
    
    public static final String DEFAULT_UNIT_NAME = "ClockworkPU";
    
    public static EntityManagerFactory getEmf() {
    	if (emf == null || !emf.isOpen()) {
    		emf = Persistence.createEntityManagerFactory(DatabaseUtil.DEFAULT_UNIT_NAME);
    	}
		return emf;
	}   
	
}