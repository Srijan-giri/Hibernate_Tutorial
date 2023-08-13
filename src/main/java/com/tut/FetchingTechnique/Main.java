package com.tut.FetchingTechnique;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.ManyTomany.Emp;
import com.tut.ManyTomany.Project;

public class Main {
	public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		SessionFactory factory  = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Question_Fetch q = new Question_Fetch();
		q.setQid(101);
		q.setQues("What is Derby??");
		
		
		Answer_Fetch a1 = new Answer_Fetch();
		a1.setAid(1001);
		a1.setAnswers("MBSG VS EB");
		a1.setQuestion(q);
		
		Answer_Fetch a2 = new Answer_Fetch();
		a2.setAid(1002);
		a2.setAnswers("It is an emotion");
		a2.setQuestion(q);
		
		Answer_Fetch a3 = new Answer_Fetch();
		a3.setAid(1003);
		a3.setAnswers("Saltlake Stadium");
		a3.setQuestion(q);
		
		List<Answer_Fetch> l = new ArrayList<>();
		l.add(a1);
		l.add(a2);
		l.add(a3);
		
		q.setAnswers(l);
		
		
		
		
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		 
	    session.save(q);
	    session.save(a1);
	    session.save(a2);
	    session.save(a3);
	    
		
		
		tx.commit();
		
		// fetching
		
		Question_Fetch ques = (Question_Fetch)session.get(Question_Fetch.class, 101);
		System.out.println(ques.getQid());
		System.out.println(ques.getQues());
		System.out.println(ques.getAnswers().size());
		session.close();
		
		
		
	}
}
