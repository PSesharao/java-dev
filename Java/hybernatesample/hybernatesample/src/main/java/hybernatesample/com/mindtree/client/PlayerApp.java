package hybernatesample.com.mindtree.client;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import hybernatesample.com.mindtree.entity.Player;

public class PlayerApp {
	static Scanner input = new Scanner(System.in);
	static Player playerObj;
	static Session sessionObj;
	static SessionFactory sessionFactoryObj;

	private static SessionFactory buildSessionFactory() {

		Configuration configObj = new Configuration();
		configObj.configure("hybernatesample/com/mindtree/resources/config.xml").addAnnotatedClass(Player.class);

		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();

		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}

	public static void main(String[] args) {
		System.out.println(".......Hibernate Maven Example.......\n");
		try {
			sessionObj = buildSessionFactory().openSession();
			sessionObj.beginTransaction();

			for (int i = 1; i <= 1; i++) {
				System.out.println("Enter player " + (i) + "details :");
				playerObj = getPlayerDetails();
				sessionObj.save(playerObj);
			}
			System.out.println("\n.......Records Saved Successfully To The Database.......\n");

			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}

	private static Player getPlayerDetails() {
		System.out.println("Enter player jersyno :");
		int jersyno = input.nextInt();
		System.out.println("Enter player first name :");
		String firstName = input.next();
		System.out.println("Enter player last name :");
		String lastName = input.next();
		System.out.println("Enter player age :");
		int age = input.nextInt();
		return new Player(jersyno, firstName, lastName, age);
	}
}
