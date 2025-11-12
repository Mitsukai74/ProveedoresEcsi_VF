package com.projectEcsiDef.config;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {
	
	@RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute("jakarta.servlet.error.status_code");

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            
            switch (statusCode) {
            case 404:
                model.addAttribute("mensaje", "La página que busca no existe o fue movida.");
                return "errors/404";
            case 500:
                model.addAttribute("mensaje", "Ha ocurrido un error interno en el servidor.");
                return "errors/500";
            default:
                model.addAttribute("mensaje", "Ha ocurrido un error inesperado.");
                return "errors/Error";
            
            	}
            }
        model.addAttribute("mensaje", "Error desconocido.");
        return "errors/Error";
        }

}
