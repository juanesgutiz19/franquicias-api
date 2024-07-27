package com.nequi.franquicias.venta.controlador;

import com.nequi.franquicias.ComandoRespuesta;
import com.nequi.franquicias.venta.comando.ComandoSolicitudRegistrar;
import com.nequi.franquicias.venta.comando.manejador.ManejadorRegistrar;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ventas")
@Tag(name = "Controlador comando venta")
public class ComandoControladorVenta {

    private final ManejadorRegistrar manejadorRegistrar;

    public ComandoControladorVenta(ManejadorRegistrar manejadorRegistrar) {
        this.manejadorRegistrar = manejadorRegistrar;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Registrar venta", description = "Método utilizado para registrar una nueva venta")
    public ComandoRespuesta<Long> registrarVenta(@RequestBody ComandoSolicitudRegistrar comandoSolicitudRegistrar) {
        return manejadorRegistrar.ejecutar(comandoSolicitudRegistrar);
    }
}
