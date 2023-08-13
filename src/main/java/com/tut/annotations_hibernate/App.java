package com.tut.annotations_hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
public static void main(String[] args) throws IOException{
	System.out.println("Program started...........");
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	System.out.println(factory);
	System.out.println(factory.isClosed());
	
	// create an object of address class
	Address address = new Address();
	
	address.setStreet("street 1");
	address.setCity("Delhi");
	address.setOpen(true);
	address.setAddedDate(new Date());
	address.setX(1234.1234);
	
	
	
	//Read image 
	FileInputStream fis = new FileInputStream("src/main/java/pokemon.png");
	byte[] data = new byte[fis.available()];
	fis.read(data);
	address.setImage(data);
	
	
	
	
	Session session = factory.openSession();
	
	Transaction tx = session.beginTransaction();
	
	session.save(address);
	
	tx.commit();
	
	session.close();
	System.out.println("Done....");
}
}
