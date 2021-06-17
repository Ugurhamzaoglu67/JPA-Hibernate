package com.ugurhmz.petclinic.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.ugurhmz.petclinic.config.JpaConfig;

public class JpaTest {
	
	
	
	@Test
	public void testJpaSetup() {
		
		EntityManager entityManager = JpaConfig.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction(); 			//Persistence iþlemlerini gerçekleþtirmek için transaction lazým
		tx.begin();
		tx.commit();
		
		entityManager.close();
		
		JpaConfig.getEntityManagerFactory().close();
	
	}

}
