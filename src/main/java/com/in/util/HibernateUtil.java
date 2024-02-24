package com.in.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.in.entity.Student;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getMySqlSession() {
		if(sessionFactory == null) {
			try {
				
				Configuration configuration = new Configuration();
				
				Properties settings = new Properties();
				
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_02");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "root");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.HBM2DDL_AUTO,"update");
				
				configuration.setProperties(settings);
				
				configuration.addAnnotatedClass(Student.class);
				
				StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				return configuration.buildSessionFactory(serviceRegistry);
			
			}catch(Exception e) {
				
				System.out.println("Connection failed");
				e.printStackTrace();
				
			}
		}
		
		return null;
		//return sessionFactory;
	}
	
	
		
		
		
}

