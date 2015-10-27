package query;

import java.util.List;

import org.hibernate.Query;
import modelo.*;
import views.*;

public class UserQuery {
	
	public User buscarUsuario(String nombre){
		Home.session.beginTransaction();
		Query query = Home.session.createQuery("from User where nombre = :usuarioNombre ");
        query.setParameter("usuarioNombre", nombre);
        if (query.list().isEmpty()){
        	Home.session.getTransaction().commit();
        	return null;
        }
        else{
        	User usuario= (User)query.list().get(0);
        	Home.session.getTransaction().commit();
        	return usuario;
        }	
	}
	
	public List<User> buscarOtrosUsuarios(String usuarioActual){
		Home.session.beginTransaction();
		Query query = Home.session.createQuery("from User where nombre <> :usuarioNombre ");
        query.setParameter("usuarioNombre", usuarioActual);
        if (query.list().isEmpty()){
        	Home.session.getTransaction().commit();
        	return null;
        }
        else{
        	Home.session.getTransaction().commit();
        	return query.list();
        }	
	}

}
