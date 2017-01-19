package com.jnit.dao;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.jnit.entities.Student;
import com.jnit.config.HibernateUtil;
import com.jnit.entities.Address1;

/*
 * CURD operations for one-to-one
 * Criteria API
 * Named Queries
 */

public class StudentMain {

	public static List<Student> getStudentData() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Student> students = new ArrayList<Student>();
		Student std = session.get(Student.class, 2);
		students.add(std);
		transaction.commit();
		session.close();
		sessionFactory.close();
		return students;

	}

	public static void getStudentDataByFirstLetter(String name) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.like("name", name));
		List<Student> students = criteria.list();
		System.out.println(students.size());
		session.close();
		sessionFactory.close();

	}

	public static void getStudentDataByName(String name) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query hql = session.createNamedQuery("studentByName");
		hql.setParameter(1, name);
		List<Student> students = hql.getResultList();
		System.out.println(students.size());
		session.close();
		sessionFactory.close();
	}

	public static void insertStudentAddress() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Student std = new Student("sri", "latha", "reddy");
		Address1 add = new Address1("fremont", "sfo", "CA", "USA", "94538");
		std.setAddress(add);
		add.setStudent(std);
		session.save(std);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	public static void updateStudent() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Student std = session.get(Student.class, 2);
		std.setName("sriUpdate");
		session.update(std);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	public static void deleteStudent() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Student std = session.get(Student.class, 1);
		session.delete(std);
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

}
