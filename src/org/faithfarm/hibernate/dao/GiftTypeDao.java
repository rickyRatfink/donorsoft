package org.faithfarm.hibernate.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.faithfarm.domain.GiftType;
import org.faithfarm.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GiftTypeDao {
	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(GiftTypeDao.class
			.getName());
	private static Session session;

	public GiftTypeDao() {
		LOGGER.setLevel(Level.INFO);

	}

	public GiftType findById(Long id) {
		Session session = null;
		GiftType GiftType = null; 
		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
			GiftType = (GiftType) session.get(GiftType.class, id);
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
		return GiftType;
	}

	
	public List listGiftTypes() {
		LOGGER.setLevel(Level.INFO);
		List<GiftType> list = new ArrayList<GiftType>();
		Session session = null;
		GiftType user = null;

		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();

			list = session.createQuery("FROM GiftType").list();
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

	/* Method to INSERT GiftType */
	public Long addGiftType(GiftType obj) {
		
		Long key = null;
		Session session = null;
		GiftType user = null;

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

	/* Method to UPDATE GiftType */
	public void updateGiftType(GiftType obj) {
		Session session = null;
		GiftType user = null;

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

	/* Method to DELETE GiftType */
	public void deleteGiftType(Long key) {
		Session session = null;
		GiftType user = null;

		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
			GiftType obj = (GiftType) session.get(GiftType.class, key);
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
