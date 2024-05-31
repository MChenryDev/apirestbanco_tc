package com.proyecto.apibanco.repositorio;

import com.proyecto.apibanco.modelo.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarjetaRepository extends JpaRepository<Tarjeta, Long> {
}
