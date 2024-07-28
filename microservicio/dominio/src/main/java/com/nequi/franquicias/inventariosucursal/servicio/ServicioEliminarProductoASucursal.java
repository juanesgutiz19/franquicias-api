package com.nequi.franquicias.inventariosucursal.servicio;

import com.nequi.franquicias.dominio.excepcion.ExcepcionSinDatos;
import com.nequi.franquicias.inventariosucursal.modelo.entidad.InventarioSucursal;
import com.nequi.franquicias.inventariosucursal.puerto.repositorio.RepositorioInventarioSucursal;
import com.nequi.franquicias.producto.modelo.entidad.Producto;
import com.nequi.franquicias.producto.puerto.repositorio.RepositorioProducto;
import com.nequi.franquicias.sucursal.modelo.entidad.Sucursal;
import com.nequi.franquicias.sucursal.puerto.repositorio.RepositorioSucursal;

import java.util.Optional;

public class ServicioEliminarProductoASucursal {

    private static final String NO_EXISTE_UNA_SUCURSAL_CON_EL_ID = "No existe una sucursal con el id %d";
    private static final String NO_EXISTE_UN_PRODUCTO_CON_EL_ID = "No existe un producto con el id %d";
    private static final String EL_PRODUCTO_CON_ID_NO_ESTA_ASOCIADO_A_LA_SUCURSAL_CON_ID = "El producto con id %d no está asociado a la sucursal con id %d, por lo tanto, no hay nada que eliminar";

    private final RepositorioSucursal repositorioSucursal;
    private final RepositorioProducto repositorioProducto;
    private final RepositorioInventarioSucursal repositorioInventarioSucursal;

    public ServicioEliminarProductoASucursal(RepositorioSucursal repositorioSucursal, RepositorioProducto repositorioProducto, RepositorioInventarioSucursal repositorioInventarioSucursal) {
        this.repositorioSucursal = repositorioSucursal;
        this.repositorioProducto = repositorioProducto;
        this.repositorioInventarioSucursal = repositorioInventarioSucursal;
    }

    public void ejecutar(Long sucursalId, Long productoId) {
        Optional<Sucursal> sucursal = Optional.ofNullable(repositorioSucursal.obtenerPorId(sucursalId));
        Optional<Producto> producto = Optional.ofNullable(repositorioProducto.obtenerPorId(productoId));
        Optional<InventarioSucursal> inventarioSucursal = Optional.ofNullable(repositorioInventarioSucursal.obtenerPorSucursalYProducto(sucursalId, productoId));

        if (sucursal.isEmpty()) {
            throw new ExcepcionSinDatos(String.format(NO_EXISTE_UNA_SUCURSAL_CON_EL_ID, sucursalId));
        }

        if (producto.isEmpty()) {
            throw new ExcepcionSinDatos(String.format(NO_EXISTE_UN_PRODUCTO_CON_EL_ID, productoId));
        }

        if (inventarioSucursal.isEmpty()) {
            throw new ExcepcionSinDatos(String.format(EL_PRODUCTO_CON_ID_NO_ESTA_ASOCIADO_A_LA_SUCURSAL_CON_ID, productoId, sucursalId));
        }

        repositorioInventarioSucursal.eliminarPorSucursalYProducto(sucursalId, productoId);
    }
}
