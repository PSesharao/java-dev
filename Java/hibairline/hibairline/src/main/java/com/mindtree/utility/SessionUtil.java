package com.mindtree.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.mindtree.entity.Flight;
import com.mindtree.entity.Passenger;


public class SessionUtil {

	public SessionFactory buildSession() {
		SessionFactory sessionFactoryObj = null;
		Configuration configObj = new Configuration();
		configObj.configure("com/mindtree/resource/config.xml").addAnnotatedClass(Flight.class)
				.addAnnotatedClass(Passenger.class);

		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();

		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}

	public void closeResource(Session sessionObj) {
		if (sessionObj != null)
			sessionObj.close();
	}
}
