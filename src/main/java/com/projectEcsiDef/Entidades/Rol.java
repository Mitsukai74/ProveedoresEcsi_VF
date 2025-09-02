package com.projectEcsiDef.Entidades;

import jakarta.persistence.Entity;

@Entity
public class Rol {
	
	private Long idRol;
    public Long getIdRol() {
		return idRol;
	}
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	private String descripcion;

}
