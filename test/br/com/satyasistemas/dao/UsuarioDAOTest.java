package br.com.satyasistemas.dao;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.satyasistemas.dao.entity.ProductBacklog;

public class UsuarioDAOTest {
		
	private static ProductBacklogDAO backlogDAO;

	@BeforeClass
	public static void tearDownAfterClass() throws Exception {
		backlogDAO = new ProductBacklogDAO();
	}
	
	@Test
	public void testSave() {
		ProductBacklog backlog = new ProductBacklog();
		backlog.setEstimativa(1);
		backlog.setDemonstracao("Apenas um teste");
		backlog.setImportancia(2);
		backlog.setNotas("Realizando teste no sistema");
		backlog.setSolicitante("Product Owner");

		backlogDAO.save(backlog);	
	}

	/*
	 * TODO: refazer o teste, recuperar um objeto para depois excluir.
	 * 
	 */
	@Test
	public void testDelete() {
		ProductBacklog backlog = new ProductBacklog();
		backlog.setEstimativa(1);
		backlog.setDemonstracao("Apenas um teste");
		backlog.setImportancia(2);
		backlog.setNotas("Realizando teste no sistema");
		backlog.setSolicitante("Product Owner");

		backlogDAO.save(backlog);	
		backlogDAO.delete(backlog);
	}
}