package com.tut.Caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.EmbedebleAnnotation.Student_embed;

public class SecondLevelCache {

	public static void main(String[] args) {
		System.out.println("Program started...........");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// multiple session but query will run for one time
		Session s1 = factory.openSession();
		// first
		
		Student_embed st1 =(Student_embed)s1.get( Student_embed.class, 1012);
		System.out.println(st1);
		
		s1.close();
		
		Session s2 = factory.openSession();
		// second
		
		Student_embed st2 =(Student_embed)s2.get( Student_embed.class, 1012);
		System.out.println(st2);
		
		s2.close();
		
		factory.close();
	}

}
