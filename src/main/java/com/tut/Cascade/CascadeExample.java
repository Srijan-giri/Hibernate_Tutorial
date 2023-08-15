package com.tut.Cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.OneToMany.Answer_OneToMany;
import com.tut.OneToMany.Question_OneToMany;

public class CascadeExample {
	public static void main(String[] args) {
		System.out.println("Program started...........");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Question_OneToMany q1 = new Question_OneToMany();
		
		q1.setQuestion_id(5627);
		q1.setQuestion("What is Spring Framework ??");
		
		
		Answer_OneToMany a1 = new Answer_OneToMany(14232,"In hibernate it is a conceptual concept",q1);
		Answer_OneToMany a2 = new Answer_OneToMany(24232,"Second Answer",q1);
		Answer_OneToMany a3 = new Answer_OneToMany(34232,"Third Answer",q1);
		
		List<Answer_OneToMany> list  = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswers(list);
		
		Session session = factory.openSession();
		
        Transaction tx = session.beginTransaction();
		
		session.save(q1);
//		session.save(a1);
//		session.save(a2);
//		session.save(a3);
		
  		tx.commit();
		
	  session.close();
	  factory.close();
		
		
		
		
	}

}
