package com.proyecto.apibanco.repositorio;

import com.proyecto.apibanco.modelo.EstadoDeCuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoDeCuentaRepository extends JpaRepository<EstadoDeCuenta, Long> {
}
