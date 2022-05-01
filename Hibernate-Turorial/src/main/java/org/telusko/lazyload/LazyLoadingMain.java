package org.telusko.lazyload;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LazyLoadingMain {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Laptop.class)
				.addAnnotatedClass(OutputPort.class);

		Laptop laptop = new Laptop(1001, "T440");
		OutputPort outputPort1 = new OutputPort(1, "ethernet");
		OutputPort outputPort2 = new OutputPort(2, "USB");
		laptop.addOutputPort(outputPort1);
		laptop.addOutputPort(outputPort2);

		System.out.println("Inserting laptop and its two output ports into DB");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		session.save(laptop);

		tx.commit();
		System.out.println(
				"Closing the write session since, trying to get from the same session will not fire the select queries\n as per the session.get() specification");
		session.close();

		Session readSession = sessionFactory.openSession();

		Laptop l = readSession.get(Laptop.class, 1001);
		System.out.println();
		System.out
				.println("The log will not contain select statements for output ports ,LaptopId :" + l.getModelName());
		System.out.println("laptop.getOutputports() : Getting output ports from the laptop class....");

		List<OutputPort> outputports = l.getOutputports();
		System.out.println();
		outputports.stream().forEach(op -> System.out.println(+op.getPortId() + ":" + op.getPortName()));

		System.out.println("The log will notw have select statements for the OutputPort table");
		System.out.println("Hibernate is lazy load by default");
		readSession.close();

	}
}
