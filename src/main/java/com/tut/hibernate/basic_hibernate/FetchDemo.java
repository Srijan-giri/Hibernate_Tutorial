package com.tut.hibernate.basic_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.annotations_hibernate.Address;

public class FetchDemo {
public static void main(String[] args) {
	// get // load
	
	
	System.out.println("Program started...........");
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	Session session = factory.openSession();
	
	// get- student:106
	
//	Student student = (Student)session.get(Student.class,101);
//	
//	Student student2 =(Student) session.load(Student.class, 102);
	
	
	
	
	
//	System.out.println(student);
//	System.out.println(student2);
	
	
	
	// Address
	
//	Address add =(Address) session.get(Address.class, 1);
//	System.out.println(add);
//	System.out.println(add.getCity());
	
	
	// test
	
//	Student student = (Student)session.get(Student.class, 101);
//	System.out.println(student);
//	Student student1 = (Student)session.get(Student.class, 101);
//	System.out.println(student1);
	
	
	// for load
	Student s1 = (Student)session.load(Student.class, 102);
	System.out.println(s1.getId()+":"+s1.getName()+":"+s1.getCity()); 
	Student s2 = (Student)session.load(Student.class, 101);
//	System.out.println(s2.getId()+":"+s2.getName());
	
	session.close();
}
}
