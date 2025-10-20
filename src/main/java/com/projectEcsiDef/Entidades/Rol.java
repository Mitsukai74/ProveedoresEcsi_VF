package com.projectEcsiDef.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "ROL")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_ROL")
	private int idRol;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@ManyToMany(mappedBy = "roles")
    private Set<Users> usuarios;
	
    public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
