package query;

import org.hibernate.Query;
import modelo.Permiso;
import modelo.User;
import views.Home;

public class PermisoQuery {



	public Permiso buscarPermiso(String nombre){
		Home.session.beginTransaction();
		Query query = Home.session.createQuery("from Permiso where nombre = :permisoNombre ");
		query.setParameter("permisoNombre", nombre);
		if (!query.list().isEmpty()){
			Permiso permiso= (Permiso)query.list().get(0);
			Home.session.getTransaction().commit();
			return permiso;
		}else{
			Home.session.getTransaction().commit();
			return null;
		}
	}

}
