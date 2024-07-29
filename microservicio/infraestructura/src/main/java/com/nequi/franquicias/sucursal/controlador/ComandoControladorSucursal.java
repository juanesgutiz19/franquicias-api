package com.nequi.franquicias.sucursal.controlador;

import com.nequi.franquicias.ComandoRespuesta;
import com.nequi.franquicias.inventariosucursal.comando.ComandoAgregarNuevoProductoASucursal;
import com.nequi.franquicias.inventariosucursal.comando.manejador.ManejadorAgregarNuevoProductoASucursal;
import com.nequi.franquicias.inventariosucursal.comando.manejador.ManejadorEliminarProductoASucursal;
import com.nequi.franquicias.sucursal.comando.ComandoActualizarNombreSucursal;
import com.nequi.franquicias.sucursal.comando.manejador.ManejadorActualizarNombreSucursal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    private final ManejadorActualizarNombreSucursal manejadorActualizarNombreSucursal;

    public ComandoControladorSucursal(ManejadorAgregarNuevoProductoASucursal manejadorAgregarNuevoProductoASucursal, ManejadorEliminarProductoASucursal manejadorEliminarProductoASucursal, ManejadorActualizarNombreSucursal manejadorActualizarNombreSucursal) {
        this.manejadorAgregarNuevoProductoASucursal = manejadorAgregarNuevoProductoASucursal;
        this.manejadorEliminarProductoASucursal = manejadorEliminarProductoASucursal;
        this.manejadorActualizarNombreSucursal = manejadorActualizarNombreSucursal;
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

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/nombre")
    @Operation(summary = "Modificar el nombre de una sucursal", description = "Método utilizado para modificar el nombre de una sucursal")
    public ResponseEntity<?> modificarNombreSucursal(@RequestBody ComandoActualizarNombreSucursal comandoActualizarNombreSucursal) {
        manejadorActualizarNombreSucursal.ejecutar(comandoActualizarNombreSucursal);
        return ResponseEntity.noContent().build();
    }

}