package com.tut.ObjectStates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.EmbedebleAnnotation.Certificate;
import com.tut.EmbedebleAnnotation.Student_embed;
import com.tut.FetchingTechnique.Question_Fetch;

public class StateDemo {
public static void main(String[] args) {
	
	// Practical of Hibernate Object States
	
	// Transient state
	// Persistent State
	// Detached State
	// Removed State
	
	System.out.println("Example..........");
	SessionFactory factory  = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	// creating student-embed object
	Student_embed student = new Student_embed();
	student.setId(14141);
	student.setName("Peter");
	student.setCity("ABC");
	student .setCerti(new Certificate("Java Hibernate Course", "2 monrths"));
	
	//--> student --> transient
	
	Session session = factory.openSession();
	org.hibernate.Transaction tx = session.beginTransaction();
	 

    session.save(student);
	// --- student : persistent ---- session , database
	
    student.setName("John");
    
	tx.commit();
	

	session.close();
//	session.delete(student);
	
	
	// STUDENT ---	Detached State
	student.setName("SACHIN");
	factory.close();
	
}
}
