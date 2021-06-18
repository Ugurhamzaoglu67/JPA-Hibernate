package com.ugurhmz.petclinic.tests;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.ugurhmz.petclinic.config.HibernateConfig;
import com.ugurhmz.petclinic.model.MyPet;
import com.ugurhmz.petclinic.model.Owner;
import com.ugurhmz.petclinic.model.Owner.OwnerId;

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
		//myPet.setId(1L);			//ids for this class must be manually hatasý çözümü!  -> GeneratedValue kullarnýsan bunu yorumal.
		
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
	 
	 
	 
	 @Test
	 public void testWithoutTX() {
		 Session session = HibernateConfig.getSessionFactory().openSession();
		 Transaction tx = session.getTransaction();
		 tx.begin();
		 
		 MyPet myPet = new MyPet("Sarman",new Date());
		 myPet.setId(1L);
		 session.persist(myPet);
		 
		// session.flush();
		 tx.commit();
		 session.close();
	 }
	 
	 
	 @Test
	 public void testCheckNullability() {
		 Session session = HibernateConfig.getSessionFactory().openSession();
		 Transaction tx = session.getTransaction();
		 tx.begin();
		 
		 MyPet myPet = new MyPet();
		 myPet.setId(1L);
		 session.persist(myPet);
		 
		 tx.commit();
		 session.close();
		
	 }
	 
	 
	 @Test
	 public void testCompositePK() {
		 Owner owner = new Owner();			
		 
		 OwnerId id = new OwnerId();
		 id.setFirstName("Ugur");
		 id.setLastName("Hmz");
		 
		 owner.setId(id);
		 
		 Session session = HibernateConfig.getSessionFactory().openSession();
		 Transaction tx = session.getTransaction();
		 
		 tx.begin();
		 session.persist(owner);
		 
		 tx.commit();
		 session.close();
		 
	 }
	 
	
}












