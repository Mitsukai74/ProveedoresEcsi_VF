package com.projectEcsiDef.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.projectEcsiDef.Entidades.Proveedores;
import com.projectEcsiDef.Entidades.Users;
import com.projectEcsiDef.Servicios.IproveedoresServices;


@Controller
public class PrincipalController {
	
	@Autowired
	private IproveedoresServices iproveedoresServices;
	
	@GetMapping(path = "/login")
	public String mostrarPlantilla() {
		return "login";
	}	
	
	@GetMapping("/inicio")
    public String inicio() {
        return "inicio"; 
    }
	
	// Vista de crear usuarios (solo para admin)
    @GetMapping("/admin/usuarios/nuevo")
    public String crearUsuario() {
        return "/usrVistas/formUser";
    }
    
    @GetMapping("/listado")
	public String listarprovReembolsos(Model model) {	
    	List<Proveedores> listadoprov = iproveedoresServices.listarTodosProvReem();
    	
    	model.addAttribute("titulo", "Listado de proveedores");
    	model.addAttribute("Proveedores",listadoprov);
    	
    	return "listadoProv";	
    	
		
	}
	
}
