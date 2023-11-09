package com.sk;



import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;





public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Statrted" );
        
        //SessionFactory factory=new Configuration().configure().buildSessionFactory();
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory f=cfg.buildSessionFactory();
        
        
        //create Student
        Student st=new Student(1,"sagar kumar","Giridih");
        Student st1=new Student();
        Student st2=new  Student();
        st2.setId(3);
        st2.setCity("Muzzafarpur");
        st2.setName("Ankit kumar");
        st1.setId(2);
        st1.setCity("Belda");
        st1.setName("Mohit agarwala");
        
        
        //creating object of address class
        Address address=new Address();
        address.setStreet("Manihari Patti");
        address.setCity("Giridih");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(1234.440);
        
        //ReadingImage
//        FileInputStream fis=new FileInputStream("src/main/java/pic.jpg");
//        byte[] data=new byte[fis.available()];
//        fis.read(data);
//        address.setImage(data);
        
        
        Session session=f.openSession();
        
        Transaction tx=session.beginTransaction();
        session.save(st1);
        session.save(st2);
        session.save(st);
        session.save(address);
        tx.commit();
        
        session.close();
        System.out.println("Project Done");
        
        
//        System.out.println(f.toString());
//        System.out.println(f.isOpen());
//        
//        System.out.println(f.isClosed());
        
    }
}
