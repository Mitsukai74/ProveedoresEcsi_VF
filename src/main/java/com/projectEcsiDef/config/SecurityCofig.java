package com.projectEcsiDef.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.projectEcsiDef.Repositorios.UsuarioRepository;
import com.projectEcsiDef.Servicios.UsuarioDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityCofig {
	
	@Autowired
    private UsuarioDetailsService usuarioDetailsService;
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
	            .authorizeHttpRequests(auth -> auth
	                // rutas públicas
	                .requestMatchers("/login", "/css/**", "/js/**", "/images/**").permitAll()
	                //solo para los que inician sesión
	                .requestMatchers("/inicio").authenticated()	                
	                // solo ADMIN puede acceder a /admin/**
	                .requestMatchers("/user/form","/user/save").hasRole("ADMIN")
	                // cualquier usuario autenticado puede acceder a lo demás
	                .anyRequest().authenticated()
	            )
	            // configuración del login
	            .formLogin(form -> form
	                .loginPage("/login")
	                .usernameParameter("correo") // se usa correo ya que es un campo único
	                .passwordParameter("clave")  // campo de contraseña en el formulario
	                .defaultSuccessUrl("/inicio", true)
	                .permitAll()
	            )
	            // configuración de logout
	            .logout(logout -> logout
	                .logoutUrl("/logout")
	                .logoutSuccessUrl("/login?logout")
	                .permitAll()
	            )
	            .exceptionHandling(e -> e.accessDeniedPage("/errors/Error_404"))
	            .userDetailsService(usuarioDetailsService)
	            .build();
    }
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
	


