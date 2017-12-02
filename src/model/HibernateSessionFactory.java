package model;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@SuppressWarnings("deprecation")
public class HibernateSessionFactory {

	private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static Configuration configuration = new Configuration();
	public static SessionFactory sessionFactory;
	private static String configFile = CONFIG_FILE_LOCATION;

	static {
		try{
			configuration.configure(configFile);
			ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(sr);
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

	private HibernateSessionFactory() {

	}

	public static Session getSession() {
		Session session = threadLocal.get();
		if (session == null || !session.isOpen()) {
			session = (sessionFactory != null) ? sessionFactory.openSession() : null;
			threadLocal.set(session);
		}
		return session;
	}
	
	/**
	 * 提交Session
	 * @param session
	 * @author Feng
	 */
	public static void commitSession(Session session) {
        Transaction trans = session.beginTransaction();
        trans.commit();
        session.close();
	}
}
