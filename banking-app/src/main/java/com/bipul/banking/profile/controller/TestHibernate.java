package com.bipul.banking.profile.controller;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bipul.banking.testmodel.TestModel;

@Service
public class TestHibernate {
	
	private static final Logger log = Logger.getLogger(TestHibernate.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	TestModel testModel;

	public String getTestColumn() {

		testModel.setName("Finally Successfully Connected");

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(testModel);
		session.getTransaction().commit();
		session.close();
		return "Success";
	}

}
