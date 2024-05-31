package com.proyecto.apibanco.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(unique = true, nullable = false)
    @Getter
    @Setter
    private String numeroTarjeta;

    @Column
    @Getter
    @Setter
    private Integer pin;

    @Column(nullable = false)
    @Getter
    @Setter
    private Long usuarioId;

    @Column(nullable = false)
    @Getter
    @Setter
    private Double limiteCredito;

    @Column
    @Getter
    @Setter
    private Double saldoActual;

    @Column(nullable = false)
    @Getter
    @Setter
    private java.sql.Date fechaCorte;

    @Column(nullable = false)
    @Getter
    @Setter
    private String estado;
}
