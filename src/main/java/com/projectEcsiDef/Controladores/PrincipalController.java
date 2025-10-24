package com.projectEcsiDef.Controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    	model.addAttribute("roles", rolRepository.findAll());
        model.addAttribute("titulo", "Creación de usuarios");     
        
    	return "usrVistas/formUser"; 
    }
    
    @PostMapping("/user/save")
    public String guardarUsuario(@ModelAttribute("usuario") Users usuario,
                                 @RequestParam("idRol") int idRol) {

        // Encriptar la clave antes de guardar
        usuario.setClave(passwordEncoder.encode(usuario.getClave()));

        // Buscar el rol en la BD y asociarlo
        Rol rol = rolRepository.findById(idRol).orElse(null);
        if (rol !=null) {
        	usuario.getRoles().add(rol);
        }
        
        // Guardar usuario en BD
        usersRepository.save(usuario);

        // Redirigir al listado o al inicio
        return "redirect:/inicio";
    }
    
    @GetMapping("/buscar")
	public String buscarProveedores(Pageable pageable,Model model, @RequestParam(required = false)String busqueda) {
		
		Page<Proveedores> proveedorPage = null;
		if (busqueda != null && busqueda.trim().length() > 0) {
			proveedorPage = iproveedoresServices.buscarPorRs(busqueda, pageable);
		}else {
	        proveedorPage = Page.empty(); // Página vacía si no hay búsqueda
	    }		
		model.addAttribute("proveedorPage",proveedorPage);
				
		return "/vistaBusquedas";
	}
	
}
