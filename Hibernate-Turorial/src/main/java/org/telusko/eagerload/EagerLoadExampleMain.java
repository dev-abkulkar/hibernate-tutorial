package org.telusko.eagerload;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EagerLoadExampleMain {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Laptop.class)
				.addAnnotatedClass(OutputPort.class);

		Laptop laptop = new Laptop(2222, "ACER-HELIOS");
		OutputPort outputPort1 = new OutputPort(101, "H-ethernet");
		OutputPort outputPort2 = new OutputPort(202, "H-USB");
		laptop.addOutputPort(outputPort1);
		laptop.addOutputPort(outputPort2);

		System.out.println("Inserting laptop and its two output ports into DB");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		session.save(laptop);

		tx.commit();
		System.out.println(
				"Closing the write session since, trying to get from the same session will not fire the select queries as per the session.get() specification");

		session.close();
		System.out.println();
		Session readSession = sessionFactory.openSession();

		Laptop l = readSession.get(Laptop.class, 2222);
		System.out.println();
		System.out
				.println("The log will not contain select statements for output ports since it is eager loaded ,LaptopId :" + l.getModelName());
		System.out.println("laptop.getOutputports() : Getting output ports from the laptop class....");

		List<OutputPort> outputports = l.getOutputports();
		System.out.println();
		outputports.stream().forEach(op -> System.out.println(+op.getPortId() + ":" + op.getPortName()));

		System.out.println("Hibernate is lazy load by default");
		readSession.close();

	}
}
