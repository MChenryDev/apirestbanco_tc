package com.proyecto.apibanco.repositorio;

import com.proyecto.apibanco.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
