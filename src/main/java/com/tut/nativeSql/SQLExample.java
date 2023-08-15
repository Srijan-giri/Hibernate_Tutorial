package com.tut.nativeSql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import java.util.*;

import com.tut.EmbedebleAnnotation.Student_embed;

public class SQLExample {
	public static void main(String[] args) {
		System.out.println("Program started...........");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
		Session session = factory.openSession();
		
		// sql query
		String q = "select * from student_embed";
		
		NativeQuery nq=session.createSQLQuery(q);
		
	    List<Object []> list = nq.list();
	    
	    for(Object[] s : list)
	    {
			//	 System.out.println(Arrays.toString(s));
	    	System.out.println(s[1]+" : "+s[4]);
	    }
		
		
		session.close();
		factory.close();
	}

}
