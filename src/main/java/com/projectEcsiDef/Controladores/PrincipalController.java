package com.projectEcsiDef.Controladores;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projectEcsiDef.Entidades.Proveedores;
import com.projectEcsiDef.Entidades.Rol;
import com.projectEcsiDef.Entidades.Users;
import com.projectEcsiDef.Repositorios.RolRepository;
import com.projectEcsiDef.Repositorios.UsuarioRepository;
import com.projectEcsiDef.Servicios.IproveedoresServices;


@Controller
public class PrincipalController {
	
	@Autowired
	private IproveedoresServices iproveedoresServices;
	@Autowired
	private RolRepository rolRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioRepository usersRepository;
	
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
    
    @GetMapping("/user/form")
    public String showUserForm(Model model) {
    	model.addAttribute("usuario", new Users());
        model.addAttribute("titulo", "Creación de usuarios");
    	
        return "usrVistas/formUser"; 
    }
    
    @PostMapping("/save")
    public String guardarUsuario(@ModelAttribute("usuario") Users usuario,
                                 @RequestParam("idRol") int idRol) {

        // Encriptar la clave antes de guardar
        usuario.setClave(passwordEncoder.encode(usuario.getClave()));

        // Buscar el rol en la BD y asociarlo
        Rol rol = rolRepository.findById(idRol)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con id: " + idRol));
        usuario.getRoles().add(rol);

        // Guardar usuario en BD
        usersRepository.save(usuario);

        // Redirigir al listado o al inicio
        return "redirect:/index";
    }
	
}
