package com.projectEcsiDef.Servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectEcsiDef.Entidades.Proveedores;
import com.projectEcsiDef.Entidades.UrlDocumentos;
import com.projectEcsiDef.Repositorios.RutaDocRepository;
import com.projectEcsiDef.Repositorios.ProveedoresRepository;

@Service
public class UrlDocServices {
	
	@Autowired
	private RutaDocRepository rutaDocRepository;
	
	@Autowired
	private ProveedoresRepository proveedoresRepository;
	
	public Optional<UrlDocumentos> obtenerRutaPorProveedor(Double codigoEcsi){
		
		return rutaDocRepository.findByProveedor_CodigoEcsi(codigoEcsi);
	}
	
	// Nuevo método para registrar o actualizar una ruta
    public void guardarRuta(Double codigoEcsi, String urlCarpeta) {
        // Buscar el proveedor asociado
      Proveedores proveedor = proveedoresRepository.findByCodigoEcsi(codigoEcsi)	
                .orElseThrow(() -> new IllegalArgumentException("No existe un proveedor con código ECSI: " + codigoEcsi));

        // Verificar si ya existe una ruta para este proveedor
        Optional<UrlDocumentos> existente = rutaDocRepository.findByProveedor_CodigoEcsi(codigoEcsi);

        UrlDocumentos urlDoc;
        if (existente.isPresent()) {
            // Si ya existe, se actualiza
            urlDoc = existente.get();
            urlDoc.setUrlCarpeta(urlCarpeta);
        } else {
            // Si no existe, se crea una nueva
            urlDoc = new UrlDocumentos();
            urlDoc.setProveedor(proveedor);
            urlDoc.setUrlCarpeta(urlCarpeta);
        }

        rutaDocRepository.save(urlDoc);
    }
	
}
