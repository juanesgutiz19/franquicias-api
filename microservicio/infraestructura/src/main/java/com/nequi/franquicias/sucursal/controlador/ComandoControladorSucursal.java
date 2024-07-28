package com.nequi.franquicias.sucursal.controlador;

import com.nequi.franquicias.ComandoRespuesta;
import com.nequi.franquicias.inventariosucursal.comando.ComandoAgregarNuevoProductoASucursal;
import com.nequi.franquicias.inventariosucursal.comando.manejador.ManejadorAgregarNuevoProductoASucursal;
import com.nequi.franquicias.inventariosucursal.comando.manejador.ManejadorEliminarProductoASucursal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sucursales")
@Tag(name = "Controlador comando sucursales")
public class ComandoControladorSucursal {

    private final ManejadorAgregarNuevoProductoASucursal manejadorAgregarNuevoProductoASucursal;
    private final ManejadorEliminarProductoASucursal manejadorEliminarProductoASucursal;

    public ComandoControladorSucursal(ManejadorAgregarNuevoProductoASucursal manejadorAgregarNuevoProductoASucursal, ManejadorEliminarProductoASucursal manejadorEliminarProductoASucursal) {
        this.manejadorAgregarNuevoProductoASucursal = manejadorAgregarNuevoProductoASucursal;
        this.manejadorEliminarProductoASucursal = manejadorEliminarProductoASucursal;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{idSucursal}/productos")
    @Operation(summary = "Agregar nuevo producto a sucursal", description = "Método utilizado para agregar nuevo producto a sucursal")
    public ComandoRespuesta<Long> agregarNuevoProductoASucursal(@PathVariable Long idSucursal,
                                                                @RequestBody ComandoAgregarNuevoProductoASucursal comandoAgregarNuevoProductoASucursal) {
        return this.manejadorAgregarNuevoProductoASucursal.ejecutar(idSucursal, comandoAgregarNuevoProductoASucursal);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{idSucursal}/productos/{idProducto}")
    @Operation(summary = "Eliminar producto a sucursal", description = "Método utilizado para eliminar un producto a una sucursal")
    public ResponseEntity<?> eliminarProductoASucursal(@PathVariable Long idSucursal,
                                                       @PathVariable Long idProducto) {
        manejadorEliminarProductoASucursal.ejecutar(idSucursal, idProducto);
        return ResponseEntity.noContent().build();
    }

}