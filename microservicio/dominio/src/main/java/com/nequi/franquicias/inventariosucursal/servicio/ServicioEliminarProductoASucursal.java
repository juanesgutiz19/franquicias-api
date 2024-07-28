package com.nequi.franquicias.inventariosucursal.servicio;

import com.nequi.franquicias.inventariosucursal.puerto.repositorio.RepositorioInventarioSucursal;

public class ServicioEliminarProductoASucursal {

    private final RepositorioInventarioSucursal repositorioInventarioSucursal;
    private final ServicioValidarSucursalYProducto servicioValidarSucursalYProducto;

    public ServicioEliminarProductoASucursal(RepositorioInventarioSucursal repositorioInventarioSucursal, ServicioValidarSucursalYProducto servicioValidarSucursalYProducto) {
        this.repositorioInventarioSucursal = repositorioInventarioSucursal;
        this.servicioValidarSucursalYProducto = servicioValidarSucursalYProducto;
    }

    public void ejecutar(Long sucursalId, Long productoId) {
        servicioValidarSucursalYProducto.ejecutar(sucursalId, productoId);
        repositorioInventarioSucursal.eliminarPorSucursalYProducto(sucursalId, productoId);
    }
}
