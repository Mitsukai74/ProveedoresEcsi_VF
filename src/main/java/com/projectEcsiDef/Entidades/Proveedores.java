package com.projectEcsiDef.Entidades;

import jakarta.persistence.Entity;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.*;


@Entity
@Table(name = "PROVEEDORES")
@Immutable
public class Proveedores {	
	
	@Id
	@Column
	private int id;
	
	@Column(name = "NIT", columnDefinition = "CHARACTER(20)")
	private String nit;
	
	@Column(name = "CODIGO_ECSI", columnDefinition = "DOUBLE(8)", unique =true, nullable=false)
	private Double codigoEcsi;
	@Column(name = "RAZON_SOCIAL", columnDefinition = "CHARACTER(50)")
	private String razonSocial;
	@Column(name = "DIRECCION", columnDefinition = "CHARACTER(50)")
	private String direccion;
	@Column(name = "TELEFONO", columnDefinition = "CHARACTER(25)")
	private String telefono;
	@Column(name = "COD_MUN", columnDefinition = "CHARACTER(9)")
	private String codMun;
	@Column(name = "COD_DEPTO", columnDefinition = "VARCHAR(255)")
	private String codDepto;
	@Column(name = "CORREO", columnDefinition = "CHARACTER(50)")
	private String correo;
	@Column(name = "ACTIVIDAD", columnDefinition = "VARCHAR(255)")
	private String actividad;
	@Column(name = "TIPO_PROV", columnDefinition = "CHARACTER(4)")
	private String tipoProv;
	@Column(name = "FECHA_CREACION", columnDefinition = "CHARACTER(30)")
	private String fechaCreacion;
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	//Constructor vacío obligatorio por Hibernate
	public Proveedores() {}
		
	public String getRazonSocial() {
			return razonSocial;
		}

		public void setRazonSocial(String razonSocial) {
			this.razonSocial = razonSocial;
		}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCodMun() {
		return codMun;
	}
	public void setCodMun(String codMun) {
		this.codMun = codMun;
	}
	public String getCodDepto() {
		return codDepto;
	}
	public void setCodDepto(String codDepto) {
		this.codDepto = codDepto;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getActividad() {
		return actividad;
	}
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	public String getTipoProv() {
		return tipoProv;
	}
	public void setTipoProv(String tipoProv) {
		this.tipoProv = tipoProv;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public double getCodigoEcsi() {
		return codigoEcsi;
	}
	public void setCodigoEcsi(double codigoEcsi) {
		this.codigoEcsi = codigoEcsi;
	}
	

}
