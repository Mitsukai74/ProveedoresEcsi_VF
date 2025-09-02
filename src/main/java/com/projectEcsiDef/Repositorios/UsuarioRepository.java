package com.projectEcsiDef.Repositorios;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.projectEcsiDef.Entidades.Users;

public interface UsuarioRepository extends CrudRepository<Users,Long> {
	Optional<Users> findByCorreo(String correo);
}
