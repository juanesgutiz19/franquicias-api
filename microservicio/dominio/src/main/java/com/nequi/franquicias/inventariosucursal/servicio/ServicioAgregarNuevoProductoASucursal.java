package com.nequi.franquicias.inventariosucursal.servicio;

import com.nequi.franquicias.dominio.excepcion.ExcepcionSinDatos;
import com.nequi.franquicias.inventariosucursal.modelo.entidad.InventarioSucursal;
import com.nequi.franquicias.inventariosucursal.puerto.repositorio.RepositorioInventarioSucursal;
import com.nequi.franquicias.producto.modelo.entidad.Producto;
import com.nequi.franquicias.producto.puerto.repositorio.RepositorioProducto;
import com.nequi.franquicias.sucursal.modelo.entidad.Sucursal;

import java.util.Optional;

public class ServicioAgregarNuevoProductoASucursal {

    private static final String NO_EXISTE_UNA_SUCURSAL_CON_EL_ID_INGRESADO = "No existe una sucursal con el id ingresado";

    private final RepositorioProducto repositorioProducto;
    private final RepositorioInventarioSucursal repositorioInventarioSucursal;

    public ServicioAgregarNuevoProductoASucursal(RepositorioProducto repositorioProducto, RepositorioInventarioSucursal repositorioInventarioSucursal) {
        this.repositorioProducto = repositorioProducto;
        this.repositorioInventarioSucursal = repositorioInventarioSucursal;
    }

    public Long ejecutar(InventarioSucursal inventarioSucursal) {
        Optional<Sucursal> sucursal = Optional.ofNullable(inventarioSucursal.getSucursal());

        if (sucursal.isEmpty()) {
            throw new ExcepcionSinDatos(NO_EXISTE_UNA_SUCURSAL_CON_EL_ID_INGRESADO);
        }

        Long productoCreado = repositorioProducto.guardar(Producto.crear(inventarioSucursal.getProducto()));
        inventarioSucursal.setProducto(new Producto(productoCreado));

        return repositorioInventarioSucursal.guardar(InventarioSucursal.crear(inventarioSucursal));
    }
}
