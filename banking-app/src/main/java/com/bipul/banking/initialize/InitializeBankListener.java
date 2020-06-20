package com.bipul.banking.initialize;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bipul.banking.enums.RoleEnum;
import com.bipul.banking.user.Role;
import com.bipul.banking.user.User;

@Component
public class InitializeBankListener implements ServletContextListener{
	
	private static final Logger log = Logger.getLogger(InitializeBankListener.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
				
		ServletContextListener.super.contextInitialized(sce);
		log.info("Banking application Starting.");
		//initializeDB();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		ServletContextListener.super.contextDestroyed(sce);
		log.info("Banking application Shutting Down.");
	}
	
	public void initializeDB() {

		log.info("Initialize Bank: Adding User Name and Role into DB. START.");
		
		User user = new User();
		user.setUsername("Bipul");
		user.setPassword("rita");

		Role role = new Role();
		role.setRolename(RoleEnum.ADMIN);

		user.getRoles().add(role);
		role.getUsers().add(user);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(user);
		session.getTransaction().commit();

		session.close();

		log.info("Initialize Bank: Adding User Name and Role into DB. END.");

	}

}
