package org.faithfarm.hibernate.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.faithfarm.domain.GiftPledge;
import org.faithfarm.hibernate.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GiftPledgeDao {
	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(GiftPledgeDao.class
			.getName());
	private static Session session;

	public GiftPledgeDao() {
		LOGGER.setLevel(Level.INFO);

	}

	public GiftPledge findById(Long id) {
		Session session = null;
		GiftPledge GiftPledge = null; 
		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
			GiftPledge = (GiftPledge) session.get(GiftPledge.class, id);
			Hibernate.initialize(GiftPledge.getGiftType());
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
		return GiftPledge;
	}

	
	public List listGiftPledges() {
		LOGGER.setLevel(Level.INFO);
		List<GiftPledge> list = new ArrayList<GiftPledge>();
		Session session = null;
		GiftPledge user = null;

		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();

			list = session.createQuery("FROM GiftPledge").list();
			
			 for (Iterator iterator =
		    			list.iterator(); iterator.hasNext();){
		    
				 GiftPledge obj = (GiftPledge) iterator.next();
				 
				 Hibernate.initialize(obj.getGiftType());
				 System.out.println (obj.getGiftType());
			 }  
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

	/* Method to INSERT GiftPledge */
	public Long addGiftPledge(GiftPledge obj) {
		
		Long key = null;
		Session session = null;
		GiftPledge user = null;

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

	/* Method to UPDATE GiftPledge */
	public void updateGiftPledge(GiftPledge obj) {
		Session session = null;
		GiftPledge user = null;

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

	/* Method to DELETE GiftPledge */
	public void deleteGiftPledge(Long key) {
		Session session = null;
		GiftPledge user = null;

		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
			GiftPledge obj = (GiftPledge) session.get(GiftPledge.class, key);
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
