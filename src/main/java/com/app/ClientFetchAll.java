package com.app;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientFetchAll {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();

		configuration.configure();

		SessionFactory sf = configuration.buildSessionFactory();

		Session ses = sf.openSession();

		// Query query = ses.createQuery("from com.app.Employee");
		Query query = ses.createQuery("select empName,empId from com.app.Employee");

		/*
		 * List<Employee> list = query.list();
		 * 
		 * for (Employee employee : list) {
		 * 
		 * System.out.println(employee); }
		 */

		List<Object[]> list = query.list();

		for (Object[] string : list) {

			System.out.print(string[0] + "   ");
			System.out.println(string[1]);
		}

	}

}
