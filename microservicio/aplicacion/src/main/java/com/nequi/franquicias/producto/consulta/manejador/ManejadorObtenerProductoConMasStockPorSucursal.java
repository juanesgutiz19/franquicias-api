package com.nequi.franquicias.producto.consulta.manejador;

import com.nequi.franquicias.producto.modelo.dto.ProductoSucursalDTO;
import com.nequi.franquicias.producto.servicio.ServicioObtenerProductoConMasStockPorSucursal;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerProductoConMasStockPorSucursal {

    private final ServicioObtenerProductoConMasStockPorSucursal servicioObtenerProductoConMasStockPorSucursal;

    public ManejadorObtenerProductoConMasStockPorSucursal(ServicioObtenerProductoConMasStockPorSucursal servicioObtenerProductoConMasStockPorSucursal) {
        this.servicioObtenerProductoConMasStockPorSucursal = servicioObtenerProductoConMasStockPorSucursal;
    }

    public List<ProductoSucursalDTO> ejecutar(Long idFranquicia) {
        return servicioObtenerProductoConMasStockPorSucursal.ejecutar(idFranquicia);
    }
}
