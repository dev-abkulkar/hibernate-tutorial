package org.telusko.onetoone;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneApp {

	public static void main(String[] args) {

		List<Employee> emps = createEmployees();

		Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Laptop.class);

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		for (Employee employee : emps) {
			session.save(employee);
		}

		tx.commit();
		Employee employee = session.get(Employee.class, 1);
		System.out.println("Employee: "+employee);

	}

	static List<Employee> createEmployees() {
		return Arrays.asList(new Employee("Abhi", 36, new Laptop("THinkpad t490")),
				new Employee("Nandan", 25, new Laptop("THinkpad T440")));
	}

}
