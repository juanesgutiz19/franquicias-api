package com.nequi.franquicias.producto.servicio;

import com.nequi.franquicias.dominio.excepcion.ExcepcionSinDatos;
import com.nequi.franquicias.producto.modelo.entidad.Producto;
import com.nequi.franquicias.producto.puerto.repositorio.RepositorioProducto;

import java.util.Optional;

public class ServicioActualizarNombreProducto {

    private static final String NO_EXISTE_UN_PRODUCTO_CON_EL_ID = "No existe un producto con el id %d";

    private final RepositorioProducto repositorioProducto;

    public ServicioActualizarNombreProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public void ejecutar(Producto producto) {
        Optional<Producto> productoRecuperado = Optional.ofNullable(repositorioProducto.obtenerPorId(producto.getId()));

        if (productoRecuperado.isEmpty()) {
            throw new ExcepcionSinDatos(String.format(NO_EXISTE_UN_PRODUCTO_CON_EL_ID, producto.getId()));
        }

        repositorioProducto.actualizarNombre(producto);
    }

}
