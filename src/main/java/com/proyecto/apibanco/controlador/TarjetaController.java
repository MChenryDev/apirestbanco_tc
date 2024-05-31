package com.proyecto.apibanco.controlador;

import com.proyecto.apibanco.modelo.Tarjeta;
import com.proyecto.apibanco.servicio.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarjetas")
public class TarjetaController {

    @Autowired
    private TarjetaService tarjetaService;

    @GetMapping
    public List<Tarjeta> obtenerTodasLasTarjetas() {
        return tarjetaService.obtenerTodasLasTarjetas();
    }

    @GetMapping("/{id}")
    public Tarjeta obtenerTarjetaPorId(@PathVariable Long id) {
        return tarjetaService.obtenerTarjetaPorId(id);
    }

    @PostMapping
    public Tarjeta crearTarjeta(@RequestBody Tarjeta tarjeta) {
        return tarjetaService.crearTarjeta(tarjeta);
    }

    @PutMapping("/{id}")
    public Tarjeta actualizarTarjeta(@PathVariable Long id, @RequestBody Tarjeta tarjeta) {
        return tarjetaService.actualizarTarjeta(id, tarjeta);
    }

    @DeleteMapping("/{id}")
    public void eliminarTarjeta(@PathVariable Long id) {
        tarjetaService.eliminarTarjeta(id);
    }

    // DTO para encapsular el monto
    public static class MontoRequest {
        private double monto;

        public double getMonto() {
            return monto;
        }

        public void setMonto(double monto) {
            this.monto = monto;
        }
    }

    // API de Pagos de Tarjeta
    @PostMapping("/{id}/pago")
    public String pagarTarjeta(@PathVariable Long id, @RequestBody MontoRequest montoRequest) {
        return tarjetaService.pagarTarjeta(id, montoRequest.getMonto());
    }

    // API de Consumos
    @PostMapping("/{id}/consumo")
    public String registrarConsumo(@PathVariable Long id, @RequestBody MontoRequest montoRequest) {
        return tarjetaService.registrarConsumo(id, montoRequest.getMonto());
    }

    // API de Consulta de Saldos
    @GetMapping("/{id}/saldos")
    public String consultarSaldos(@PathVariable Long id) {
        return tarjetaService.consultarSaldos(id);
    }

    // API de Consulta de Fecha de Corte
    @GetMapping("/{id}/fechacorte")
    public String consultarFechaDeCorte(@PathVariable Long id) {
        return tarjetaService.consultarFechaDeCorte(id);
    }

    // API de Consulta de Estado de Cuenta
    @GetMapping("/{id}/estadodecuenta")
    public String consultarEstadoDeCuenta(@PathVariable Long id) {
        return tarjetaService.consultarEstadoDeCuenta(id);
    }

    // API de Obtener Detalle de Tarjeta
    @GetMapping("/{id}/detalles")
    public String obtenerDetalleDeTarjeta(@PathVariable Long id) {
        return tarjetaService.obtenerDetalleDeTarjeta(id);
    }


    // DTO para encapsular el nuevoPin
    public static class NuevoPinRequest {
        private int pin;

        public int getPin() {
            return pin;
        }

        public void setPin(int pin) {
            this.pin = pin;
        }
    }
    // API de Cambio de PIN
    @PostMapping("/{id}/cambiarpin")
    public String cambiarPin(@PathVariable Long id, @RequestBody NuevoPinRequest nuevoPinRequest) {
        return tarjetaService.cambiarPin(id, nuevoPinRequest.getPin());
    }

    // API de Bloqueo Temporal
    @PostMapping("/{id}/bloquear")
    public String bloquearTarjeta(@PathVariable Long id) {
        return tarjetaService.bloquearTarjeta(id);
    }

    // API de Solicitud de Aumento de Límite de Crédito
    @PostMapping("/{id}/aumentolimite")
    public String solicitarAumentoLimite(@PathVariable Long id, @RequestBody MontoRequest montoRequest) {
        return tarjetaService.solicitarAumentoLimite(id, montoRequest.getMonto());
    }
}
