package com.labisistemas.gestaofinanceiraapi.repository;

import com.labisistemas.gestaofinanceiraapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
}
