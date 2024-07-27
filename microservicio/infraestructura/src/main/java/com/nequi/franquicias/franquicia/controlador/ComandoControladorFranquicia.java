package com.nequi.franquicias.franquicia.controlador;

import com.nequi.franquicias.ComandoRespuesta;
import com.nequi.franquicias.franquicia.comando.ComandoCrearFranquicia;
import com.nequi.franquicias.franquicia.comando.manejador.ManejadorCrearFranquicia;
import com.nequi.franquicias.sucursal.comando.ComandoCrearSucursal;
import com.nequi.franquicias.sucursal.comando.manejador.ManejadorCrearSucursal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/franquicias")
@Tag(name = "Controlador comando franquicias")
public class ComandoControladorFranquicia {

    private final ManejadorCrearFranquicia manejadorCrear;
    private final ManejadorCrearSucursal manejadorCrearSucursal;

    public ComandoControladorFranquicia(ManejadorCrearFranquicia manejadorCrearFranquicia, ManejadorCrearSucursal manejadorCrearSucursal) {
        this.manejadorCrear = manejadorCrearFranquicia;
        this.manejadorCrearSucursal = manejadorCrearSucursal;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear franquicia", description = "Método utilizado para crear una nueva franquicia")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCrearFranquicia comandoCrearFranquicia) {
        return this.manejadorCrear.ejecutar(comandoCrearFranquicia);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{idFranquicia}/sucursales")
    @Operation(summary = "Agregar sucursal a franquicia", description = "Método utilizado para agregar una nueva sucuesal a una franquicia")
    public ComandoRespuesta<Long> agregarSucursal(@PathVariable Long idFranquicia, @RequestBody ComandoCrearSucursal comandoCrearSucursal) {
        return this.manejadorCrearSucursal.ejecutar(idFranquicia, comandoCrearSucursal);
    }
}
