package com.tut.Caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.EmbedebleAnnotation.Student_embed;

public class FirstLevelCache {
public static void main(String[] args) {
	System.out.println("Program started...........");
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	// first level cache by default enable
	
	Session session = factory.openSession();
	
	Student_embed st =(Student_embed)session.get( Student_embed.class, 1011);
	System.out.println(st);
	System.out.println("Working Something .......");
	Student_embed st1 =(Student_embed)session.get( Student_embed.class, 1011);
	System.out.println(st1);
	boolean isPresent = session.contains(st1);
	System.out.println(isPresent);
	
	session.close();
	factory.close();
	
}
}
