package com.projectEcsiDef.Repositorios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projectEcsiDef.Entidades.Proveedores;

@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedores, Integer> {
	Page<Proveedores> findByRazonSocialContaining(String razonSocial, Pageable pageable);
	
	//query para la busqueda de proveedores sin importar camel case
	 @Query("SELECT p FROM Proveedores p WHERE LOWER(p.razonSocial) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	    List<Proveedores> searchByRazonSocial(@Param("keyword") String keyword);
	 
	 @Query("SELECT p FROM Proveedores p WHERE LOWER(p.nit) LIKE LOWER(CONCAT('%', :nit, '%'))")
	    List<Proveedores> searchByNit(@Param("nit") String nit);
}
