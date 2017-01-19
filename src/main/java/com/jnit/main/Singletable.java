package com.jnit.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.singleTable.Vehicle;
import com.singleTable.TwoWheeler;
import com.singleTable.FourWheeler;
import com.jnit.config.HibernateUtil;

/*
 * SingleTable 
 */
public class Singletable {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");

		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setVehicleName("Bike");
		twoWheeler.setSteeringTwoWheeler("Bike Steering Handle");

		FourWheeler fourWheeler = new FourWheeler();
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
