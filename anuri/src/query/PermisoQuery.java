package query;

import java.util.List;
import query.*;
import org.hibernate.Query;
import org.hibernate.Session;

import modelo.Permiso;
import util.HibernateUtil;

public class PermisoQuery {
	
	

	public Permiso buscarPermiso(String nombre){
		Connection connection = new Connection();
		Session session= connection.connect();
		Query query = session.createQuery("from Permiso where nombre = :permisoNombre ");
        query.setParameter("permisoNombre", nombre);
        Permiso permiso= (Permiso)query.list().get(0);
        connection.disconnect(session);
		return permiso;
	}

}
