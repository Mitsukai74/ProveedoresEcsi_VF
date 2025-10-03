package com.projectEcsiDef.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projectEcsiDef.Entidades.Proveedores;
import com.projectEcsiDef.Repositorios.ProveedoresRepository;

@Service
public class ProveedoresImplementation implements IproveedoresServices{
	
	@Autowired
	private ProveedoresRepository proveedoresRepository;

	@Override
	public List<Proveedores> listarTodosProvReem() {
		
		return proveedoresRepository.findAll();
	}

	@Override
	public Page<Proveedores> buscarPorRs(String razonSocial, Pageable pageable) {
		
		return proveedoresRepository.findByRazonSocialContaining(razonSocial, pageable);
	}

}
