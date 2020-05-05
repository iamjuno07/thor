package com.xworkz.myfirstproject.dao;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.xworkz.myfirstproject.dto.SignUpDTO;
import com.xworkz.myfirstproject.entity.SignUpEntity;

@Component
@Qualifier("SignUpDAO")
public class SignUpDAOImpl implements SignUpDAO {

	public static final Logger logger = Logger.getLogger(SignUpDAOImpl.class);

	private SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public boolean validateUserName(String username) {
		System.out.println("invoked validateUserName inside SignUpDAOImpl");
		Session session = null;
		SignUpEntity entity = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Query data = session.getNamedQuery("validateUsername");
			data.setParameter("username", username);
			entity = (SignUpEntity) data.uniqueResult();
			if (!Objects.nonNull(entity)) {
				return true;
			}
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean validateEmail(String email) {
		System.out.println("invoked validateUserName inside SignUpDAOImpl");
		logger.warn("invoked validateUserName inside SignUpDAOImpl");
		Session session = null;
		SignUpEntity entity = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Query data = session.getNamedQuery("validateEmail");
			data.setParameter("email", email);
			entity = (SignUpEntity) data.uniqueResult();
			if (!Objects.nonNull(entity)) {
				return true;
			}
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean saveUser(SignUpEntity entity) {
		// System.out.println("invoked saveUser inside SignUpDAOImpl");
		logger.warn("invoked saveUser inside SignUpDAOImpl");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

}
