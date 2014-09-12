package br.com.satyasistemas.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;

public class DatabaseUtilTest {

	@Test
	public void test() {
		EntityManager createEntityManager = DatabaseUtil.getEmf().createEntityManager();
		assertNotNull(createEntityManager);
	}

}
