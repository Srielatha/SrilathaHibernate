package com.jnit.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jnit.config.HibernateUtil;
import com.jnit.entities.Classes;
import com.jnit.entities.SkillLevel;
import com.jnit.entities.Professor;
/*
 * CURD operations for many-to-many
 */

public class ProfessorMain {

	public static void insertProfessorClasses() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Professor prof = new Professor(1, "siri", "cs", SkillLevel.BEGINNER, "Intro to java", null, new BigDecimal(0.0),
				"gets understanding of java", "free");
		List<Classes> classes = new ArrayList<Classes>();
		Classes classes1 = new Classes(1, "siri", 25, LocalDate.of(1991, Month.OCTOBER, 17));
		session.save(classes1);
		classes.add(classes1);
		Classes classes2 = new Classes(1, "siri", 25, LocalDate.of(1991, Month.OCTOBER, 17));
		classes.add(classes2);
		classes1.setRegisteredUsers(classes);
		session.save(classes1);
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

	public static List<Classes> getClassesData() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Classes> classes = new ArrayList<Classes>();
		Classes registeredusers = session.get(Classes.class, 14L);
		classes.add(registeredusers);
		transaction.commit();
		session.close();
		sessionFactory.close();
		return classes;

	}

	public static List<Professor> getProfessorData() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Professor> professor = new ArrayList<Professor>();
		Professor prof = session.get(Professor.class, 14L);
		professor.add(prof);
		transaction.commit();
		session.close();
		sessionFactory.close();
		return professor;

	}

	public static void updateClasses() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Classes classes = session.get(Classes.class, 12L);
		classes.setCoursename("updatednew");
		session.update(classes);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	public static void deleteClasses() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Professor prof = session.get(Professor.class, 12L);
		Classes classes = session.get(Classes.class, 13L);
		prof.getRegisteredUsers().remove(classes);
		session.save(prof);
		session.delete(classes);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
