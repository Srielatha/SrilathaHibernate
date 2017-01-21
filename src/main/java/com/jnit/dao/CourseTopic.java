package com.jnit.dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jnit.entities.Course;
import com.jnit.entities.SkillLevel;
import com.jnit.entities.Topic;
import com.jnit.entities.User;
import com.jnit.config.HibernateUtil;

/*
 * included HQL example
 * CURD operations for one-to-many
 */
public class CourseTopic {

	static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	static Session session = sessionFactory.openSession();
	static Transaction transaction = session.beginTransaction();

	public static void insertCourseTopics() {

		Course c = new Course("Java", "mike", SkillLevel.BEGINNER, "Intro to java", null, new BigDecimal(0.0),
				"gets understanding of java", "free");
		c.getRegisteredUsers().add(session.get(User.class, 1l));
		Topic topic1 = new Topic("SQL", "20", c);
		Topic topic2 = new Topic("Python", "30", c);
		List<Topic> topics = new ArrayList<Topic>();
		topics.add(topic1);
		topics.add(topic2);
		c.setTopics(topics);
		session.save(c);
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

	public static void getCouserData() {

		String hql = "select c.name,t.name,t.duration from Course c "
				+ "join Topic t on c.courseId = t.course.courseId where c.courseId=?";
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

	public static void updateCourseTopics() {

		Course c = session.load(Course.class, 14l);
		c.setAuthor("abcNew");
		session.update(c);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	public static void deleteCourseTopics() {

		Course c = session.load(Course.class, 14l);
		session.delete(c);
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

}
