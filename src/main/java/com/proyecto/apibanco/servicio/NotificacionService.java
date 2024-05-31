package com.proyecto.apibanco.servicio;

import com.proyecto.apibanco.modelo.Notificacion;
import com.proyecto.apibanco.repositorio.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    public List<Notificacion> obtenerNotificacionesPorUsuarioId(long usuarioId) {
        return notificacionRepository.findByUsuarioId(usuarioId);
    }

    public Notificacion crearNotificacion(Notificacion notificacion) {
        notificacion.setFechaEnvio(new Timestamp(System.currentTimeMillis()));
        return notificacionRepository.save(notificacion);
    }

    public Notificacion actualizarNotificacion(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    public void eliminarNotificacion(long id) {
        notificacionRepository.deleteById(id);
    }

    public void marcarComoLeida(long id) {
        Notificacion notificacion = notificacionRepository.findById(id).orElseThrow();
        notificacion.setLeido(1);
        notificacionRepository.save(notificacion);
    }
}

