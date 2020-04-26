package com.xworkz.myfirstproject.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.xworkz.myfirstproject.entity.SignUpEntity;

@Component
@Qualifier("DAOImpl")
public class LoginDAOImpl implements LoginDAO {

	private SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public int validateLoginEmail(String email) {
		System.out.println("invoked validateEmail() inside LoginDAOImpl");
		Session session = null;
		int count = 0;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Query query = session.getNamedQuery("validateLoginEmail");
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
	public SignUpEntity getUserData(String email) {
		System.out.println("Created" + this.getClass().getSimpleName());
		Session session = null;
		SignUpEntity entity = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Query query = session.getNamedQuery("getUser");
			query.setParameter("email", email);
			entity = (SignUpEntity) query.uniqueResult();
			return entity;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return entity;
	}

	@Override
	public boolean updateLoginCount(String email, int value) {
		System.out.println("invoke updateLoginCount() inside LoginDAOImpl");
		Session session = null;
		SignUpEntity entity = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			System.out.println("LoginValue:" + value);
			Query query = session.getNamedQuery("UpdateLoginCount");
			query.setParameter("email", email);
			query.setParameter("value", value);
			int result = query.executeUpdate();
			System.out.println(result);
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
