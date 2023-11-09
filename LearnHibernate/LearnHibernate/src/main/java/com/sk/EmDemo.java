package com.sk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	
	
	public static void main(String[] args) {
		
		
		  Configuration cfg=new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        SessionFactory f=cfg.buildSessionFactory();
	        
	        Student s=new Student();
	        s.setId(100);
	        s.setCity("Chennai");
	        s.setName("Dhoni");
	        
	        Certificate c=new Certificate();
	        c.setCourse("Web Development");
	        c.setDuration("3 months");
	        s.setCerti(c);
	        
	        Student s1=new Student();
	        s1.setId(1001);
	        s1.setCity("Ranchi");
	        s1.setName("Mahendra");
	        
	        Certificate c1=new Certificate();
	        c1.setCourse("Android");
	        c1.setDuration("6 months");
	        s1.setCerti(c1);
	        
	        Session session=f.openSession();
	        
	        Transaction tx=session.beginTransaction();
	        
	        
	        //objects save
	        
	        session.save(s);
	        session.save(s1);
	        
	        tx.commit();
	        session.close();
	        f.close();
	}
}
