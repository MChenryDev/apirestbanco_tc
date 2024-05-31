package com.proyecto.apibanco.repositorio;

import com.proyecto.apibanco.modelo.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    List<Notificacion> findByUsuarioId(long usuarioId);
}

