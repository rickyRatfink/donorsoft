package org.faithfarm.hibernate;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

	public class HibernateUtil {
	   
	    private static Log log = LogFactory.getLog(HibernateUtil.class);
	    
	    private static final SessionFactory sessionFactory;
	    
	    static {
	        try {
	        	Configuration configuration = new Configuration();
	        	configuration.configure();
	        	
	        	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	            // Create the SessionFactory
	        	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	            
	        } catch (Throwable ex) {
	            // Make sure you log the exception, as it might be swallowed
	            log.error("Initial SessionFactory creation failed.", ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	    
	    public static final ThreadLocal session = new ThreadLocal();
	    
	    public static Session openSession() throws HibernateException {
	        Session s = (Session) session.get();
	        // Open a new Session, if this Thread has none yet
	        s = sessionFactory.openSession();
	        session.set(s);
	        return s;
	    }
	    
	    public static void closeSession() throws HibernateException {
	        Session s = (Session) session.get();
	        session.set(null);
	        if (s != null)
	            s.close();
	    }    
	    
	    
	 
	}

	 
	
	
	/*
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }
    
    public static SessionFactory getSessionFactory() {
    	return sessionFactory;
    }
}*/