package com.jbk.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jbk.entity.Employee;

public class HibernateConfiguration {
	
	public static SessionFactory getSessionFactory() {
		
		Configuration cfg=new Configuration();
		cfg.configure().addAnnotatedClass(Employee.class);
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		
		return sessionFactory;
		
	}

}
