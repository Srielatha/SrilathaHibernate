package com.jnit.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jnit.entities.Course;

import com.jnit.entities.SkillLevel;
import com.jnit.entities.User;
import com.jnit.config.HibernateUtil;

/*
 * CURD operations for many-to-many
 */
public class UserCourse {

	public static void insertUserCourse() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Course c1 = new Course("Java - I", "Mike", SkillLevel.BEGINNER, "Intro to java", null, new BigDecimal(0.0),
				"gets understanding of java", "free");
		List<User> users = new ArrayList<User>();
		User user1 = new User("u.srilatha666@gmail.com", "siri", "usike", "R", "oct27",
				LocalDate.of(1991, Month.OCTOBER, 17), "816-633-2244");
		users.add(user1);
		User user2 = new User("srilathareddy678.u@gmail.com", "srilatha", "baddam", "R", "feb01",
				LocalDate.of(1992, Month.FEBRUARY, 01), "816-653-0302");
		users.add(user2);
		c1.setRegisteredUsers(users);
		session.save(c1);
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

	public static List<User> getUserDate() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<User> users = new ArrayList<User>();
		User user = session.get(User.class, 5L);
		users.add(user);
		transaction.commit();
		session.close();
		sessionFactory.close();
		return users;

	}

	public static List<Course> getCouserData() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Course> courses = new ArrayList<Course>();
		Course course = session.get(Course.class, 14L);
		courses.add(course);
		transaction.commit();
		session.close();
		sessionFactory.close();
		return courses;

	}

	public static void updateUsers() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		User user = session.get(User.class, 12L);
		user.setfName("updatednew");
		session.update(user);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	public static void deleteUsers() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Course course = session.get(Course.class, 12L);
		User user = session.get(User.class, 13L);
		course.getRegisteredUsers().remove(user);
		session.save(course);
		session.delete(user);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
