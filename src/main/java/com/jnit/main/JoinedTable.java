package com.jnit.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jnit.config.HibernateUtil;
import com.jnit.joined.FourW;
import com.jnit.joined.TwoW;
import com.jnit.joined.Veh;

/*
 * JoinedTable 
 */
public class JoinedTable {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Veh vehicle = new Veh();
		vehicle.setVehicleName("van");

		TwoW twoWheeler = new TwoW();
		twoWheeler.setVehicleName("bicycle");
		twoWheeler.setSteeringTwoWheeler("bicycle Steering Handle");

		FourW fourWheeler = new FourW();
		fourWheeler.setVehicleName("Alto");
		fourWheeler.setSteeringFourWheeler("Alto Steering Wheel");

		session.save(vehicle);
		session.save(twoWheeler);
		session.save(fourWheeler);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

	}
}
