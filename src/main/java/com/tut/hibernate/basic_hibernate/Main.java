package com.tut.hibernate.basic_hibernate;

import org.hibernate.Transaction;
//import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args){
		 System.out.println( "Programme started.........." );
	     SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	        
	     System.out.println(factory);
	     System.out.println(factory.isClosed());
		
		// Creating student
		
		 Student st = new Student();
		 st.setId(101);
		 st.setName("Durga");
		 st.setCity("Chennai");
		
		 System.out.println(st);
		
		
        
         Session session = factory.openSession();
        
         Transaction tx = session.beginTransaction();
        
         session.save(st);
//        session.save(ad);
        
         tx.commit();
        
         session.close();
         System.out.println("Done.......");
		
	
		
		
		
		
		
		
		
//		System.out.println(factory);
//		System.out.println(factory.isClosed());
	}

}
