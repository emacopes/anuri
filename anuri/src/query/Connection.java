package query;

import org.hibernate.Session;

import util.HibernateUtil;

public class Connection {
public Session session;
	
	public void connect (){
		this.session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
	}
	
	public void disconnect(){
        this.session.getTransaction().commit();
        this.session.close();
	}
}
