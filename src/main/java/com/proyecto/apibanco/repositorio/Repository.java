package com.proyecto.apibanco.repositorio;

import com.proyecto.apibanco.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Persona, Long> {
}
