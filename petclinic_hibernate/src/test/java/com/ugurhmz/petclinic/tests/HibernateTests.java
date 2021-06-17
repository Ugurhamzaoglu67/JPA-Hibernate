package com.ugurhmz.petclinic.tests;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.ugurhmz.petclinic.config.HibernateConfig;

public class HibernateTests {
	@Test
	public void testHibernateSetup() {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();
		HibernateConfig.getSessionFactory().close();
	}
}