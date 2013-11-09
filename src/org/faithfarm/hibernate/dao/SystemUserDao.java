package org.faithfarm.hibernate.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.faithfarm.domain.SystemUser;
import org.faithfarm.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SystemUserDao {
	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(SystemUserDao.class
			.getName());
	private static Session session;

	public SystemUserDao() {
		LOGGER.setLevel(Level.INFO);

	}

	public SystemUser findById(Long id) {
		Session session = null;
		SystemUser SystemUser = null; 
		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
			SystemUser = (SystemUser) session.get(SystemUser.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.flush();
			session.close();
		}
		return SystemUser;
	}

	public SystemUser authenticate(String username, String password) {

		Session session = null;
		SystemUser user = null;

		try { 
			session = HibernateUtil.openSession();
			System.out.println (session.isOpen());
			session.beginTransaction();

			Query q = session
					.createQuery(" from SystemUser where username = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);

			List result = q.list();
			if (result.size() > 0)
				user = (SystemUser) result.get(0);
			session.getTransaction().commit();
		}  catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.flush();
			session.close();
		}

		return user;
	}

	public List listSystemUsers() {
		LOGGER.setLevel(Level.INFO);
		List<SystemUser> list = new ArrayList<SystemUser>();
		Session session = null;
		SystemUser user = null;

		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();

			list = session.createQuery("FROM SystemUser").list();
			session.getTransaction().commit();
		}  catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.flush();
			session.close();
		}
		return list;
	}

	/* Method to INSERT SystemUser */
	public Long addSystemUser(SystemUser obj) {
		
		Long key = null;
		Session session = null;
		SystemUser user = null;

		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
			key = (Long) session.save(obj);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.flush();
			session.close();
		}
		return key;
	}

	/* Method to UPDATE SystemUser */
	public void updateSystemUser(SystemUser obj) {
		Session session = null;
		SystemUser user = null;

		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
			session.update(obj);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.flush();
			session.close();
		}
	}

	/* Method to DELETE SystemUser */
	public void deleteSystemUser(Long key) {
		Session session = null;
		SystemUser user = null;

		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
			SystemUser obj = (SystemUser) session.get(SystemUser.class, key);
			session.delete(obj);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.flush();
			session.close();
		}
	}

}
