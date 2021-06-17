package com.ugurhmz.petclinic.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaConfig {
	
	private static EntityManagerFactory entityManagerFactory;
	
	
	
	// GETTER
	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
	
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("test");
	}
	
}
