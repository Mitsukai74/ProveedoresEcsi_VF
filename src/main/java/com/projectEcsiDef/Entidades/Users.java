package com.projectEcsiDef.Entidades;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import jakarta.persistence.*;



@Entity
@Table(name = "USUARIOS")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	
	@Override
	public String toString() {
		return "Users [idUser=" + idUser + ", nombre=" + nombre + ", correo=" + correo + ", clave=" + clave + "]";
	}
	private String nombre;	
	private String correo;
	private String clave;
	
	//haciendo relación entre las tablas:
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "usuario_roles", // tabla intermedia
        joinColumns = @JoinColumn(name = "idUser"), // FK a usuarios
        inverseJoinColumns = @JoinColumn(name = "idRol") // FK a roles
    )
    private Set<Rol> roles = new HashSet<>();
	
	
	public Set<Rol> getRoles() {
		return roles;
	}
	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
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

}
