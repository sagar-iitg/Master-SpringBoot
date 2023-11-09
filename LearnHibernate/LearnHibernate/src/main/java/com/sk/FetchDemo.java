package com.sk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo 
{
	
	
	public static void main(String[] args) 
	{
		
		
		//get, load
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
        
		Session session=factory.openSession();
		
		
		//get-student
		//get and load both are same method almost
		Student s=session.get(Student.class, 2);
		Student s1=session.load(Student.class, 1);
		System.out.println(s.toString());
		System.out.println(s1.toString());
		Address a=session.load(Address.class,1);
		System.out.println(a.toString());
		
		
		
		
		session.close();
		factory.close();
		
	}

}
