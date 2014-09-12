package br.com.satyasistemas.dao;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.satyasistemas.dao.entity.Impedimento;

public class ImpedimentoDAOTest {
		
	private static ImpedimentoDAO impedimentoDAO;

	@BeforeClass
	public static void tearDownAfterClass() throws Exception {
		impedimentoDAO = new ImpedimentoDAO();
	}
	
	@Test
	public void testSave() {
		Impedimento impedimento = new Impedimento();
		impedimento.setImpedimento("Teste");
		impedimento.setResponsavelPor("Tester");
		impedimento.setResponsavel("Product Owner");
		impedimento.setFinalizacao(new Date());
		impedimento.setCriacao(new Date());
		impedimento.setObservacao("Realização de testes");

		impedimentoDAO.save(impedimento);	
	}

	/*
	 * TODO: refazer o teste, recuperar um objeto para depois excluir.
	 * 
	 */
	@Test
	public void testDelete() {
		Impedimento impedimento = new Impedimento();
		impedimento.setImpedimento("Teste Deleção");
		impedimento.setResponsavelPor("Tester");
		impedimento.setResponsavel("Product Owner");
		impedimento.setFinalizacao(new Date());
		impedimento.setCriacao(new Date());
		impedimento.setObservacao("Realização de testes");

		impedimentoDAO.save(impedimento);	
		impedimentoDAO.delete(impedimento);
	}
}