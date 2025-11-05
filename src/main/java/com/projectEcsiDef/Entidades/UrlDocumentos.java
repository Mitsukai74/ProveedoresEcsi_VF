package com.projectEcsiDef.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "URLDOCUMENTOS")
public class UrlDocumentos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "CODIGO_ECSI", nullable = false)
	private Proveedores proveedores;
	
	@Column(name = "URL_CARPETA", nullable = false)
	private String urlCarpeta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

	public String getUrlCarpeta() {
		return urlCarpeta;
	}

	public void setUrlCarpeta(String urlCarpeta) {
		this.urlCarpeta = urlCarpeta;
	}

}
