package com.nequi.franquicias.franquicia.controlador;

import com.nequi.franquicias.producto.consulta.manejador.ManejadorObtenerProductoConMasStockPorSucursal;
import com.nequi.franquicias.producto.modelo.dto.ProductoSucursalDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/franquicias")
@Tag(name = "Controlador comando franquicias")
public class ConsultaControladorFranquicia {

    private final ManejadorObtenerProductoConMasStockPorSucursal manejadorObtenerProductoConMasStockPorSucursal;

    public ConsultaControladorFranquicia(ManejadorObtenerProductoConMasStockPorSucursal manejadorObtenerProductoConMasStockPorSucursal) {
        this.manejadorObtenerProductoConMasStockPorSucursal = manejadorObtenerProductoConMasStockPorSucursal;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{idFranquicia}/sucursales/productos-mayor-stock")
    @Operation(summary = "Obtener producto con más stock por sucursal", description = "Método que permite mostrar cual es el producto que más stock tiene por sucursal para una franquicia puntual")
    public List<ProductoSucursalDTO> obtenerProductoConMasStockPorSucursal(@PathVariable Long idFranquicia) {
        return this.manejadorObtenerProductoConMasStockPorSucursal.ejecutar(idFranquicia);
    }
}
