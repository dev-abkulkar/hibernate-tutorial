package org.telusko.firsttlevelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FirstLevelCacheSingleSession {

	/**
	 * This example demonstrates first level caching.
	 * First we insert 1 row  into the employee table.
	 * Then we get that employee with the same session that we used to insert the employee.
	 * Since the employee is saved as part of hibernate's first level cache we will not see the SELECT EMPLOYEE being fired.
	 * This means that hibernate is fetching the employee object from the cache rather than from the table again
	 * @param args
	 */
	public static void main(String[] args) {
		Employee emp = new Employee("AK420", "AmitabhBachan");
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		System.out.println("Saving the employee....");
		session.save(emp);

		
		
		tx.commit();
		System.out.println();
		System.out.println("Getting the employee 'AK420'....");
		Employee employee = session.get(Employee.class, "AK420");
		
		session.close();
		System.out.println();
		System.out.println("We dont see the SELECT query for EMPLOYEE \n "
				+ "as AK420 is saved in the cache \n when we ran the insert query");
		System.out.println("Employee name : "+ employee.getName());
		
		
		
		
		

	}

}
