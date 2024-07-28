package com.nequi.franquicias.inventariosucursal.controlador;

import com.nequi.franquicias.inventariosucursal.comando.ComandoActualizarCantidadStockDeProducto;
import com.nequi.franquicias.inventariosucursal.comando.manejador.ManejadorActualizarCantidadStockDeProducto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventario-sucursales")
@Tag(name = "Controlador comando inventario sucursales")
public class ComandoControladorInventarioSucursal {

    private final ManejadorActualizarCantidadStockDeProducto manejadorActualizarCantidadStockDeProducto;

    public ComandoControladorInventarioSucursal(ManejadorActualizarCantidadStockDeProducto manejadorActualizarCantidadStockDeProducto) {
        this.manejadorActualizarCantidadStockDeProducto = manejadorActualizarCantidadStockDeProducto;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/stock")
    @Operation(summary = "Modificar el stock de un producto", description = "Método utilizado para modificar el stock de un producto")
    public ResponseEntity<?> modificarStockProducto(@RequestBody ComandoActualizarCantidadStockDeProducto comandoActualizarCantidadStockDeProducto) {
        manejadorActualizarCantidadStockDeProducto.ejecutar(comandoActualizarCantidadStockDeProducto);
        return ResponseEntity.noContent().build();
    }

}
