package com.tut.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.EmbedebleAnnotation.Student_embed;
import com.tut.FetchingTechnique.Answer_Fetch;
import com.tut.FetchingTechnique.Question_Fetch;

public class HQLExample {
  public static void main(String[] args) {
	System.out.println("Program started...........");
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = factory.openSession();
	
	
	// HQL 
	// Syntax
	
	
	// Select
	
	String query  =  "from Answer_Fetch where question_qid=101";
//	String query1 = "from Student_embed where city='Kolkata'";
	String query1 = "from Student_embed  as s where s.city=:x  and  s.name=:n";
	
	
	
	
	Query q = session.createQuery(query);
	Query q1 = session.createQuery(query1);
	
	
	q1.setParameter("x","Kanpur");
	q1.setParameter("n","Ankit Tiwary");
	
	
	// single
//   q.uniqueResult();
	// multiple - list
	
//	List<Answer_Fetch> list = q.list();
//	
//	for(Answer_Fetch s : list)
//	{
//		System.out.println(s.getAnswers());
//	}
//	
//	List<Student_embed> l2 = q1.list();
//	
//	for(Student_embed s1 : l2)
//	{
//		System.out.println(s1);
//	}
	
	System.out.println("+++++++++++++++++++++++++++++++++");
	
	// delete 
	// update 
	// join  
	
	

	
	Transaction tx = session.beginTransaction();
	
	// 1. delete
//	Query delq = session.createQuery("delete from Student_embed as s where s.city = :c");
//	
//	delq.setParameter("c", "indore");
//	
//	int r = delq.executeUpdate();
//	
//	System.out.println("Deleted");
//	System.out.println(r);
	
	
	
	// 2. Update
	
//	Query upq= session .createQuery("update Student_embed set duration=:d where id=:i");
//	
//	upq.setParameter("d", "3 months");
//	upq.setParameter("i", 1004);
//	
//	int r = upq.executeUpdate();
//	
//	System.out.println("Updated ..");
//	System.out.println(r+"Objects updated");
	
	

	tx.commit();
	//3. how to execute join queries
	
	
	Query joinq = session.createQuery("select q.question_id,q.question,a.answer from Question_OneToMany as q INNER JOIN q.answers as a");
	
	
	List<Object []> list = joinq.getResultList();
	
	for(Object [] arr :list)
	{
		System.out.println(Arrays.toString(arr));
	}
	
	session.close();
	
	
    factory.close();
	
}
}
