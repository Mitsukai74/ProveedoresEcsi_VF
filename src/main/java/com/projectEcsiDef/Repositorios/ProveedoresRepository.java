package com.projectEcsiDef.Repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectEcsiDef.Entidades.Proveedores;

@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedores, Integer> {
	Page<Proveedores> findByRazonSocialContaining(String razonSocial, Pageable pageable);

}
