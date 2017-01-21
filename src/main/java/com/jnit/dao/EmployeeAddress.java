package com.jnit.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.jnit.config.HibernateUtil;
import com.jnit.entities.Address;
import com.jnit.entities.Employee;

/*
 * CURD operations for one-to-one
 * Criteria API
 * Named Queries
 */
public class EmployeeAddress {

	public static List<Employee> getEmployeeData() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Employee> employees = new ArrayList<Employee>();
		Employee emp = session.get(Employee.class, 2);
		employees.add(emp);
		transaction.commit();
		session.close();
		sessionFactory.close();
		return employees;

	}

	public static void getEmployeeDataByFirstLetter(String name) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.like("name", name));
		List<Employee> employees = criteria.list();
		System.out.println(employees.size());
		session.close();
		sessionFactory.close();

	}

	public static void getEmployeeDataByName(String name) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query hql = session.createNamedQuery("employeeByfName");
		hql.setParameter(1, name);
		List<Employee> employees = hql.getResultList();
		System.out.println(employees.size());
		session.close();
		sessionFactory.close();
	}

	public static void insertEmployeeAddress() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee emp = new Employee("sri", "reddy", "usike");
		Address add = new Address();
		add.setCity("fremont");
		add.setState("CA");
		emp.setAddress(add);
		add.setEmployee(emp);
		session.save(emp);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	public static void updateEmployee() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee emp = session.get(Employee.class, 2);
		emp.setfName("sriUpdate");
		session.update(emp);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	public static void deleteEmployee() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee emp = session.get(Employee.class, 1);
		session.delete(emp);
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

}
