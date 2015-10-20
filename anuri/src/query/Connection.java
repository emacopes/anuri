package query;

import org.hibernate.Session;

import util.HibernateUtil;

public class Connection {

	
	public Session connect (){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		return session;
	}
	
	public void disconnect(Session session){
        session.getTransaction().commit();
        session.close();
	}
}
