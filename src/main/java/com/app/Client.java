package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();

		configuration.configure();

		SessionFactory sf = configuration.buildSessionFactory();

		Session ses = sf.openSession();

		Transaction tx = ses.beginTransaction();

		Employee employee = new Employee(101, "A", 12000);
		Employee employee2 = new Employee(102, "B", 13000);
		Employee employee3 = new Employee(103, "C", 14000);
		Employee employee4 = new Employee(104, "D", 15000);

		ses.save(employee);
		ses.save(employee2);
		ses.save(employee3);
		ses.save(employee4);

		tx.commit();

		sf.close();

	}

}
