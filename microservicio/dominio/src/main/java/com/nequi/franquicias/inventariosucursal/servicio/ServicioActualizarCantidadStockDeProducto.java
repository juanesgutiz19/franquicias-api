package com.nequi.franquicias.inventariosucursal.servicio;

import com.nequi.franquicias.inventariosucursal.modelo.entidad.InventarioSucursal;
import com.nequi.franquicias.inventariosucursal.puerto.repositorio.RepositorioInventarioSucursal;

public class ServicioActualizarCantidadStockDeProducto {

    private final RepositorioInventarioSucursal repositorioInventarioSucursal;
    private final ServicioValidarSucursalYProducto servicioValidarSucursalYProducto;

    public ServicioActualizarCantidadStockDeProducto(RepositorioInventarioSucursal repositorioInventarioSucursal, ServicioValidarSucursalYProducto servicioValidarSucursalYProducto) {
        this.repositorioInventarioSucursal = repositorioInventarioSucursal;
        this.servicioValidarSucursalYProducto = servicioValidarSucursalYProducto;
    }

    public void ejecutar(InventarioSucursal inventarioSucursal) {
        servicioValidarSucursalYProducto.ejecutar(inventarioSucursal.getSucursal().getId(), inventarioSucursal.getProducto().getId());
        repositorioInventarioSucursal.actualizarStock(InventarioSucursal.actualizarCantidadStock(inventarioSucursal));
    }
}
