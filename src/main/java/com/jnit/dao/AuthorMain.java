package com.jnit.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jnit.config.HibernateUtil;
import com.jnit.entities.Courses;
import com.jnit.entities.Author;

/*
 * included HQL example
 * CURD operations for one-to-many
 */

public class AuthorMain {

	static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	static Session session = sessionFactory.openSession();
	static Transaction transaction = session.beginTransaction();

	public static void insertAuthorCourses() {

		Author a = new Author("App", "Bhimavarapu", LocalDate.of(1984, Month.SEPTEMBER, 19));
		a.getCourses().add(session.get(Courses.class, 1l));
		Courses c1 = new Courses("data types");
		Courses c2 = new Courses("Python");
		List<Courses> courses = new ArrayList<Courses>();
		courses.add(c1);
		courses.add(c2);
		a.setCourses(courses);
		session.save(a);
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

	public static void getAuthorData() {

		String hql = "select a.firstName,a.LastName,c.courseName from Author a "
				+ "join Courses c on a.authorId = c.authorId where a.authorId=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, 14L);
		List<Object[]> data = query.getResultList();
		for (Object[] ob : data) {
			System.out.println(ob[0]);
			System.out.println(ob[1]);
			System.out.println(ob[2]);
		}
		session.close();
		sessionFactory.close();

	}

	public static void updateAuthorCourses() {

		Author a = session.load(Author.class, 14l);
		a.setLastName("john");
		session.update(a);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	public static void deleteAuthorCourses() {

		Author a = session.load(Author.class, 14l);
		session.delete(a);
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

}
