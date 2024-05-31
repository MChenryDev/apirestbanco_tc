package com.proyecto.apibanco.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class EstadoDeCuenta {
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
    private LocalDate fechaCorte;

    @Column(nullable = false)
    @Getter @Setter
    private BigDecimal saldoAlCorte;

    @Getter @Setter
    private BigDecimal montoPagado = BigDecimal.ZERO;

    @Column(name = "fecha_generacion", nullable = false, updatable = false)
    @Getter @Setter
    private LocalDateTime fechaGeneracion = LocalDateTime.now();
}
