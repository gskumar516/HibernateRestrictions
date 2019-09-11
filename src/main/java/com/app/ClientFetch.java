package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientFetch {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();

		configuration.configure();

		SessionFactory sf = configuration.buildSessionFactory();

		Session ses = sf.openSession();

		Object object = ses.get(Employee.class, 101);

		Employee employee = (Employee) object;

		System.out.println(employee);
	}

}
