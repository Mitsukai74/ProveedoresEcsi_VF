package com.projectEcsiDef.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


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
	private String rol;
	
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
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
	
	public Users(String nombre, String correo, String clave,String rol) {
        this.nombre = nombre;
        this.clave = clave;
        this.correo = correo;
        this.rol = rol;
    }
	

}
