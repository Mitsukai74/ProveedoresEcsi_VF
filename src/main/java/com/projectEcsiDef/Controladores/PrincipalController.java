package com.projectEcsiDef.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalController {
	
	@GetMapping(path = "/test")
	public String mostrarPlantilla() {
		return "login";
	}
}
