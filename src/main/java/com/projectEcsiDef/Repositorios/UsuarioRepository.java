package com.projectEcsiDef.Repositorios;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectEcsiDef.Entidades.Users;


public interface UsuarioRepository extends JpaRepository<Users,Integer> {
	Optional<Users> findByCorreo(String correo);
}
