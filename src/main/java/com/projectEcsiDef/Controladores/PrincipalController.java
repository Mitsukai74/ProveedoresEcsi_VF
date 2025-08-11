package com.projectEcsiDef.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.projectEcsiDef.Entidades.Users;


@Controller
public class PrincipalController {
	
	@GetMapping(path = "/test")
	public String mostrarPlantilla() {
		return "inicio";
	}
	
	@GetMapping("/pruebaForms")
	public String crearUser(Model model){
		
		Users usuario = new Users();
		
		model.addAttribute("titulo","Formulario: Nuevo usuario");
		model.addAttribute("usuario",usuario);
				
		return "/usrVistas/formUser";
	}
}
