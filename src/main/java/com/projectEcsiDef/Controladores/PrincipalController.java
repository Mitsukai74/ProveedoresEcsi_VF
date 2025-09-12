package com.projectEcsiDef.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.projectEcsiDef.Entidades.Users;


@Controller
public class PrincipalController {
	
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
	
}
