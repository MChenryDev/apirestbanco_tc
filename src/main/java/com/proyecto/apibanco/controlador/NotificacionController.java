package com.proyecto.apibanco.controlador;

import com.proyecto.apibanco.modelo.Notificacion;
import com.proyecto.apibanco.servicio.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @GetMapping("/usuario/{usuarioId}")
    public List<Notificacion> obtenerNotificacionesPorUsuarioId(@PathVariable long usuarioId) {
        return notificacionService.obtenerNotificacionesPorUsuarioId(usuarioId);
    }

    @PostMapping
    public Notificacion crearNotificacion(@RequestBody Notificacion notificacion) {
        return notificacionService.crearNotificacion(notificacion);
    }

    @PutMapping("/{id}")
    public Notificacion actualizarNotificacion(@PathVariable long id, @RequestBody Notificacion notificacion) {
        notificacion.setId(id);
        return notificacionService.actualizarNotificacion(notificacion);
    }

    @DeleteMapping("/{id}")
    public void eliminarNotificacion(@PathVariable long id) {
        notificacionService.eliminarNotificacion(id);
    }

    @PutMapping("/{id}/marcarComoLeida")
    public void marcarComoLeida(@PathVariable long id) {
        notificacionService.marcarComoLeida(id);
    }
}
