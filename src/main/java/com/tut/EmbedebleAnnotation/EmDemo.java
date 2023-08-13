package com.tut.EmbedebleAnnotation;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class EmDemo {
public static void main(String[] args) {
	SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	Student_embed st = new Student_embed();
    st.setId(1001);
    st.setName("Ankit Tiwary");
    st.setCity("Kanpur");
    
    
    Certificate certi = new Certificate();
    certi.setCourse("Android Course");
    certi.setDuration("6 months");
    
    
    st.setCerti(certi);
    
    Student_embed st1 = new Student_embed();
    st1.setId(1002);
    st1.setName("Srijan Giri");
    st1.setCity("Kolkata");

    st1.setCerti(new Certificate("Hibernate Course","2 months"));
    
    Student_embed st2 = new Student_embed();
    st2.setId(1003);
    st2.setName("Priyam Nag");
    st2.setCity("Indore");

    st2.setCerti(new Certificate("Python Course","2 months"));
    
    Student_embed st3 = new Student_embed();
    st3.setId(1004);
    st3.setName("Akash Pal");
    st3.setCity("Kolkata");

    st3.setCerti(new Certificate("Java Course","2 months"));
	  
	Session session = sf.openSession();
    
	Transaction tx = session.beginTransaction();
    
//    session.save(st);
//    session.save(st1);
	 session.save(st2);
	 session.save(st3);
    
    tx.commit();
	
	
    session.close();
    System.out.println("Done.......");
}
}
