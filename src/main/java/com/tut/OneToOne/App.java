package com.tut.OneToOne;

import org.hibernate.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		
		Question q1 = new Question();
		q1.setQuestionId(102);
		q1.setQuestion("What is Java");
		
		
		Answer a1 = new Answer();
		a1.setAnswerId(1010);
		a1.setAnswer("Java is OOP Language");
		
		q1.setAnswer(a1);
		a1.setqId(q1);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		
		session.save(q1);
		session.save(a1);		
		
		
		 tx.commit();
		 
		 // get the data 
		 
//		 Question q = (Question)session.get(Question.class, 101);
//     	 System.out.println(q);
//     	 
//     	 Answer a  = session.load(Answer.class, 109);
//     	 System.out.println(a.getAnswer());
//		 
		 
		 
		 System.out.println("Done.............");
		 
		 factory.close();
	}

}
