package query;

import org.hibernate.Query;
import modelo.*;

public class UserQuery {
	
	public User buscarUsuario(String nombre){
		Connection connection = new Connection();
		connection.connect();
		Query query = connection.session.createQuery("from User where nombre = :usuarioNombre ");
        query.setParameter("usuarioNombre", nombre);
        User usuario= (User)query.list().get(0);
        connection.disconnect();
		return usuario;
	}

}
