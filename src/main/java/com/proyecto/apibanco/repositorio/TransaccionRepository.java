package com.proyecto.apibanco.repositorio;

import com.proyecto.apibanco.modelo.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
}
