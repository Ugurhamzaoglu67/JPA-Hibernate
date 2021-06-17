package com.ugurhmz.petclinic.tests;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.ugurhmz.petclinic.config.HibernateConfig;
import com.ugurhmz.petclinic.model.MyPet;

public class HibernateTests {
	
	
	
	@Test
	public void testHibernateSetup() {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();
		HibernateConfig.getSessionFactory().close();
	}
	
	 @Test
	public void testCreateEntity() {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		MyPet myPet = new MyPet();
		myPet.setId(1L);			//ids for this class must be manually hatasý çözümü!
		
		myPet.setPetName("Sarman");
		session.persist(myPet);
		
		tx.commit();
		session.close();
		
	}
	 
	 
	 @Test
	 public void testFieldLevelAccess() {
		 Session session = HibernateConfig.getSessionFactory().openSession();
		 Transaction tx = session.beginTransaction();
		 
		 MyPet myPet = new MyPet("Sarman",new Date()); 
		 myPet.setId(1L);
		 
		 session.persist(myPet);
		 
		 tx.commit();
		 session.close();
		 
		 //select
		 
		 session = HibernateConfig.getSessionFactory().openSession();
		 
		 MyPet myPet2 = session.get(MyPet.class, 1L);
		 System.out.println(myPet);
		
	 }
	
}












