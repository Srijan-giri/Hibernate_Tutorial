package com.tut.ManyTomany;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
	SessionFactory factory  = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	Emp e1 = new Emp();
	Emp e2 = new Emp();
	
	e1.setEid(34);
	e1.setName("Ram");
	
	e2.setEid(35);
	e2.setName("Shyam");
	
	
	Project p1 = new Project();
	Project p2 = new Project();
	
	p1.setPid(121212);
	p1.setProjectName("Library Management System");
	
	p2.setPid(14241);
	p2.setProjectName("Chatbot");
	
	List<Emp> l1 = new ArrayList<>();
	List<Project> l2 = new ArrayList<>();
	
	l1.add(e1);
	l1.add(e2);
	
	
	
	l2.add(p1);
	l2.add(p2);
	
	
	e1.setProjects(l2);
	
	p2.setEmps(l1);
	
	Session session = factory.openSession();
	org.hibernate.Transaction tx = session.beginTransaction();
	 
    session.save(e1);
    session.save(e2);
    
    session.save(p1);
    session.save(p2);
	 
	 
	tx.commit();
	session.close();
	
	
	
}
}
