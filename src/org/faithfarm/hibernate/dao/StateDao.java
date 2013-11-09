package org.faithfarm.hibernate.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.faithfarm.domain.State;
import org.faithfarm.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StateDao {
	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(StateDao.class
			.getName());
	private static Session session;

	public StateDao() {
		LOGGER.setLevel(Level.INFO);

	}

	public State findById(Long id) {
		Session session = null;
		State State = null; 
		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
			State = (State) session.get(State.class, id);
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
		return State;
	}

	
	public List listStates() {
		LOGGER.setLevel(Level.INFO);
		List<State> list = new ArrayList<State>();
		Session session = null;
		State user = null;

		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();

			list = session.createQuery("FROM State").list();
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



}
