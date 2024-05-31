package com.proyecto.apibanco.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tarjeta_id", nullable = false)
    @Getter @Setter
    private Tarjeta tarjeta;

    @Column(nullable = false)
    @Getter @Setter
    private BigDecimal monto;

    @Column(nullable = false)
    @Getter @Setter
    private String tipo;

    @Column(name = "fecha_transaccion", nullable = false, updatable = false)
    @Getter @Setter
    private LocalDateTime fechaTransaccion = LocalDateTime.now();
}
