package modelo;
// Generated 19-oct-2015 19:13:07 by Hibernate Tools 4.0.0

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JCheckBox;
/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	private Integer userId;
	private String nombre;
	private String password;
	private Set<Permiso> permisos = new HashSet<Permiso>(0);

	
	public User() {
	}

	public User(String nombre, String password) {
		this.nombre = nombre;
		this.password = password;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(Set<Permiso> permisos) {
		this.permisos = permisos;
	}

	public void addPermiso(Permiso permiso) {
		this.permisos.add(permiso);
	}
	
	public void delPermiso(Permiso permiso){
		if (this.permisos.contains(permiso)){
			this.permisos.remove(permiso);
		}
	}
	
}
