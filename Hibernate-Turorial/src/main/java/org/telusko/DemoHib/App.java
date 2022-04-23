package org.telusko.DemoHib;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Alien a = new Alien(100,new AlienName("abhi","m","kulkarni"),"red");
        
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Alien.class);
        
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        Transaction tx = session.beginTransaction();
        session.save(a);
        System.out.println(a);
        tx.commit();
    }
}
