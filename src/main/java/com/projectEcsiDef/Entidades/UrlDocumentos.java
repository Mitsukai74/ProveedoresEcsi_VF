package com.projectEcsiDef.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "URLDOCUMENTOS")
public class UrlDocumentos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//@Column(name = "codigo_ecsi", nullable = false)
	//private double codigoEcsi;	
	
	@Column(name = "URL_CARPETA", nullable = false)
	private String urlCarpeta;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_ecsi", referencedColumnName = "codigo_ecsi", nullable = false)
    private Proveedores proveedores;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUrlCarpeta() {
		return urlCarpeta;
	}

	public void setUrlCarpeta(String urlCarpeta) {
		this.urlCarpeta = urlCarpeta;
	}	

}
