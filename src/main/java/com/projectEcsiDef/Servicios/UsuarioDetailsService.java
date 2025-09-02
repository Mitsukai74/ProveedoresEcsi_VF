package com.projectEcsiDef.Servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projectEcsiDef.Entidades.Users;
import com.projectEcsiDef.Repositorios.UsuarioRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioDetailsService implements UserDetailsService {
	
	 @Autowired
	    private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
		
		Users usuario = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con correo: " + correo));

        // Convierte los roles en GrantedAuthority
        Set<GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(rol -> new SimpleGrantedAuthority("ROLE_" + rol.getDescripcion().toUpperCase()))
                .collect(Collectors.toSet());

        // Retorna un objeto User de Spring Security
        return new User(usuario.getCorreo(), usuario.getClave(), authorities);
    }		
}

	
	

