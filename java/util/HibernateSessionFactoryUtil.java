package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import model.User;
import model.Vehicle;

public class HibernateSessionFactoryUtil {
	private static SessionFactory sessionFactory;
	
	private HibernateSessionFactoryUtil() {
		
	}
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration().configure();
				configuration.addAnnotatedClass(User.class);
				configuration.addAnnotatedClass(Vehicle.class);
				StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
								//getProperties это параметры для работы hibernate, указанные в файле resources/hibernate.cfg.xml
				
				sessionFactory = configuration.buildSessionFactory(builder.build());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		return sessionFactory;
	}

}
