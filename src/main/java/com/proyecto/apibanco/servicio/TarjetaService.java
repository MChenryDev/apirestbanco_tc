package com.proyecto.apibanco.servicio;

import com.proyecto.apibanco.modelo.Tarjeta;
import com.proyecto.apibanco.repositorio.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarjetaService {

    @Autowired
    private TarjetaRepository tarjetaRepository;

    public List<Tarjeta> obtenerTodasLasTarjetas() {
        return tarjetaRepository.findAll();
    }

    public Tarjeta obtenerTarjetaPorId(Long id) {
        return tarjetaRepository.findById(id).orElse(null);
    }

    public Tarjeta crearTarjeta(Tarjeta tarjeta) {
        return tarjetaRepository.save(tarjeta);
    }

    public Tarjeta actualizarTarjeta(Long id, Tarjeta tarjeta) {
        Tarjeta tarjetaExistente = tarjetaRepository.findById(id).orElse(null);
        if (tarjetaExistente != null) {
            tarjetaExistente.setNumeroTarjeta(tarjeta.getNumeroTarjeta());
            tarjetaExistente.setPin(tarjeta.getPin());
            tarjetaExistente.setUsuarioId(tarjeta.getUsuarioId());
            tarjetaExistente.setLimiteCredito(tarjeta.getLimiteCredito());
            tarjetaExistente.setSaldoActual(tarjeta.getSaldoActual());
            tarjetaExistente.setFechaCorte(tarjeta.getFechaCorte());
            tarjetaExistente.setEstado(tarjeta.getEstado());
            return tarjetaRepository.save(tarjetaExistente);
        } else {
            return null;
        }
    }

    public void eliminarTarjeta(Long id) {
        tarjetaRepository.deleteById(id);
    }

    public String pagarTarjeta(Long id, double monto) {
        Tarjeta tarjeta = tarjetaRepository.findById(id).orElse(null);
        if (tarjeta != null) {
            tarjeta.setSaldoActual(tarjeta.getSaldoActual() - monto);
            tarjetaRepository.save(tarjeta);
            return "Pago realizado exitosamente.";
        } else {
            return "Tarjeta no encontrada.";
        }
    }

    public String registrarConsumo(Long id, double monto) {
        Tarjeta tarjeta = tarjetaRepository.findById(id).orElse(null);
        if (tarjeta != null) {
            tarjeta.setSaldoActual(tarjeta.getSaldoActual() + monto);
            tarjetaRepository.save(tarjeta);
            return "Consumo registrado exitosamente.";
        } else {
            return "Tarjeta no encontrada.";
        }
    }

    public String consultarSaldos(Long id) {
        Tarjeta tarjeta = tarjetaRepository.findById(id).orElse(null);
        if (tarjeta != null) {
            return "Saldo actual: " + tarjeta.getSaldoActual() +
                    ", Saldo disponible: " + (tarjeta.getLimiteCredito() - tarjeta.getSaldoActual()) +
                    ", Saldo al corte: " + tarjeta.getSaldoActual();
        } else {
            return "Tarjeta no encontrada.";
        }
    }

    public String consultarFechaDeCorte(Long id) {
        Tarjeta tarjeta = tarjetaRepository.findById(id).orElse(null);
        if (tarjeta != null) {
            return "Fecha de corte: " + tarjeta.getFechaCorte().toString();
        } else {
            return "Tarjeta no encontrada.";
        }
    }

    public String consultarEstadoDeCuenta(Long id) {
        Tarjeta tarjeta = tarjetaRepository.findById(id).orElse(null);
        if (tarjeta != null) {
            return "Estado de cuenta para la tarjeta con ID " + id +
                    "\nTarjeta No: " + tarjeta.getNumeroTarjeta() +
                    "\nSaldo actual: " + tarjeta.getSaldoActual() +
                    "\nSaldo disponible: " + (tarjeta.getLimiteCredito() - tarjeta.getSaldoActual());
        } else {
            return "Tarjeta no encontrada.";
        }
    }

    public String obtenerDetalleDeTarjeta(Long id) {
        Tarjeta tarjeta = tarjetaRepository.findById(id).orElse(null);
        if (tarjeta != null) {
            return "Detalles de la tarjeta: " +
                    "\nSaldo actual: " + tarjeta.getSaldoActual() +
                    "\nSaldo disponible: " + (tarjeta.getLimiteCredito() - tarjeta.getSaldoActual()) +
                    "\nFecha de corte: " + tarjeta.getFechaCorte().toString() +
                    "\nEstado: " + tarjeta.getEstado();
        } else {
            return "Tarjeta no encontrada.";
        }
    }

    public String cambiarPin(Long id, int nuevoPin) {
        Tarjeta tarjeta = tarjetaRepository.findById(id).orElse(null);
        if (tarjeta != null) {
            tarjeta.setPin(nuevoPin);
            tarjetaRepository.save(tarjeta);
            return "PIN cambiado exitosamente.";
        } else {
            return "Tarjeta no encontrada.";
        }
    }

    public String bloquearTarjeta(Long id) {
        Tarjeta tarjeta = tarjetaRepository.findById(id).orElse(null);
        if (tarjeta != null) {
            tarjeta.setEstado("B");
            tarjetaRepository.save(tarjeta);
            return "Tarjeta bloqueada exitosamente.";
        } else {
            return "Tarjeta no encontrada.";
        }
    }

    public String solicitarAumentoLimite(Long id, double monto) {
        return "Solicitud de aumento de límite de crédito para la tarjeta con ID " + id + " por el monto de " + monto;
    }
}

