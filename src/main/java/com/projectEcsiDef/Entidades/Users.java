package com.projectEcsiDef.Entidades;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "USUARIOS")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USER")
	private int idUser;
	
	private String nombre;	
	private String correo;
	private String clave;
	
	@Override
	public String toString() {
		return "Users [idUser=" + idUser + ", nombre=" + nombre + ", correo=" + correo + ", clave=" + clave + "]";
	}
	
	
	//haciendo relación entre las tablas:
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "usuario_roles", // tabla intermedia
        joinColumns = @JoinColumn(name = "ID_USER"), // FK a usuarios
        inverseJoinColumns = @JoinColumn(name = "ID_ROL") // FK a roles
    )
    private Set<Rol> roles = new HashSet<>();
	
	
	public Set<Rol> getRoles() {
		return roles;
	}
	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public Users(String nombre, String correo, String clave) {
        this.nombre = nombre;
        this.clave = clave;
        this.correo = correo;       
    }
	//Constructor vacío obligatorio por Hibernate
	public Users() {}

}
