package com.xworkz.myfirstproject.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.xworkz.myfirstproject.controller.ForgotPasswordController;
import com.xworkz.myfirstproject.entity.SignUpEntity;

@Component
@Qualifier("forgotPassword")
public class ForgotDAOImpl implements ForgotDAO {

	public static final Logger logger = Logger.getLogger(ForgotDAOImpl.class);

	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public ForgotDAOImpl() {
		System.out.println("Created" + this.getClass().getSimpleName());
	}

	public int validateLoginEmail(String email) {
		// System.out.println("invoked validateEmail() inside ForgotDAOImpl");
		logger.warn("invoked validateEmail() inside ForgotDAOImpl");
		String SQLQuery = "select count(*) from LoginEntity dto where dto.email =:email";
		logger.warn("Query: " + SQLQuery);
		Session session = null;
		int count = 0;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(SQLQuery);
			query.setParameter("email", email);
			count = ((Long) query.uniqueResult()).intValue();
			return count;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}

	@Override
	public boolean updatePassword(String email, String password) {
		// System.out.println("invoke updateLoginCount() inside ForgotDAOImpl");
		logger.warn("invoke updateLoginCount() inside ForgotDAOImpl");
		String SQLQuery = "update SignUpEntity dto set dto.password =:value where dto.email =:email";
		logger.warn("Query: " + SQLQuery);
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(SQLQuery);
			query.setParameter("email", email);
			query.setParameter("value", password);
			System.out.println(query.executeUpdate());
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;

	}

}
