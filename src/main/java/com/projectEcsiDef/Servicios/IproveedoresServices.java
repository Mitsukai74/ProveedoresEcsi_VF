package com.projectEcsiDef.Servicios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.projectEcsiDef.Entidades.Proveedores;



public interface IproveedoresServices {
	
	public List<Proveedores> listarTodosProvReem();
	public Page<Proveedores> buscarPorRs(String razonSocial, Pageable pageable);

}
