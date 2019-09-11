package com.app;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

public class ClientCriteria {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();

		configuration.configure();

		SessionFactory sf = configuration.buildSessionFactory();

		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(Employee.class);

		List<Employee> list = criteria.list();

		for (Employee employee : list) {

			System.out.println(employee);

		}

		System.out.println("==============");

		// two restrictions by using or method
		Criteria criteria2 = session.createCriteria(Employee.class);

		Criterion criterion = Restrictions.ne("empName", "C");
		Criterion criterion2 = Restrictions.eq("empId", 103);

		LogicalExpression expression = Restrictions.or(criterion, criterion2);

		criteria2.add(expression);

		List<Employee> list2 = criteria2.list();

		for (Employee string : list2) {

			System.out.println(string);
		}

		System.out.println("==============");

		// pagination
		criteria2.setFirstResult(0);
		criteria2.setMaxResults(5);

		List<Employee> list3 = criteria2.list();

		for (Employee employee : list3) {

			System.out.println(employee);
		}

		System.out.println("==============");

		// order like asc/desc
		criteria2.add(Restrictions.gt("empId", 100));
		// criteria2.addOrder((Order.asc("empId")));
		criteria2.addOrder((Order.desc("empId")));

		List<Employee> list4 = criteria2.list();

		for (Employee employee : list4) {

			System.out.println(employee);
		}

	}

}
