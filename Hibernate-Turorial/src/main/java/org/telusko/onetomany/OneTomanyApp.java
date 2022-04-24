package org.telusko.onetomany;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneTomanyApp {

	public static void main(String[] args) {
		
		Car c = new Car("KA028765", "RED");
		Car c2 = new Car("MH041234", "BLUE");
		CarOwner co = new CarOwner("123", "AmitabhBachhan", Arrays.asList(c,c2));
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Car.class)
				.addAnnotatedClass(CarOwner.class);

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		session.save(co);
		tx.commit();
		
		
	}
}
