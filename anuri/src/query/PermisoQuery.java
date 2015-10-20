package query;

import org.hibernate.Query;
import modelo.Permiso;

public class PermisoQuery {



	public Permiso buscarPermiso(String nombre){
		Connection connection = new Connection();
		connection.connect();
		Query query = connection.session.createQuery("from Permiso where nombre = :permisoNombre ");
		query.setParameter("permisoNombre", nombre);
		connection.disconnect();
		if (!query.list().isEmpty()){
			Permiso permiso= (Permiso)query.list().get(0);
			return permiso;
		}else{
			return null;
		}
	}
}
