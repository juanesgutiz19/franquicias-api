package com.nequi.franquicias.producto.controlador;

import com.nequi.franquicias.producto.comando.ComandoActualizarNombreProducto;
import com.nequi.franquicias.producto.comando.manejador.ManejadorActualizarNombreProducto;
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
@RequestMapping("/productos")
@Tag(name = "Controlador comando productos")
public class ComandoControladorProducto {

    private final ManejadorActualizarNombreProducto manejadorActualizarNombreProducto;

    public ComandoControladorProducto(ManejadorActualizarNombreProducto manejadorActualizarNombreProducto) {
        this.manejadorActualizarNombreProducto = manejadorActualizarNombreProducto;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/nombre")
    @Operation(summary = "Modificar el nombre de un producto", description = "Método utilizado para modificar el nombre de un producto")
    public ResponseEntity<?> modificarNombreProducto(@RequestBody ComandoActualizarNombreProducto comandoActualizarNombreProducto) {
        manejadorActualizarNombreProducto.ejecutar(comandoActualizarNombreProducto);
        return ResponseEntity.noContent().build();
    }


}
