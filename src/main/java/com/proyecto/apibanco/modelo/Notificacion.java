package com.proyecto.apibanco.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity(name = "notificaciones")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Column(name = "usuario_id")
    @Getter
    @Setter
    private long usuarioId;

    @Column(name = "mensaje")
    @Getter
    @Setter
    private String mensaje;

    @Column(name = "fecha_envio")
    @Getter
    @Setter
    private Timestamp fechaEnvio;

    @Column(name = "leido")
    @Getter
    @Setter
    private int leido;
}
