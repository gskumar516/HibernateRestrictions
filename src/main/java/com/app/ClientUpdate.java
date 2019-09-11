package com.app;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientUpdate {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();

		configuration.configure();

		SessionFactory sf = configuration.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("delete from com.app.Employee where empId=102");

		int i = query.executeUpdate();

		System.out.println(i);

		tx.commit();

		sf.close();

	}

}
