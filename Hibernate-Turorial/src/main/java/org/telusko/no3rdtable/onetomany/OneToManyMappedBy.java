package org.telusko.no3rdtable.onetomany;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyMappedBy {

	public static void main(String[] args) {
		TblCar c = new TblCar("KA028765", "RED");
		TblCar c2 = new TblCar("MH041234", "BLUE");
		TblCarOwner co = new TblCarOwner("123", "AmitabhBachhan");
		c.setOwner(co);
		c2.setOwner(co);
		co.getOwnedCars().add(c2);
		co.getOwnedCars().add(c);
		
		
		TblCarOwner nandan = new TblCarOwner("111", "Abhinandan");
		TblCar bmw = new TblCar("KA03QWER", "RED");
		TblCar audi = new TblCar("GA025544", "SILVER");
		
		bmw.setOwner(nandan);
		audi.setOwner(nandan);
		nandan.setOwnedCars(Arrays.asList(bmw,audi));
		Configuration cfg = new Configuration().configure().addAnnotatedClass(TblCar.class)
				.addAnnotatedClass(TblCarOwner.class);

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		

		session.save(co);
		session.save(nandan);
		//session.save(c);
		//session.save(c2);
		tx.commit();
		
	}

}
