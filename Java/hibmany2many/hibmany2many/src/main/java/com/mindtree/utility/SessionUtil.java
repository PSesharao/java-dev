package com.mindtree.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.mindtree.entity.Book;
import com.mindtree.entity.Library;

public class SessionUtil {

	public SessionFactory buildSession() {
		SessionFactory sessionFactoryObj = null;
		Configuration configObj = new Configuration();
		configObj.configure("com/mindtree/resource/config.xml").addAnnotatedClass(Book.class)
				.addAnnotatedClass(Library.class);

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
