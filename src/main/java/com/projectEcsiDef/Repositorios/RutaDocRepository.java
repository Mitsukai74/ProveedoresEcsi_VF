package com.projectEcsiDef.Repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectEcsiDef.Entidades.UrlDocumentos;

@Repository
public interface RutaDocRepository extends JpaRepository<UrlDocumentos, Integer> {
	
	Optional<UrlDocumentos> findByProveedor_CodigoEcsi(Double codigoEcsi);

}
