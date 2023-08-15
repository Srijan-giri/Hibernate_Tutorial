package com.tut.hql;

import org.hibernate.query.*;
import java.util.*;
import com.tut.EmbedebleAnnotation.Student_embed;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLPegination {

	public static void main(String[] args) {
		System.out.println("Program started...........");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		int pageNumber = 1001;
		int pageSize = 10;
		int firstResult = (pageNumber - 1) * pageSize;
		
		String hql = "FROM Student_embed";
		Query q = session.createQuery(hql);
		
//		Query<Student_embed> q = session.createQuery("from Student_embed",Student_embed.class);
		
		// implementing pagination using hibernate
		System.out.println(q);
		
		q.setFirstResult(pageNumber);
		q.setMaxResults(firstResult);
		
		List<Student_embed> list = q.list();
		
		System.out.println(list);
		for(Student_embed s : list)
		{
//			System.out.println(s.getId()+" : "+s.getName()+" : "+s.getCity()+" : "+s.getCerti());
			System.out.println(s.getName());
		}
		
		session.close();
		factory.close();
		
		
}
}
