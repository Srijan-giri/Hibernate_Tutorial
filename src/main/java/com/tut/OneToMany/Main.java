package com.tut.OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		System.out.println("Program started...........");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		
		Question_OneToMany q = new Question_OneToMany();
		q.setQuestion("What is Java ???? ");
		
		
		Answer_OneToMany a = new Answer_OneToMany();
		a.setAnswer("Java is a programming language");
		a.setQuestion(q);
		
		
		Answer_OneToMany a1 = new Answer_OneToMany();
		a1.setAnswer("With the help of java we can create softwares");
		a1.setQuestion(q);
		
		Answer_OneToMany a2 = new Answer_OneToMany();
		a1.setAnswer("Java has different types of frameworks");
		a1.setQuestion(q);
		
		List<Answer_OneToMany> list = new ArrayList<Answer_OneToMany>();
		list.add(a);
		list.add(a1);
		list.add(a2);
		
		q.setAnswers(list);
		
		Session session = factory.openSession();
		
     	Transaction tx = session.beginTransaction();
		
//		session.save(q);
//		session.save(a);
//		session.save(a1);
//		session.save(a2);
		
  		tx.commit();
		
		// fetching
		
	   Question_OneToMany ques = (Question_OneToMany)session.get(Question_OneToMany.class, 1);
	   System.out.println(ques.getQuestion_id()+" : "+ques.getQuestion());
	   System.out.println(ques.getAnswers().size());
	  
	   
		session.close();
		factory.close();
		
		
	}
}
