package com.projectEcsiDef.Servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectEcsiDef.Entidades.UrlDocumentos;
import com.projectEcsiDef.Repositorios.RutaDocRepository;

@Service
public class UrlDocServices {
	
	@Autowired
	private RutaDocRepository rutaDocRepository;
	
	public Optional<UrlDocumentos> obtenerRutaPorProveedor(Integer proveedorId){
		
		return rutaDocRepository.findByProveedores_Id(proveedorId);
	}
	
	//Método que accede solo los admin para guardar las rutas URL
	public UrlDocumentos guardarRuta(UrlDocumentos ruta) {
		return ruta;
		
		}

}
